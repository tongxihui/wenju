package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.dao.mapper.auto.CollectionMapper;
import com.kddyzn.wenju.dao.mapper.auto.CommitMapper;
import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.dao.po.auto.CommitP0;
import com.kddyzn.wenju.model.params.CreateCommitParam;
import com.kddyzn.wenju.service.CollectionService;
import com.kddyzn.wenju.service.CommitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommitServiceImpl implements CommitService {

    @Resource
    private CommitMapper commitMapper;

    @Resource
    private CollectionMapper collectionMapper;

    @Resource
    private CollectionService collectionService;

    @Override
    public void createCommit(CreateCommitParam param) {
        CommitP0 commitP0 = new CommitP0();
        CollectionP0 collectionP0 = collectionMapper.selectByPrimaryKey(param.getCollectionId());
        commitP0.setCollectionId(param.getCollectionId());
        commitP0.setUpdaterId(param.getUpdaterId());
        commitP0.setUpdateTime(System.currentTimeMillis());
        commitP0.setData(collectionService.getFileTemplateById(param.getCollectionId()));
        commitMapper.insert(commitP0);
    }
}
