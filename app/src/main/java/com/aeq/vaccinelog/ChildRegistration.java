package com.aeq.vaccinelog;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.aeq.vaccinelog.database.DataSourceChild;
import com.aeq.vaccinelog.model.DataItem;
import com.aeq.vaccinelog.model.DataItemChild;

import java.util.ArrayList;
import java.util.List;

public class ChildRegistration extends AppCompatActivity {

    DataSourceChild dataSourceChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_registration);

        dataSourceChild = new DataSourceChild(this);

        final EditText childFirstName = findViewById(R.id.childFirstName);
        final EditText childLastName = findViewById(R.id.childLastName);
        final EditText childDOB= findViewById(R.id.childDOB);
        final EditText childFatherName = findViewById(R.id.fatherName);
        final EditText childMotherName = findViewById(R.id.motherName);

        final String guardianId = getIntent().getExtras().getString(AddChild.GUARDIAN_KEY);

        Button registerChild = findViewById(R.id.registerChild);
        registerChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createItem(guardianId,childFirstName,childLastName,childDOB,childFatherName,childMotherName);
            }
        });


    }

    private void createItem(String guardianId,EditText fn, EditText ln, EditText dob, EditText fatherName, EditText motherName) {
        DataItemChild dataItemChild = new DataItemChild(guardianId,fn.getText().toString(),ln.getText().toString(),dob.getText().toString(),fatherName.getText().toString(),motherName.getText().toString(),null);
        DataItemChild item = dataSourceChild.createItem(dataItemChild);

        Log.d("Child Registration", "Child added " + item.getFirstName());

        Intent intent = new Intent(this, AddChild.class);
        intent.putExtra(LoginActivity.DATA_ITEM_KEY,guardianId);
        startActivity(intent);
    }
}
