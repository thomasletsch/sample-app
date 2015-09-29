package org.moserp.common.preferences;


import android.os.Bundle;
import android.preference.PreferenceFragment;

import org.moserp.inventory.R;

public class BackendPreferencesFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }
}
