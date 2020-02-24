package com.kddyzn.wenju.service;

import com.kddyzn.wenju.common.enums.CollectionStatusEnum;
import com.kddyzn.wenju.dao.po.auto.CollectionP0;

import java.util.List;

public interface CollectionService {

    void addCollection(CollectionP0 collectionP0);

    void deleteCollection();

    void updateCollection();

    CollectionP0 getCollectionById(String id);

    List<CollectionP0> getCollectionByName(String name);

    List<CollectionP0> getCollectionByCollector(String userId);

    List<CollectionP0> getCollectionByStatus(CollectionStatusEnum status);
}
