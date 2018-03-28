package com.zandooy.blog.service;

import com.zandooy.blog.dto.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> getList (int pageNum,int pageSize);

    Integer add (Blog blog);

    void delBlog (Integer code);
}
