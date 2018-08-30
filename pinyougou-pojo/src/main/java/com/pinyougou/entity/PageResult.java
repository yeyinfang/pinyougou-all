package com.pinyougou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @program: pinyougou-all
 * @description: 分页的数据
 * @author: YF
 * @create: 2018-08-29 16:47
 **/
public class PageResult implements Serializable {
    private long total;//总记录数
    private List rows;//当前页结果
    public PageResult(long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
