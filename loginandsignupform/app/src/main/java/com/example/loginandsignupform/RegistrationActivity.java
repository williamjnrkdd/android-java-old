import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegistrationActivity extends Activity implements OnItemSelectedListener {
    String selectedCountry;
    EditText firstName;
    EditText lastName;
    EditText contact;
    Button registerButton2;


    private String newFirstName;
    private String newLastName;
    private String newContact;
    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //spinner
        Spinner spinner = findViewById(R.id.country_code_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_codes_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        firstName = findViewById(R.id.first_name_edittext);
        lastName = findViewById(R.id.last_name_edittext);
        contact = findViewById(R.id.contact_edittext);

        

        registerButton2.setEnabled(false);
        registerButton2 = findViewById(R.id.register_button_2);
        registerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newFirstName = firstName.getText().toString();
                newLastName = lastName.getText().toString();
                newContact = contact.getText().toString();

                countryCodeConversion();
                phoneNumber = selectedCountry + newContact;


                Intent intent = new Intent(RegistrationActivity.this, RegistrationCodeVerificationActivity.class);
                intent.putExtra("PHONE_NUMBER", phoneNumber);
                startActivity(intent);

            }
        });


    }

    public void countryCodeConversion() {
        switch (selectedCountry) {
            case "Ghana(+233)":
                selectedCountry = "+233";
                break;
            case "Nigeria(+234)":
                selectedCountry = "+234";
                break;
        }
    }









    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        selectedCountry = parent.getItemAtPosition(position).toString();

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }



}