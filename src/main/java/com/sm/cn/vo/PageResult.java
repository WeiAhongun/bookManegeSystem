package com.sm.cn.vo;

import java.util.List;

public class PageResult {
    private List list;
    private int total;

    public PageResult() {
    }

    public PageResult(List list, int total) {
        this.list = list;
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "list=" + list +
                ", total=" + total +
                '}';
    }
}
