package com.schandorf.elmenorah.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.DbHelper;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.HomeActivity;
import com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO;
import com.schandorf.elmenorah.R;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

public class LoginActivity extends AppCompatActivity {


    @InjectView(R.id.message)
    TextView message;
    @InjectView(R.id.username)
    EditText username;
    @InjectView(R.id.loginpassword)
    EditText loginpassword;
    @InjectView(R.id.login)
    Button login;
    @InjectView(R.id.clickToSignup)
    TextView clickToSignup;
    Realm realm;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        FontChangeCrawler fontChangeCrawler = new FontChangeCrawler(getAssets(), Constants.FONT_NAME);
        fontChangeCrawler.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));
        if (!hasUserSignedUp())
        {
            Intent toSignUp = new Intent(this,SignUpActivity.class);
            startActivity(toSignUp);
            this.finish();
        }
        else
        {
            if(isUserLoggedIn())
            {
                moveToHome();
            }
        }
        Intent getSignUpIntent = getIntent();
        if(getSignUpIntent.hasExtra("message"))
        {
            message.setVisibility(View.VISIBLE);
            message.setText(getSignUpIntent.getStringExtra("message"));
        }

    }


    @OnClick({R.id.login, R.id.clickToSignup})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if(isFieldEmpty(username) || isFieldEmpty(loginpassword))
                {
                    Toast.makeText(this, "Fill All fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //do login
                    doLogin(getText(username),getText(loginpassword));
                }
                break;
            case R.id.clickToSignup:
                Intent toSignUp = new Intent(this,SignUpActivity.class);
                startActivity(toSignUp);
              //  this.finish();
                break;
        }
    }

    private void moveToHome()
    {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
        this.finish();
    }

    private  boolean hasUserSignedUp()
    {
        dbHelper = new DbHelper("app_registration",this);
        realm = dbHelper.startRealm();
        RealmResults<AppRegistrationDataPOJO> info = realm.where(AppRegistrationDataPOJO.class).findAll();
        return info.size() > 0;
    }

    private boolean isFieldEmpty(EditText editText)
    {
        String fieldText = editText.getText().toString().trim();
        return TextUtils.isEmpty(fieldText);
    }

    private String getText(EditText editText)
    {
        return editText.getText().toString().trim();
    }

    private void doLogin(String username, String password)
    {

        final String dbUsername = getFromDb().get(0).getName().trim();
        String dbPassword = getFromDb().get(0).getPassword().trim();


            if(username.equals(dbUsername) && password.equals(dbPassword))
            {
                //update logged in
                dbHelper = new DbHelper("app_registration",this);
                realm = dbHelper.startRealm();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        AppRegistrationDataPOJO loginData = realm.where(AppRegistrationDataPOJO.class).equalTo("name",dbUsername).findFirst();
                        loginData.setLoggedIn(true);
                        realm.insertOrUpdate(loginData);
                        moveToHome();
                    }
                });
            }
            else
            {
                Toast.makeText(this, "Login Unsuccessful. Check Login Details or Create Account", Toast.LENGTH_SHORT).show();
            }

    }

    private RealmResults<AppRegistrationDataPOJO> getFromDb()
    {
        dbHelper = new DbHelper("app_registration",this);
        realm = dbHelper.startRealm();
        return realm.where(AppRegistrationDataPOJO.class).findAll();
    }

    private boolean isUserLoggedIn()
    {
        dbHelper = new DbHelper("app_registration",this);
        realm = dbHelper.startRealm();
        RealmResults<AppRegistrationDataPOJO> data = realm.where(AppRegistrationDataPOJO.class).findAll();
        return data.get(0).isLoggedIn();
    }
}
