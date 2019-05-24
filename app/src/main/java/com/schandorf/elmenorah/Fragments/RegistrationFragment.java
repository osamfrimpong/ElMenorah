package com.schandorf.elmenorah.Fragments;


import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.schandorf.elmenorah.R;
import com.schandorf.elmenorah.RegistrationPOJO;
import com.schandorf.elmenorah.RetrofitService;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {


    @InjectView(R.id.surname)
    EditText surname;
    @InjectView(R.id.surnameLayout)
    TextInputLayout surnameLayout;
    @InjectView(R.id.othernames)
    EditText othernames;
    @InjectView(R.id.textInputLayout)
    TextInputLayout textInputLayout;
    @InjectView(R.id.dateofbirth)
    EditText dateofbirth;
    @InjectView(R.id.dateofbirthLayout)
    TextInputLayout dateofbirthLayout;
    @InjectView(R.id.classification)
    EditText classification;
    @InjectView(R.id.classificationLayout)
    TextInputLayout classificationLayout;
    @InjectView(R.id.gender)
    EditText gender;
    @InjectView(R.id.genderLayout)
    TextInputLayout genderLayout;
    @InjectView(R.id.phone)
    EditText phone;
    @InjectView(R.id.phoneLayout)
    TextInputLayout phoneLayout;
    @InjectView(R.id.city)
    EditText city;
    @InjectView(R.id.citylayout)
    TextInputLayout citylayout;
    @InjectView(R.id.nationality)
    EditText nationality;
    @InjectView(R.id.nationalitylayout)
    TextInputLayout nationalitylayout;
    @InjectView(R.id.churchtemple)
    EditText churchtemple;
    @InjectView(R.id.churchtemplelayout)
    TextInputLayout churchtemplelayout;
    @InjectView(R.id.otherchurch)
    EditText otherchurch;
    @InjectView(R.id.otherchurchlayout)
    TextInputLayout otherchurchlayout;
    @InjectView(R.id.anyhealth)
    EditText anyhealth;
    @InjectView(R.id.anyhealtlayout)
    TextInputLayout anyhealtlayout;
    @InjectView(R.id.health)
    EditText health;
    @InjectView(R.id.healtlayout)
    TextInputLayout healtlayout;
    @InjectView(R.id.anydiet)
    EditText anydiet;
    @InjectView(R.id.anydietlayout)
    TextInputLayout anydietlayout;
    @InjectView(R.id.dietissue)
    EditText dietissue;
    @InjectView(R.id.dietlayout)
    TextInputLayout dietlayout;
    @InjectView(R.id.guardian)
    EditText guardian;
    @InjectView(R.id.guardianlayout)
    TextInputLayout guardianlayout;
    @InjectView(R.id.guardianphone)
    EditText guardianphone;
    @InjectView(R.id.guardianphonelayout)
    TextInputLayout guardianphonelayout;
    @InjectView(R.id.parentconsent)
    EditText parentconsent;
    @InjectView(R.id.parentconsentlayout)
    TextInputLayout parentconsentlayout;
    @InjectView(R.id.register)
    Button register;
    RegistrationPOJO registrationPOJO;



    public RegistrationFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        ButterKnife.inject(this, view);
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.dateofbirth, R.id.classification, R.id.gender, R.id.anyhealth, R.id.anydiet, R.id.parentconsent, R.id.register, R.id.churchtemple})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dateofbirth:
                doDatePicker();
                break;
            case R.id.classification:
                String[] classificationItems = {"Youth","Young Adult","Facilitator"};
                showDialog("Select Classification?",classificationItems,classification);
                break;
            case R.id.gender:
                String[] genderitems = {"Male","Female"};
                showDialog("Select Gender",genderitems,gender);
                break;
            case R.id.anyhealth:
                String[] anyhealthissue = {"Yes","No"};
                showDialog("Any Health Issue?",anyhealthissue,anyhealth);
                break;
            case R.id.anydiet:
                String[] anydietissue = {"Yes","No"};
                showDialog("Any Diet Issue?",anydietissue,anydiet);
                break;
            case R.id.parentconsent:
                String[] parentConsentItems = {"Yes","No"};
                showDialog("Has your parent or guardian consented?",parentConsentItems,parentconsent);
                break;
            case R.id.register:
                doRegistration();
                Log.i("register","register clicked");
                break;
            case R.id.churchtemple:
                String[] churchAttend = {"Yes","No"};
                showDialog("Do you Attend Church?",churchAttend,churchtemple);
                break;
        }
    }

    private void doRegistration() {

        // check for empty inputs
        if (empty(surname) || empty(othernames) || empty(dateofbirth) || empty(dateofbirth) || empty(classification) || empty(gender) || empty(phone) || empty(city) || empty(nationality)  || empty(anydiet)  || empty(guardian) || empty(guardianphone) || empty(parentconsent)) {

            Toast.makeText(getActivity(), "Fields Are Empty", Toast.LENGTH_SHORT).show();

        }
        else
            {

            final AlertDialog mydialog = myProgressBar();
                mydialog.show();
            //do registration here
            HashMap<String, String> fields = new HashMap<>();
            fields.put("surname", text(surname));
            fields.put("othernames", text(othernames));
            fields.put("dateofbirth", text(dateofbirth));
            fields.put("classification", text(classification));
            fields.put("gender", text(gender));
            fields.put("phone", text(phone));
            fields.put("city", text(city));
            fields.put("nationality", text(nationality));
            fields.put("churchtemple", text(churchtemple));
            fields.put("otherchurch", text(otherchurch));
            fields.put("anyhealth", text(anyhealth));
            fields.put("healthissue", text(health));
            fields.put("anydiet", text(anydiet));
            fields.put("dietissue", text(dietissue));
            fields.put("guardian", text(guardian));
            fields.put("guardianphone", text(guardianphone));
            fields.put("parentconsent", text(parentconsent));

            RetrofitInterface retrofitInterface = RetrofitService.getClient().create(RetrofitInterface.class);
            Call<RegistrationPOJO> call = retrofitInterface.getRegistrationResponse(fields);
            call.enqueue(new Callback<RegistrationPOJO>() {
                @Override
                public void onResponse(@NonNull Call<RegistrationPOJO> call, @NonNull Response<RegistrationPOJO> response) {
                    if (response.isSuccessful()) {
                        if(mydialog.isShowing())
                        {
                            mydialog.dismiss();
                        }


                        registrationPOJO = response.body();
                        assert registrationPOJO != null;
                       switch (registrationPOJO.getSuccessResponse())
                        {
                            case "0":
                                Toast.makeText(getActivity(), "Could Not Register.. Try Again", Toast.LENGTH_LONG).show();
                                break;
                            case "1":
                                Toast.makeText(getActivity(), "You Have successfully Registered..", Toast.LENGTH_LONG).show();
                                break;
                            case "2":
                                Toast.makeText(getActivity(), "You Have already Registered..", Toast.LENGTH_LONG).show();
                                break;
                        }


                    } else {
                        Toast.makeText(getActivity(), "There was an Error.. Try Again", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<RegistrationPOJO> call, @NonNull Throwable t) {
                    if(mydialog.isShowing())
                    {
                        mydialog.dismiss();
                    }

                    Log.i("Response", t.getMessage());
                    Toast.makeText(getActivity(), "Could Not Register... Check Internet", Toast.LENGTH_LONG).show();

                }
            });
        }
    }

    private boolean empty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }

    private String text(EditText editText) {
        return editText.getText().toString();
    }

    private void showDialog(String question, final String[] dialogitems, final EditText editText) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setTitle(question);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setSingleChoiceItems(dialogitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editText.setText(dialogitems[which]);
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

  private AlertDialog myProgressBar()
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder.setView(R.layout.progress_bar_layout);
        dialogBuilder.setCancelable(false);
        return dialogBuilder.create();

    }

    private void doDatePicker() {
       /* Calendar calendar = Calendar.getInstance(TimeZone.getDefault()); */
        int startyear = 1990;
        int startmonth = 1;
        int startday = 1;
        final String dobSeparate = "/";
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        String dobReturn = dayOfMonth + dobSeparate + (monthOfYear + 1) + dobSeparate + year;
                        dateofbirth.setText(dobReturn);

                    }
                }, startyear, startmonth, startday);

        datePickerDialog.show();

    }


}
