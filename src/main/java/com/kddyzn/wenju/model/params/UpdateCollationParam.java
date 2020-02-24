package com.kddyzn.wenju.model.params;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UpdateCollationParam {

    @NotNull(message = "收集id不能为空")
    private Integer id;

    private String name;

    private Long deadline;

    private String fileTemplate;
}
