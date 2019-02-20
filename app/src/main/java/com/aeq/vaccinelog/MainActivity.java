package com.aeq.vaccinelog;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.aeq.vaccinelog.database.DBOpenHelper;
import com.aeq.vaccinelog.database.DataSource;
import com.aeq.vaccinelog.model.DataItem;
import com.aeq.vaccinelog.model.PatientsProvider;

public class MainActivity extends AppCompatActivity  implements LoaderManager.LoaderCallbacks<Cursor> {

    private CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String userEmail = getIntent().getExtras().getString(LoginActivity.DATA_ITEM_KEY);
        DataSource dataSource = new DataSource(this);
        DataItem item = dataSource.getUser(userEmail);

        String[] from = {DBOpenHelper.PATIENT_FN,DBOpenHelper.PATIENT_LN};
//        String[] from = {item.getFirstName(),item.getLastName()};
        int[] to = {android.R.id.text1};

        cursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,null,from,to,0);
        ListView listView = findViewById(android.R.id.list);
        listView.setAdapter(cursorAdapter);

        getLoaderManager().initLoader(0, null, this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
