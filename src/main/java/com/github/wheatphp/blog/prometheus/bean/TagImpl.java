package com.github.wheatphp.blog.prometheus.bean;

import io.micrometer.core.instrument.Tag;

public class TagImpl implements Tag {
    private String key;
    private String value;
    public TagImpl(String key,String value){
        this.key = key;
        this.value = value;
    }


    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
