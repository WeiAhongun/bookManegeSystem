package com.sm.cn.entity;

public class Book {
    private Integer bookId;

    private String bookName;

    private String authorName;

    private Integer firstTypeId;

    private String firstTypeName;

    private Integer secondTypeId;

    private String secondTypeName;

    private String description;

    private String imgUrl;

    public String getFirstTypeName() {
        return firstTypeName;
    }

    public void setFirstTypeName(String firstTypeName) {
        this.firstTypeName = firstTypeName;
    }

    public String getSecondTypeName() {
        return secondTypeName;
    }

    public void setSecondTypeName(String secondTypeName) {
        this.secondTypeName = secondTypeName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public Integer getFirstTypeId() {
        return firstTypeId;
    }

    public void setFirstTypeId(Integer firstTypeId) {
        this.firstTypeId = firstTypeId;
    }

    public Integer getSecondTypeId() {
        return secondTypeId;
    }

    public void setSecondTypeId(Integer secondTypeId) {
        this.secondTypeId = secondTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}
