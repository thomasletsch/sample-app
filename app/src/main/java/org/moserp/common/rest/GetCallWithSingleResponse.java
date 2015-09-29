package org.moserp.common.rest;

import org.moserp.common.ToolbarActivity;
import org.springframework.web.client.RestTemplate;

public class GetCallWithSingleResponse<RESPONSE> extends RestCall<RESPONSE> {

    private String uri;
    private Class<RESPONSE> resourceClass;

    public GetCallWithSingleResponse(ToolbarActivity activity, String uri, Class<RESPONSE> resourceClass) {
        super(activity);
        this.uri = uri;
        this.resourceClass = resourceClass;
        this.context = activity;
    }

    public GetCallWithSingleResponse(ToolbarActivity activity, String uri, Class<RESPONSE> resourceClass, LoaderCallback<RESPONSE> callback) {
        super(activity, callback);
        this.uri = uri;
        this.resourceClass = resourceClass;
        this.context = activity;
    }

    @Override
    protected RESPONSE executeRestCall() {
        RestTemplate restTemplate = new HalRestTemplate(backendPreferences.getUserName(), backendPreferences.getPassword());
        return restTemplate.getForEntity(uri, resourceClass).getBody();
    }


}
