package org.moserp.common.cache;

import org.moserp.common.rest.HateoasLinkContainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheContainer {

    private static final Map<Class<? extends HateoasLinkContainer>, ResourceCache<? extends HateoasLinkContainer>> caches = new HashMap<>();

    public static <RESOURCE extends HateoasLinkContainer> void cache(Class<RESOURCE> resourceClass, List<RESOURCE> resources) {
        caches.put(resourceClass, new ResourceCache<RESOURCE>(resources));
    }

    @SuppressWarnings("unchecked")
    public static <RESOURCE extends HateoasLinkContainer> ResourceCache<RESOURCE> get(Class<RESOURCE> resourceClass) {
        return (ResourceCache<RESOURCE>) caches.get(resourceClass);
    }
}
