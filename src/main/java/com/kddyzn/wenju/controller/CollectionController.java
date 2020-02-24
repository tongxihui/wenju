package com.kddyzn.wenju.controller;

import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.model.HttpResult;
import com.kddyzn.wenju.model.params.CreateCollectionParam;
import com.kddyzn.wenju.model.params.UpdateCollationParam;
import com.kddyzn.wenju.service.CollectionService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Resource
    CollectionService collectionService;

    @ApiOperation(value = "创建收集")
    @PostMapping("/create")
    public HttpResult createCollection(
            @RequestBody @Valid CreateCollectionParam param) {
        if (param.getDeadline() != null) {
            if (System.currentTimeMillis() - param.getDeadline() <= 60 * 60) {
                //deadline不能比现在时间早1小时以内
                return null;
            }
        }
        collectionService.addCollection(param);
        return new HttpResult("创建成功");
    }

    @ApiOperation(value = "删除收集")
    @ApiImplicitParam(name = "收集id", required = true, dataType = "Integer")
    @DeleteMapping("/{id}")
    public HttpResult deleteCollection(@PathVariable Integer id) {
        CollectionP0 collectionP0 = collectionService.getCollectionById(id);
        return new HttpResult("删除成功");
    }

    @ApiOperation(value = "查询收集")
    @ApiImplicitParam(name = "收集id", required = false, dataType = "Integer")
    @GetMapping("/{id}")
    public HttpResult getCollection(@PathVariable Integer id) {
        CollectionP0 collectionP0 = collectionService.getCollectionById(id);
        return new HttpResult(collectionP0);
    }

    @ApiOperation(value = "更新收集")
    @ApiImplicitParam(required = true)
    public HttpResult updateCollection(
            @RequestBody @Valid UpdateCollationParam param) {
        collectionService.updateCollection(param);
        return new HttpResult("更新成功");
    }
}
