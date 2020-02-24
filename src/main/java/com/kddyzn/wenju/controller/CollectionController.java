package com.kddyzn.wenju.controller;

import com.kddyzn.wenju.model.HttpResult;
import com.kddyzn.wenju.service.CollectionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Resource
    CollectionService collectionService;

    @ApiOperation(value = "创建收集")
    @PostMapping("/create")
    public HttpResult createCollection() {
        return new HttpResult("创建成功");
    }

    @ApiOperation(value = "删除收集")
    @ApiImplicitParam(name = "收集id", required = true, dataType = "String")
    @DeleteMapping("/{id}")
    public HttpResult deleteCollection(@PathVariable String id) {
        return new HttpResult("删除成功");
    }

    @ApiOperation(value = "查询收集")
    @ApiImplicitParam(name = "收集id", required = false, dataType = "String")
    @GetMapping("/{id}")
    public HttpResult getCollection(@PathVariable String id) {
        return new HttpResult("");
    }
}
