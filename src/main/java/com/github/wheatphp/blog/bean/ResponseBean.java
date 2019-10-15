package com.github.wheatphp.blog.bean;

import lombok.Data;

@Data
public class ResponseBean<T> {
    private String code;

    private String message;

    private T result;
}
