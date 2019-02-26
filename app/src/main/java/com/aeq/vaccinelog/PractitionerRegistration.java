package com.aeq.vaccinelog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.aeq.vaccinelog.database.DataSourcePractitioner;
import com.aeq.vaccinelog.model.DataItemPractitioner;

public class PractitionerRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practitioner_registration);

        final EditText fname = findViewById(R.id.practitionerFirstName);
        final EditText lname = findViewById(R.id.practitionerLastname);
        final EditText email = findViewById(R.id.practitionerEmail);
        final EditText password = findViewById(R.id.practitionerPassword);
        final EditText dob = findViewById(R.id.practitionerDOB);
        final EditText address = findViewById(R.id.practiceAddress);
        final EditText registration = findViewById(R.id.practitionerRegistration);

        Button registerPractitioner = findViewById(R.id.registerPractitioner_button);
        registerPractitioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPractitioner(fname, lname, email, password, dob, address, registration);
            }
        });
    }

    private void createPractitioner(EditText fname, EditText lname, EditText email, EditText password, EditText dob, EditText address, EditText registration) {
        DataItemPractitioner dataItemPractitioner = new DataItemPractitioner(null,fname.getText().toString(),lname.getText().toString(),
                email.getText().toString(),password.getText().toString(),dob.getText().toString(),address.getText().toString(),registration.getText().toString());
        DataSourcePractitioner dataSourcePractitioner = new DataSourcePractitioner(this);
        DataItemPractitioner itemPractitioner = dataSourcePractitioner.createItem(dataItemPractitioner);

        if(itemPractitioner != null){
            fname.setText(null);
            lname.setText(null);
            email.setText(null);
            password.setText(null);
            dob.setText(null);
            address.setText(null);
            registration.setText(null);

            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }

    }
}
