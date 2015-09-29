package org.moserp.common.rest;

import org.moserp.common.ToolbarActivity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class GetCallWithListResponse<RESPONSE> extends RestCall<List<RESPONSE>> {

    private Class<? extends HateoasResources<RESPONSE>> resourceClass;
    private String relativePath;

    public GetCallWithListResponse(ToolbarActivity activity, Class<? extends HateoasResources<RESPONSE>> resourceClass, String relativePath) {
        super(activity, null);
        this.relativePath = relativePath;
        this.resourceClass = resourceClass;
    }

   public GetCallWithListResponse(ToolbarActivity activity, Class<? extends HateoasResources<RESPONSE>> resourceClass, String relativePath, LoaderCallback<List<RESPONSE>> callback) {
        super(activity, callback);
        this.relativePath = relativePath;
        this.resourceClass = resourceClass;
    }

    @Override
    protected List<RESPONSE> executeRestCall() {
        RestTemplate restTemplate = new HalRestTemplate(backendPreferences.getUserName(), backendPreferences.getPassword());
        String uri = (relativePath.startsWith("http")) ? relativePath : backendPreferences.getBackendUrl() + relativePath;
        HateoasResources<RESPONSE> resources = restTemplate.getForObject(uri, resourceClass);
        return resources.getList();
    }

}
