package com.aeq.vaccinelog;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.SimpleCursorAdapter;

import com.aeq.vaccinelog.database.DBOpenHelper;
import com.aeq.vaccinelog.database.DataSource;
import com.aeq.vaccinelog.model.DataItem;
import com.aeq.vaccinelog.model.PatientsProvider;

import java.util.UUID;

public class Registration extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{

    private CursorAdapter cursorAdapter;
    private DataSource datasource = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        String[] from = {DBOpenHelper.PATIENT_FN,DBOpenHelper.PATIENT_LN};
        int[] to = {android.R.id.text1};
        cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,null,from,to,0);
//        ListView listView = (ListView) findViewById(android.R.id.list);
//        listView.setAdapter(cursorAdapter);

        datasource = new DataSource(this);

        getLoaderManager().initLoader(0, null, this);

        final TextInputLayout fn = findViewById(R.id.first_name);
        final TextInputLayout ln = findViewById(R.id.last_name);
        final TextInputLayout email = findViewById(R.id.email_input);
        final TextInputLayout password = findViewById(R.id.password_input);

        Button registration = findViewById(R.id.submit);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createItem(fn, ln, email, password);

                fn.getEditText().setText(null);
                ln.getEditText().setText(null);
                email.getEditText().setText(null);
                password.getEditText().setText(null);

            }
        });
    }

    private void createItem(TextInputLayout fn, TextInputLayout ln, TextInputLayout email, TextInputLayout password) {
        DataItem dataItem = new DataItem(fn.getEditText().getText().toString(),ln.getEditText().getText().toString(),email.getEditText().toString(),password.getEditText().toString());
        DataItem item = datasource.createItem(dataItem);

        Log.d("MainActivity", "Inserted patient " + item.getFirstName());

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, PatientsProvider.CONTENT_URI, null, null, null,null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {

        cursorAdapter.swapCursor(cursor);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

        cursorAdapter.swapCursor(null);
    }
}
