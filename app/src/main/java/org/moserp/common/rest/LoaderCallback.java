package org.moserp.common.rest;

public interface LoaderCallback<RESPONSE> {
    void onLoadFinished(RESPONSE data);
}
