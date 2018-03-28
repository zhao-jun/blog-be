package com.zandooy.blog.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Blog {
    private Integer id;

    private String code;

    @NotNull(message = "标题必传")
    private String title;

    private Integer type;

    @NotNull(message = "内容必传")
    private String content;

    private Date createTime;

    private Date updateTime;

    public Blog(Integer id, String code, String title, Integer type, Date createTime, Date updateTime) {
        this.id = id;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setContent(String content) {
      this.content = content == null ? null : content.trim();
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

    public String getContent() {
        return content;
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
