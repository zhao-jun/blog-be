package com.zandooy.blog.controller;

import com.zandooy.blog.dto.Blog;
import com.zandooy.blog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("blog/list")
    public List<Blog> getBlogList() {
        return blogService.getBlogList(1, 1);
    }
}
