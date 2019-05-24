package com.schandorf.elmenorah.Activities;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.schandorf.elmenorah.Fragments.RetrofitInterface;
import com.schandorf.elmenorah.Helpers.Constants;
import com.schandorf.elmenorah.Helpers.DbHelper;
import com.schandorf.elmenorah.Helpers.FontChangeCrawler;
import com.schandorf.elmenorah.POJO.AppRegistrationDataPOJO;
import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.RegistrationPOJO;
import com.schandorf.elmenorah.RetrofitService;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {


    HashMap<String, String> registration_details = new HashMap<>();
    @InjectView(R.id.name)
    EditText name;
    @InjectView(R.id.username)
    EditText username;
    @InjectView(R.id.email)
    EditText email;
    @InjectView(R.id.sigup_gender)
    EditText sigupGender;
    @InjectView(R.id.date_of_birth)
    EditText dateOfBirth;
    @InjectView(R.id.password)
    EditText password;
    @InjectView(R.id.signup)
    Button signup;
    DbHelper dbHelper;
    Realm realm;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.inject(this);

        FontChangeCrawler fontChangeCrawler = new FontChangeCrawler(getAssets(), Constants.FONT_NAME);
        fontChangeCrawler.replaceFonts((ViewGroup) this.findViewById(android.R.id.content));
    }


    @OnClick({R.id.sigup_gender, R.id.date_of_birth, R.id.signup})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sigup_gender:
                String[] gender = {"Male","Female"};
                openDialog("Gender",gender,sigupGender);
                break;
            case R.id.date_of_birth:
                int startYear;
                int startMonth;
                int startDay;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    calendar = Calendar.getInstance(TimeZone.getDefault());
                    startYear = calendar.get(Calendar.YEAR);
                    startMonth = calendar.get(Calendar.MONTH);
                    startDay = calendar.get(Calendar.DAY_OF_MONTH);
                }
                else {
                     startYear = 1990;
                     startMonth = 0;
                     startDay = 1;
                }
                final String dobSeparator = "-";
               DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                       String dob = year + dobSeparator + (month + 1) + dobSeparator + dayOfMonth;
                       dateOfBirth.setText(dob);
                   }
               },startYear,startMonth,startDay);
                datePickerDialog.show();
                break;
            case R.id.signup:
                    doRegistration();
                break;
        }
    }

    private void openDialog(String title, final String[] options, final EditText editText)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setSingleChoiceItems(options, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText.setText(options[which]);
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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

    private void doRegistration()
    {
        if(isFieldEmpty(name) || isFieldEmpty(username) || isFieldEmpty(email) || isFieldEmpty(sigupGender) || isFieldEmpty(dateOfBirth) || isFieldEmpty(password))
        {
            Toast.makeText(this, "No Field Must Be Empty", Toast.LENGTH_LONG).show();

        }
        else
        {

            AlertDialog.Builder progressBuilder = new AlertDialog.Builder(this);
            progressBuilder.setCancelable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                progressBuilder.setView(R.layout.progress_bar);
            }
            final AlertDialog progress = progressBuilder.create();
            progress.show();
            registration_details.put("name",getText(name));
            registration_details.put("username",getText(username));
            registration_details.put("email",getText(email));
            registration_details.put("gender",getText(sigupGender));
            registration_details.put("dob",getText(dateOfBirth));
            registration_details.put("password",getText(password));

            RetrofitInterface retrofitInterface = RetrofitService.getClient().create(RetrofitInterface.class);
            Call<RegistrationPOJO> appRegisterCall = retrofitInterface.registerForApp(registration_details);
            appRegisterCall.enqueue(new Callback<RegistrationPOJO>() {
                @Override
                public void onResponse(@NonNull Call<RegistrationPOJO> call, @NonNull Response<RegistrationPOJO> response) {
                    if(progress.isShowing())
                    {
                        progress.dismiss();
                    }
                    if(response.isSuccessful())
                    {
                        RegistrationPOJO registrationPojo = response.body();
                        assert registrationPojo != null;
                        switch (registrationPojo.getSuccessResponse())
                        {
                            case "0":
                                Toast.makeText(getApplicationContext(), "Could Not Register.. Try Again", Toast.LENGTH_LONG).show();
                                break;
                            case "1":
                                //insert into realm database
                                insertToDatabase(getText(username),getText(password),false,getText(name),getText(email),getText(sigupGender),getText(dateOfBirth));
                                break;
                            case "2":
                                Toast.makeText(getApplicationContext(), "You Have already Registered..", Toast.LENGTH_LONG).show();
                                break;


                        }


                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "We Could Not Create Account, Please Try Again!", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<RegistrationPOJO> call, @NonNull Throwable t) {
                    if(progress.isShowing())
                    {
                        progress.dismiss();
                    }
                    Toast.makeText(SignUpActivity.this, "We Could Not Create Account, Please Check Internet and Try Again!", Toast.LENGTH_LONG).show();
                  // insertToDatabase(getText(username),getText(password),false,getText(name),getText(email),getText(sigupGender),getText(dateOfBirth));
                }
            });
        }
    }

    private void insertToDatabase(final String name, final String password, final boolean loggedIn, final String fullname, final String email, final String gender, final String dateOfBirth)
    {
        dbHelper = new DbHelper("app_registration",SignUpActivity.this);
        realm = dbHelper.startRealm();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                AppRegistrationDataPOJO appRegistrationInfo = new AppRegistrationDataPOJO();
                appRegistrationInfo.setName(name);
                appRegistrationInfo.setPassword(password);
                appRegistrationInfo.setLoggedIn(loggedIn);
                appRegistrationInfo.setFullname(fullname);
                appRegistrationInfo.setEmail(email);
                appRegistrationInfo.setGender(gender);
                appRegistrationInfo.setDateOfBirth(dateOfBirth);
                realm.where(AppRegistrationDataPOJO.class).findAll().deleteAllFromRealm();
                realm.copyToRealmOrUpdate(appRegistrationInfo);

                //check if inserted into database

                RealmResults<AppRegistrationDataPOJO> results = realm.where(AppRegistrationDataPOJO.class).findAll();

                if(results.size() > 0)
                {
                   // Toast.makeText(SignUpActivity.this, results.toString(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                    intent.putExtra("message","Successfully Registered. Please Login");
                    SignUpActivity.this.startActivity(intent);
                    SignUpActivity.this.finish();
                }

            }
        });
    }
}
