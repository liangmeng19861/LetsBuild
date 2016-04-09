package com.letsbuild.dao.mapper.bo;

public class SysRole {
    private Long id;

    private String comment;

    private Byte[] name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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