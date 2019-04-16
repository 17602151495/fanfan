package com.wqf.imports.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wqf.imports.hotel.dao.HManagementTypeDao;
import com.wqf.imports.hotel.entity.HManagementTypeEntity;
import com.wqf.imports.hotel.service.HManagementTypeService;



@Service("hManagementTypeService")
public class HManagementTypeServiceImpl implements HManagementTypeService {
	@Autowired
	private HManagementTypeDao hManagementTypeDao;
	
	@Override
	public HManagementTypeEntity queryObject(Integer id){
		return hManagementTypeDao.queryObject(id);
	}
	
	@Override
	public List<HManagementTypeEntity> queryList(Map<String, Object> map){
		return hManagementTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hManagementTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(HManagementTypeEntity hManagementType){
		hManagementTypeDao.save(hManagementType);
	}
	
	@Override
	public void update(HManagementTypeEntity hManagementType){
		hManagementTypeDao.update(hManagementType);
	}
	
	@Override
	public void delete(Integer id){
		hManagementTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		hManagementTypeDao.deleteBatch(ids);
	}
	
}
