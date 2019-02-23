package main.java.dto;

import java.util.List;

public class JqGridData {
    // 和JqGrid组件相关的参数属性
    /**
     * 查询返回的数组
     */
    private List  gridModel ; // 得到实际数据的数组

    private Integer rows ; // 每页中的记录行数

    private Integer record ; // 总记录数

    private Integer page ; // 当前页码数

    private Integer total ; // 总页数

    private String sord; // 排序的方式

    private String sidx; // 用于排序的列名

    private String search; // 是否用于查询的请求

    public List getGridModel() {
        return gridModel;
    }

    public void setGridModel(List  gridModel) {
        this.gridModel = gridModel;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRecord() {
        return record;
    }

    public void setRecord(Integer record) {
        this.record = record;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

}
