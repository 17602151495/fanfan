package com.wqf.imports.sys.dao;

import com.wqf.imports.common.base.BaseDao;
import com.wqf.imports.sys.entity.ImageEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 图片表
 *
 * @author py
 * @email sunlightcs@gmail.com
 * @date 2018-05-28 13:33:27
 */
@Mapper
public interface ImageDao extends BaseDao<ImageEntity> {
    void saveList(List<ImageEntity> list);

    void deleteByCode(Map<String, Object> params);

    void deleteByCodeBatch(List<Map<String,Object>> list);
}
