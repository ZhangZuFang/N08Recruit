package main.java.dto;

public class RequestData {

    private int page; // 当前页码

    private int rows; // 页面可显示行数

    private String sidx; // 用于排序的列名

    private String sord; // 排序的方式desc/asc

    private boolean search; // 是否是搜索请求

    private String nd; // 已经发送的请求的次数

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    public String getNd() {
        return nd;
    }

    public void setNd(String nd) {
        this.nd = nd;
    }
    
}
