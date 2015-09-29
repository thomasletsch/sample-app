package org.moserp.common.rest;

import org.moserp.common.ToolbarActivity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class PostCall extends RestCall<URI> {

    private String uri;
    private Object resource;

    public PostCall(ToolbarActivity activity, String uri, Object resource) {
        super(activity);
        this.uri = uri;
        this.resource = resource;
        this.context = activity;
    }

    public PostCall(ToolbarActivity activity, String uri, Object resource, LoaderCallback<URI> callback) {
        super(activity, callback);
        this.uri = uri;
        this.resource = resource;
        this.context = activity;
    }

    @Override
    protected URI executeRestCall() {
        RestTemplate restTemplate = new HalRestTemplate(backendPreferences.getUserName(), backendPreferences.getPassword());
        String completeUri = (uri.startsWith("http")) ? uri : backendPreferences.getBackendUrl() + uri;
        return restTemplate.postForLocation(completeUri, resource);
    }


}
