package com.aeq.vaccinelog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LandingPage extends AppCompatActivity {

    public static final String PRACTITIONER_KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        ImageButton practitioner = findViewById(R.id.practitioner_image_button);
        ImageButton family = findViewById(R.id.family_image_button);

        final Intent intent = new Intent(this,LoginActivity.class);

        practitioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(PRACTITIONER_KEY,"practitioner");
                startActivity(intent);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(PRACTITIONER_KEY,"family");
                startActivity(intent);
            }
        });



    }
}
