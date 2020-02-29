package com.kddyzn.wenju.controller;

import com.kddyzn.wenju.constant.AppConstant;
import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.model.HttpResult;
import com.kddyzn.wenju.model.params.CreateCommitParam;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(AppConstant.API_MAP + "/commit")
public class CommitController {

    @ApiOperation(value = "创建提交", notes = "根据上传者id、收集id创建提交")
    @ApiImplicitParam(required = true)
    @PostMapping("/create")
    public HttpResult createCommit(
            @RequestBody @Valid CreateCommitParam param) {
        return new HttpResult("创建成功");
    }
}
