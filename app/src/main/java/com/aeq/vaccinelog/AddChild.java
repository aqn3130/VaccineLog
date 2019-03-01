package com.aeq.vaccinelog;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListAdapter;

import com.aeq.vaccinelog.database.DataSource;
import com.aeq.vaccinelog.database.DataSourceChild;
import com.aeq.vaccinelog.model.DataItem;
import com.aeq.vaccinelog.model.DataItemChild;

import java.util.ArrayList;
import java.util.List;

public class AddChild extends AppCompatActivity {

    public static final String GUARDIAN_KEY = "guardianID";
    public static final String CHILD_NAME = "fName";
    private String userEmail = null;
    private DataItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getIntent().getExtras() != null)
        userEmail = getIntent().getExtras().getString(LoginActivity.DATA_ITEM_KEY);
        DataSource dataSource = new DataSource(this);

        item = dataSource.getUser(userEmail);

        final Intent intent = new Intent(this,ChildRegistration.class);
        intent.putExtra(GUARDIAN_KEY,item.getEmail());

        viewChildren(userEmail);

        FloatingActionButton fab = findViewById(R.id.add_child);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Register a child", Snackbar.LENGTH_LONG)
                        .setAction("START", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(intent);
                            }
                        }).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void viewChildren(String userEmail) {
        final DataSourceChild dataSourceChild = new DataSourceChild(this);
        DataItemChild child = dataSourceChild.getChild(userEmail);

        Log.d("AddChild", "email " + userEmail);

        List<DataItemChild> children = new ArrayList<>();
        children = dataSourceChild.getAllItems(userEmail);

        ViewGroup viewGroup = findViewById(R.id.tableView);

        Log.d("Add Child","No of Children " + children.size());

        final Intent intent = new Intent(this,ChildEdit.class);

        for (final DataItemChild child1 : children){
            Button button = new Button(this);
            String fullname = child1.getFirstName() + " " + child1.getLastName();
            button.setText(fullname);

            intent.putExtra(CHILD_NAME,child1.getFirstName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Edit Child", Snackbar.LENGTH_LONG)
                            .setAction("Edit", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
//                                    dataSourceChild.deleteItem(child1.getFirstName());
                                    startActivity(intent);

                                }
                            }).show();
                }
            });
            viewGroup.addView(button);
        }
    }
}
