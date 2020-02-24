package com.kddyzn.wenju.service.impl;

import com.kddyzn.wenju.common.enums.CollectionStatusEnum;
import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.service.CollectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Override
    public void addCollection(CollectionP0 collectionP0) {

    }

    @Override
    public void deleteCollection() {

    }

    @Override
    public void updateCollection() {

    }

    @Override
    public CollectionP0 getCollectionById(String id) {
        return null;
    }

    @Override
    public List<CollectionP0> getCollectionByName(String name) {
        return null;
    }

    @Override
    public List<CollectionP0> getCollectionByCollector(String userId) {
        return null;
    }

    @Override
    public List<CollectionP0> getCollectionByStatus(CollectionStatusEnum status) {
        return null;
    }
}
