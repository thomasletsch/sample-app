package org.moserp.common.preferences;

import android.content.SharedPreferences;
import android.util.Log;

public class BackendPreferences {
    private static final String KEY_PREF_USER_NAME = "user_name";
    private static final String KEY_PREF_PASSWORD = "password";
    private static final String KEY_PREF_BACKEND_URL = "backend_url";

    private SharedPreferences sharedPreferences;

    public BackendPreferences() {
    }

    public void setSharedPreferences(SharedPreferences sharedPreferences) {
        Log.i("BackendPreferences", "Setting preferences: " + sharedPreferences);
        this.sharedPreferences = sharedPreferences;
    }

    public String getUserName() {
        if(sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(KEY_PREF_USER_NAME, null);
    }
    public String getPassword() {
        if(sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(KEY_PREF_PASSWORD, null);
    }
    public String getBackendUrl() {
        if(sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString(KEY_PREF_BACKEND_URL, null);
    }
}
