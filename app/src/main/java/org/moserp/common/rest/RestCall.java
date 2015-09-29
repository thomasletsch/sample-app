package org.moserp.common.rest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.moserp.common.ToolbarActivity;
import org.moserp.common.preferences.BackendPreferences;
import org.moserp.inventory.R;

public abstract class RestCall<RESPONSE> extends AsyncTask<Void, Void, RESPONSE> {
    protected BackendPreferences backendPreferences;
    protected Context context;
    protected LoaderCallback<RESPONSE> callback;
    protected ToolbarActivity activity;

    public RestCall(ToolbarActivity activity) {
        this.activity = activity;
        this.backendPreferences = activity.getBackendPreferences();
        this.context = activity.getApplicationContext();
        if (activity instanceof LoaderCallback) {
            this.callback = (LoaderCallback<RESPONSE>) activity;
        }
    }

    public RestCall(ToolbarActivity activity, LoaderCallback<RESPONSE> callback) {
        this.activity = activity;
        this.backendPreferences = activity.getBackendPreferences();
        this.context = activity.getApplicationContext();
        this.callback = callback;
        if(callback == null && (activity instanceof LoaderCallback)) {
            this.callback = (LoaderCallback<RESPONSE>) activity;
        }
    }

    protected RESPONSE doInBackground(Void... params) {
        try {
            return executeRestCall();
        } catch (Exception e) {
            handleError(e);
        }
        return null;
    }

    protected abstract RESPONSE executeRestCall();

    protected void handleError(Exception e) {
        Log.e("RestCall", e.getMessage(), e);
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, R.string.toast_backend_error, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onPostExecute(RESPONSE data) {
        if(data != null) {
            callback.onLoadFinished(data);
        }
    }

}
