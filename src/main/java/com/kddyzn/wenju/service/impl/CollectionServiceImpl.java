package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.common.enums.CollectionStatusEnum;
import com.kddyzn.wenju.dao.mapper.auto.CollectionMapper;
import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.dao.po.auto.CollectionP0Example;
import com.kddyzn.wenju.model.params.CreateCollectionParam;
import com.kddyzn.wenju.model.params.UpdateCollationParam;
import com.kddyzn.wenju.service.CollectionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {

    @Resource
    private CollectionMapper collectionMapper;

    @Override
    public Integer addCollection(CreateCollectionParam param) {
        CollectionP0 collectionP0 = new CollectionP0();
        if (StringUtils.isEmpty(param.getName())) {
            collectionP0.setName("未命名");
        } else {
            collectionP0.setName(param.getName());
        }
        collectionP0.setCollector(param.getCollector());
        collectionP0.setCreateTime(System.currentTimeMillis());
        collectionP0.setDeadline(param.getDeadline());
        collectionP0.setFileTemplate(param.getFileTemplate());
        return collectionMapper.insert(collectionP0);
    }

    @Override
    public void deleteCollection(Integer collectionId) {
        CollectionP0 collectionP0 = new CollectionP0();
        collectionP0.setId(collectionId);
        collectionP0.setStatus(CollectionStatusEnum.DELETED);
        collectionMapper.updateByPrimaryKeySelective(collectionP0);
    }

    @Override
    public void updateCollection(UpdateCollationParam param) {
        CollectionP0 collectionP0 = new CollectionP0();
        collectionP0.setId(param.getId());
        if (StringUtils.isEmpty(param.getName())){
            collectionP0.setName("未命名");
        }else {
            collectionP0.setName(param.getName());
        }
        collectionP0.setDeadline(param.getDeadline());
        collectionP0.setFileTemplate(param.getFileTemplate());
        collectionMapper.updateByPrimaryKeySelective(collectionP0);
    }

    @Override
    public CollectionP0 getCollectionById(Integer id) {
        CollectionP0 collectionP0 = collectionMapper.selectByPrimaryKey(id);
        if (collectionP0.getStatus() == CollectionStatusEnum.DELETED) {
            return null;
        }
        return collectionP0;
    }

    @Override
    public List<CollectionP0> getCollectionByName(String name) {
        CollectionP0Example example = new CollectionP0Example();
        example.createCriteria().andNameEqualTo(name);
        List<CollectionP0> list = collectionMapper.selectByExample(example);
        list.removeIf(collectionP0 -> collectionP0.getStatus() == CollectionStatusEnum.DELETED);
        return list;
    }

    @Override
    public List<CollectionP0> getCollectionByCollector(String userId) {
        CollectionP0Example example = new CollectionP0Example();
        example.createCriteria().andCollectorEqualTo(userId);
        List<CollectionP0> list = collectionMapper.selectByExample(example);
        list.removeIf(collectionP0 -> collectionP0.getStatus() == CollectionStatusEnum.DELETED);
        return list;
    }

    @Override
    public List<CollectionP0> getCollectionByStatus(CollectionStatusEnum status) {
        CollectionP0Example example = new CollectionP0Example();
        example.createCriteria().andStatusEqualTo(status);
        List<CollectionP0> list = collectionMapper.selectByExample(example);
        list.removeIf(collectionP0 -> collectionP0.getStatus() == CollectionStatusEnum.DELETED);
        return list;
    }
}
