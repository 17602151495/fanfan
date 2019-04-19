package com.wqf.imports.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wqf.imports.hotel.dao.HotelDao;
import com.wqf.imports.hotel.entity.HotelEntity;
import com.wqf.imports.hotel.service.HotelService;



@Service("hotelService")
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelDao hotelDao;
	
	@Override
	public HotelEntity queryObject(Long id){
		return hotelDao.queryObject(id);
	}
	
	@Override
	public List<HotelEntity> queryList(Map<String, Object> map){
		return hotelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return hotelDao.queryTotal(map);
	}
	
	@Override
	public void save(HotelEntity hotel){
		hotelDao.save(hotel);
	}
	
	@Override
	public void update(HotelEntity hotel){
		hotelDao.update(hotel);
	}
	
	@Override
	public void delete(Long id){
		hotelDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		hotelDao.deleteBatch(ids);
	}
	
}
