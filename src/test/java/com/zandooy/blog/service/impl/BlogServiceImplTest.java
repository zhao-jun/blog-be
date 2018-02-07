package com.zandooy.blog.service.impl;

import com.zandooy.blog.dao.BlogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceImplTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    public void getBlogList() throws Exception {
        System.out.println(blogMapper.selectList());
    }
}