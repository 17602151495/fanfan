package com.wqf.imports.hotel.service;

import com.wqf.imports.hotel.entity.HManagementTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-17 00:33:22
 */
public interface HManagementTypeService {
	
	HManagementTypeEntity queryObject(Integer id);

	List<Map> initlist();
	
	List<HManagementTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HManagementTypeEntity hManagementType);
	
	void update(HManagementTypeEntity hManagementType);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
