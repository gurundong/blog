package com.github.wheatphp.blog.prometheus.bean;

import java.util.HashMap;
import java.util.Map;

public class DimensionMap {
    public static Map<String,String> setDimensions(String resourceId,String resourceName,
                                                   String account,String region,String service){
        Map<String,String> map = new HashMap<>();
        map.put("account",account);
        map.put("resource_id",resourceId);
        map.put("resource_name",resourceName);
        map.put("region",region);
        map.put("service",service);
        return map;
    }
}
