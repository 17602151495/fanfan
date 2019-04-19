package com.wqf.imports.hotel.service;

import com.wqf.imports.hotel.entity.HotelEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-19 00:28:15
 */
public interface HotelService {
	
	HotelEntity queryObject(Long id);
	
	List<HotelEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(HotelEntity hotel);
	
	void update(HotelEntity hotel);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
