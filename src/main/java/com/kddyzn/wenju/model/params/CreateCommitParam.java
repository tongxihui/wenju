package com.kddyzn.wenju.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateCommitParam {

    @NotNull(message = "收集id不能为空")
    private Integer collectionId;

    @NotNull(message = "上传者id不能为空")
    private String updaterId;
}
