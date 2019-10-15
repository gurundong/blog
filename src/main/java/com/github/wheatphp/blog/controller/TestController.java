package com.github.wheatphp.blog.controller;

import com.github.wheatphp.blog.bean.ResponseBean;
import com.github.wheatphp.blog.bean.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.wheatphp.blog.service.TestService;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/test01")
    public ResponseBean<List<TestBean>> test01(){
        return this.testService.test01();
    }
}
