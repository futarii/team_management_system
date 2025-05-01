package com.yanshedui.backendcommon.entity.vo;

import java.util.List;

public class PageVO<T> {

    private List<T> records;
    private Long currentPage;
    private Long pageSize;
    private Long total;

    public PageVO() {
    }

    public PageVO(List<T> records, Long currentPage, Long pageSize, Long total) {
        this.records = records;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "records=" + records +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                '}';
    }
}
