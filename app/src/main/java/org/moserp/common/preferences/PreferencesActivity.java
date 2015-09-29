package org.moserp.common.preferences;

import android.app.Activity;
import android.os.Bundle;

import org.moserp.inventory.R;


public class PreferencesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new BackendPreferencesFragment())
                .commit();
    }


}
