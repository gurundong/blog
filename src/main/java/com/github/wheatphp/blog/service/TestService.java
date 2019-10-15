package com.github.wheatphp.blog.service;

import com.github.wheatphp.blog.bean.ResponseBean;
import com.github.wheatphp.blog.bean.TestBean;
import com.github.wheatphp.blog.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private final TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    public ResponseBean<List<TestBean>> test01(){
        List<TestBean> testData = testMapper.getTestData();
        ResponseBean<List<TestBean>> responseBean = new ResponseBean<>();
        responseBean.setCode("0");
        responseBean.setMessage("success");
        responseBean.setResult(testData);
        return responseBean;
    }
}
