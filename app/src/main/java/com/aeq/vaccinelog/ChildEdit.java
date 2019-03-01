package com.aeq.vaccinelog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.aeq.vaccinelog.database.DataSourceChild;
import com.aeq.vaccinelog.model.DataItemChild;

public class ChildEdit extends AppCompatActivity {

    private static final String GUARDIAN_KEY = "KEY";
    private Intent intent = null;

    private DataItemChild dataItemChild;

    private DataItemChild child;

    private DataSourceChild dataSourceChild;

    private EditText child_edit_fName;
    private EditText child_edit_lName;
    private EditText child_edit_dob;
    private EditText child_edit_fatherName;
    private EditText child_edit_motherName;

    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_edit);

        String fName = getIntent().getExtras().getString(AddChild.CHILD_NAME);


        dataSourceChild = new DataSourceChild(this);

        child = dataSourceChild.getChildByFirstName(fName);


        child_edit_fName = findViewById(R.id.edit_child_fName);
        child_edit_fName.setText(child.getFirstName());

        child_edit_lName = findViewById(R.id.edit_child_lName);
        child_edit_lName.setText(child.getLastName());

        child_edit_dob = findViewById(R.id.edit_child_dob);
        child_edit_dob.setText(child.getDateOfBirth());

        child_edit_fatherName = findViewById(R.id.edit_child_fatherName);
        child_edit_fatherName.setText(child.getFatherName());

        child_edit_motherName = findViewById(R.id.edit_child_motherName);
        child_edit_motherName.setText(child.getMotherName());

        intent = new Intent(this, AddChild.class);

        stringBuilder = new StringBuilder();

        final ToggleButton bcg = findViewById(R.id.toggleButton);

        if(child.getVaccines() != null){
            if(child.getVaccines().contains("bcg")){
                bcg.setChecked(true);
                stringBuilder.append("bcg");
            }else {
                bcg.setChecked(false);
            }
        }

        bcg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bcg.isChecked()){
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);

                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("bcg"))
                            stringBuilder.append("bcg");
                    }
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("bcg")){
                            int start = child.getVaccines().indexOf("bcg");
                            int end = start + 3;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        final ToggleButton opv_0 = findViewById(R.id.toggleButton2);
        if(child.getVaccines() != null){
            if(child.getVaccines().contains("opv0")){
                opv_0.setChecked(true);
                stringBuilder.append("opv0");
            }else {
                opv_0.setChecked(false);
            }
        }

        opv_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opv_0.isChecked()){

                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("opv0"))
                            stringBuilder.append("opv0");
                    }
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("opv0")){
                            int start = child.getVaccines().indexOf("opv0");
                            int end = start + 4;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        final ToggleButton opv_1 = findViewById(R.id.toggleButton3);
        if(child.getVaccines() != null){
            if(child.getVaccines().contains("opv1")){
                opv_1.setChecked(true);
                stringBuilder.append("opv1");
            }else {
                opv_1.setChecked(false);
            }
        }

        opv_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opv_1.isChecked()){
                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("opv1"))
                            stringBuilder.append("opv1");
                    }
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("opv1")){
                            int start = child.getVaccines().indexOf("opv1");
                            int end = start + 4;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        final ToggleButton opv_2 = findViewById(R.id.toggleButton4);
        if(child.getVaccines() != null){
            if(child.getVaccines().contains("opv2")){
                opv_2.setChecked(true);
                stringBuilder.append("opv2");
            }else {
                opv_2.setChecked(false);
            }
        }

        opv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opv_2.isChecked()){
                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("opv2"))
                            stringBuilder.append("opv2");
                    }
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("opv2")){
                            int start = child.getVaccines().indexOf("opv2");
                            int end = start + 4;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        final ToggleButton opv_3 = findViewById(R.id.toggleButton5);
        if(child.getVaccines() != null){
            if(child.getVaccines().contains("opv3")){
                opv_3.setChecked(true);
                stringBuilder.append("opv3");
            }else {
                opv_3.setChecked(false);
            }
        }

        opv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opv_3.isChecked()){
                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("opv3"))
                            stringBuilder.append("opv3");
                    }
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("opv3")){
                            int start = child.getVaccines().indexOf("opv3");
                            int end = start + 4;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        final ToggleButton opv_4 = findViewById(R.id.toggleButton6);
        if(child.getVaccines() != null){
            if(child.getVaccines().contains("opv4")){
                opv_4.setChecked(true);
                stringBuilder.append("opv4");
            }else {
                opv_4.setChecked(false);
            }
        }

        opv_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(opv_4.isChecked()){
                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("opv4"))
                            stringBuilder.append("opv4");
                    }
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("opv4")){
                            int start = child.getVaccines().indexOf("opv4");
                            int end = start + 4;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        final ToggleButton measles = findViewById(R.id.toggleButton7);
        if(child.getVaccines() != null){
            if(child.getVaccines().contains("measles")){
                measles.setChecked(true);
                stringBuilder.append("measles");
            }else {
                measles.setChecked(false);
            }
        }

        measles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(measles.isChecked()){
                    if(child.getVaccines() != null){
                        if(!child.getVaccines().contains("measles"))
                            stringBuilder.append("measles");
                    }
                    DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                    dataSourceChild.updateItem(dataItemChild);
                }else {
                    if(child.getVaccines() != null){
                        if(child.getVaccines().contains("measles")){
                            int start = child.getVaccines().indexOf("measles");
                            int end = start + 7;
                            stringBuilder.replace(start,end,"");
                        }
                        DataItemChild dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
                        dataSourceChild.updateItem(dataItemChild);
                    }
                }
            }
        });

        Button save_child_detail = findViewById(R.id.button_edit_child);
        save_child_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save() {
        dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
        dataSourceChild.updateItem(dataItemChild);
        intent.putExtra(LoginActivity.DATA_ITEM_KEY,dataItemChild.getGuardian_id());
        startActivity(intent);
    }

//    @Override
//    public void onBackPressed() {
//
//        dataItemChild = new DataItemChild(child.getGuardian_id(),child_edit_fName.getText().toString(),child_edit_lName.getText().toString(),child_edit_dob.getText().toString(),child_edit_fatherName.getText().toString(),child_edit_motherName.getText().toString(),stringBuilder.toString());
//        dataSourceChild.updateItem(dataItemChild);
//        intent.putExtra(GUARDIAN_KEY,dataItemChild.getGuardian_id());
//        startActivity(intent);
//    }


    @Override
    public void onBackPressed() {
        save();
    }

}
