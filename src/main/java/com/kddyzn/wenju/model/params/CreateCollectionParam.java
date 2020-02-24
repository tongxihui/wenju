package com.kddyzn.wenju.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateCollectionParam {

    private String name;

    @NotNull(message = "收集者id不能为空")
    private String collector;

    private Long deadline;

    @NotNull(message = "模板不能为空")
    private String fileTemplate;
}
