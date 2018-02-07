package com.zandooy.blog.service;

import com.zandooy.blog.dto.Blog;

import java.util.List;

public interface IBlogService {

    List<Blog> getBlogList (int pageNum,int pageSize);
}
