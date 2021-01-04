package com.sm.cn.dto;

public class SearchPageDTO {
    private int firstTypeId;
    private int secondTypeId;
    private String search;

    public int getFirstTypeId() {
        return firstTypeId;
    }

    public void setFirstTypeId(int firstTypeId) {
        this.firstTypeId = firstTypeId;
    }

    public int getSecondTypeId() {
        return secondTypeId;
    }

    public void setSecondTypeId(int secondTypeId) {
        this.secondTypeId = secondTypeId;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "SearchPageDTO{" +
                "firstTypeId=" + firstTypeId +
                ", secondTypeId=" + secondTypeId +
                ", search='" + search + '\'' +
                '}';
    }
}
