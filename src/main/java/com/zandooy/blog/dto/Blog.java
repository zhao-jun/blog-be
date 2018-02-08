package com.zandooy.blog.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Blog {
    private Integer id;

    @NotNull(message = "标题必传")
    private String title;

    private Integer type;

    @NotNull(message = "内容必传")
    private String content;

    private Date createTime;

    private Date updateTime;

    public Blog(Integer id, String title, Integer type, String content, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Blog() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
