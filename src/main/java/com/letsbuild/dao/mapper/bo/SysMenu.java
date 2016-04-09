package com.letsbuild.dao.mapper.bo;

public class SysMenu {
    private Long id;

    private String url;

    private Long pmenu;

    private String comment;

    private Byte[] name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getPmenu() {
        return pmenu;
    }

    public void setPmenu(Long pmenu) {
        this.pmenu = pmenu;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Byte[] getName() {
        return name;
    }

    public void setName(Byte[] name) {
        this.name = name;
    }
}