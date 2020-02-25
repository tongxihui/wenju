package com.kddyzn.wenju.service;

import com.kddyzn.wenju.common.enums.CollectionStatusEnum;
import com.kddyzn.wenju.dao.po.auto.CollectionP0;
import com.kddyzn.wenju.model.params.CreateCollectionParam;
import com.kddyzn.wenju.model.params.UpdateCollationParam;

import java.util.List;

public interface CollectionService {

    /**
     * 增加收集
     * @param param
     * @return
     */
    Integer addCollection(CreateCollectionParam param);

    /**
     * 删除收集
     * @param collectionId
     */
    void deleteCollection(Integer collectionId);

    /**
     * 更新收集
     * @param param
     */
    void updateCollection(UpdateCollationParam param);

    /**
     * 根据id获取文件模板
     * @param id
     * @return
     */
    String getFileTemplateById(Integer id);

    /**
     * 根据id获取收集
     * @param id
     * @return
     */
    CollectionP0 getCollectionById(Integer id);

    /**
     * 获取所有收集
     * @return
     */
    List<CollectionP0> getAll();

    /**
     * 根据名称获取收集
     * @param name
     * @return
     */
    List<CollectionP0> getCollectionByName(String name);

    /**
     * 根据收集者id获取收集
     * @param userId
     * @return
     */
    List<CollectionP0> getCollectionByCollector(String userId);

    /**
     * 根据状态获取收集
     * @param status
     * @return
     */
    List<CollectionP0> getCollectionByStatus(CollectionStatusEnum status);
}
