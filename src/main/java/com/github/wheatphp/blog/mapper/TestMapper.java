package com.github.wheatphp.blog.mapper;

import com.github.wheatphp.blog.bean.TestBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    public List<TestBean> getTestData();
}
