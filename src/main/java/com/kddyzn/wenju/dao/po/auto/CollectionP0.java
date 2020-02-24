package com.kddyzn.wenju.dao.po.auto;

import com.kddyzn.wenju.common.enums.CollectionStatusEnum;

public class CollectionP0 {
    private Integer id;

    private String name;

    private String collector;

    private Long createTime;

    private Long deadline;

    private CollectionStatusEnum status;

    private String fileTemplate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public CollectionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(CollectionStatusEnum status) {
        this.status = status;
    }

    public String getFileTemplate() {
        return fileTemplate;
    }

    public void setFileTemplate(String fileTemplate) {
        this.fileTemplate = fileTemplate;
    }
}