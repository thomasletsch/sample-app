package org.moserp.common;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.moserp.common.preferences.BackendPreferences;
import org.moserp.inventory.R;

public class ToolbarActivity extends AppCompatActivity {
    protected BackendPreferences backendPreferences = new BackendPreferences();

    public ToolbarActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PreferenceManager.setDefaultValues(this, R.xml.pref_general, false);
        backendPreferences.setSharedPreferences(PreferenceManager.getDefaultSharedPreferences(this));
    }

    protected void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.inflateMenu(R.menu.main_action_bar);
        }
    }

    protected void initRecyclerView(RecyclerView view) {
        view.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        view.setLayoutManager(mLayoutManager);
    }

    public BackendPreferences getBackendPreferences() {
        return backendPreferences;
    }
}
