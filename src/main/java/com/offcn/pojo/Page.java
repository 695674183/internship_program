package com.offcn.pojo;

import java.util.List;

/**
 * name:uedu-am
 * author: xiaoming
 **/
public class Page<T> {
    //当前页显示的多条数据
    private List<T>list;
    //页码
    private Integer pagenum;
    //每一页显示的条数
    private Integer pagesize;

    public Page() {
    }

    public Page(List<T> list, Integer pagenum, Integer pagesize) {
        this.list = list;
        this.pagenum = pagenum;
        this.pagesize = pagesize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
