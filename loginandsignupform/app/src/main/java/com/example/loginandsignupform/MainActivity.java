package com.example.loginandsignupform;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;




public class MainActivity extends Activity  implements AdapterView.OnItemSelectedListener {

    String selectedCountry, phoneNumber;
    Button loginButton;
    EditText phoneNumberEditext;
    Context context;
    String title, message, storedContact;
    Boolean status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_customer_login);
        Log.d("Tag", "onCreate()");



        //spinner
        Spinner spinner =  findViewById(R.id.country_code_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_codes_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        phoneNumberEditext = findViewById(R.id.enterYourNumber);
        loginButton = findViewById(R.id.login_button);


    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag", "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag", "onDestroy");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int position, long id) {
        // An item was selected. You can retrieve the selected item using
        selectedCountry = parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void countryCodeConversion(){
        switch (selectedCountry) {
            case "Ghana(+233)":
                selectedCountry = "+233";
                break;
            case  "Nigeria(+234)":
                selectedCountry = "+234";
                break;
        }
    }




    public void onClickLogin(View view ){
        String contact = phoneNumberEditext.getText().toString();

        countryCodeConversion();
        phoneNumber= selectedCountry + contact;



    }


    public void onClickRegister(View view){

        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);


    }
    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        title = "Login Error";
        message = "This Contact is not associated with any account. Please register";


        final AlertDialog alertDialog = new AlertDialog.Builder(CustomerLoginActivity.this).create();

        // Setting Dialog Title
        alertDialog.setTitle(title);

        // Setting Dialog Message
        alertDialog.setMessage(message);

        if (status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.ic_launcher_background : R.drawable.ic_launcher_background);

        // Setting OK Button
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }




}

