package com.wqf.imports.hotel.dao;

import com.wqf.imports.hotel.entity.HManagementTypeEntity;
import com.wqf.imports.common.base.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-17 00:33:22
 */
@Mapper
public interface HManagementTypeDao extends BaseDao<HManagementTypeEntity> {

    List<Map> initlist(@Param("pid") Long pid);
}
