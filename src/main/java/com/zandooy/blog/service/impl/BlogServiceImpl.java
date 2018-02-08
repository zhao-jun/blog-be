package com.zandooy.blog.service.impl;

import com.zandooy.blog.dao.BlogMapper;
import com.zandooy.blog.dto.Blog;
import com.zandooy.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog>  getList (int pageNum,int pageSize) {
        return blogMapper.selectList();
    }

    @Override
    public Integer add (Blog blog) {
        return blogMapper.insertSelective(blog);
    }
}
