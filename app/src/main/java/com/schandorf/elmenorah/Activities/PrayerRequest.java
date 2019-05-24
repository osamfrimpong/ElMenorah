package com.schandorf.elmenorah.Activities;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.schandorf.elmenorah.Fragments.RetrofitInterface;
import com.schandorf.elmenorah.POJO.PrayerRequestResponse;
import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.RetrofitService;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrayerRequest extends AppCompatActivity {


    TextInputEditText name;
    TextInputEditText contact;
    TextInputEditText request;
    Button sendRequest;
    PrayerRequestResponse prayerRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_request);
        this.setTitle("Prayer Request");
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        request = findViewById(R.id.request);
        sendRequest = findViewById(R.id.sendRequest);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate
                if(!(isTextEmpty(contact) && isTextEmpty(request)))
                {
                   // progressdialog.show();
                    Toast.makeText(PrayerRequest.this, "Submitting... Please Wait.", Toast.LENGTH_LONG).show();
                    HashMap<String,String> fields = new HashMap<>();
                    fields.put("request",request.getText().toString());
                    fields.put("name",name.getText().toString());
                    fields.put("contact",contact.getText().toString());
                    RetrofitInterface retrofitinterface = RetrofitService.getClient().create(RetrofitInterface.class);
                    Call<PrayerRequestResponse> call = retrofitinterface.getPrayerRequestResponse(fields);
                        call.enqueue(new Callback<PrayerRequestResponse>() {
                            @Override
                            public void onResponse(Call<PrayerRequestResponse> call, Response<PrayerRequestResponse> response) {
                                if(response.isSuccessful())
                                {
                                    prayerRequest = response.body();
                                    if(prayerRequest.getResponse())
                                    {
                                        Toast.makeText(PrayerRequest.this, "Request Successfully Sent", Toast.LENGTH_LONG).show();
                                        name.setText("");
                                        contact.setText("");
                                        request.setText("");
                                    }
                                    else
                                    {
                                        Toast.makeText(PrayerRequest.this, "Request Unsuccessful", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<PrayerRequestResponse> call, Throwable t) {
                                Toast.makeText(PrayerRequest.this, "Request Unsuccessful. Check Internet and Try Again.", Toast.LENGTH_LONG).show();
                            }
                        });
                    // Toast.makeText(this, "field not empty", Toast.LENGTH_SHORT).show();
                }

                else {
                    Toast.makeText(PrayerRequest.this, "Phone Number or Prayer Request cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public boolean isTextEmpty(TextInputEditText textInputEditText)
    {
        return TextUtils.isEmpty(textInputEditText.getText());
    }
}
