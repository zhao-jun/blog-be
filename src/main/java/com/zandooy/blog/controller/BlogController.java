package com.zandooy.blog.controller;

import com.zandooy.blog.dto.Blog;
import com.zandooy.blog.service.impl.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;

    @GetMapping("blog/list")
    public List<Blog> getBlogList() {
        return blogService.getList(1, 1);
    }

    @PostMapping("blog")
    public void addBlog (@Valid Blog blog, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new ValidationException(result.getFieldError().getDefaultMessage());
        }
        blogService.add(blog);
    }

    @GetMapping("blog")
    public void getBlog (@Valid Blog blog, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new ValidationException(result.getFieldError().getDefaultMessage());
        }
        blogService.add(blog);
    }
}
