
package com.wqf.imports.web.controller.hotel;

import java.util.List;
import java.util.Map;

import com.wqf.imports.web.controller.sys.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wqf.imports.hotel.entity.HotelEntity;
import com.wqf.imports.hotel.service.HotelService;
import com.wqf.imports.common.utils.PageUtils;
import com.wqf.imports.common.base.Query;
import com.wqf.imports.common.base.R;




/**
 * 
 * 
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-19 00:28:15
 */
@RestController
@RequestMapping("/hotel/hotel")
public class HotelController extends AbstractController {
	@Autowired
	private HotelService hotelService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HotelEntity> hotelList = hotelService.queryList(query);
		int total = hotelService.queryTotal(query);
		
		return R.page(hotelList,total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("hotel:hotel:info")
	public R info(@PathVariable("id") Long id){
		HotelEntity hotel = hotelService.queryObject(id);
		
		return R.ok().put("hotel", hotel);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hotel:hotel:save")
	public R save(@RequestBody HotelEntity hotel){

		hotel.setCreateby(getUserId());
		hotel.setUpdateby(getUserId());
		hotelService.save(hotel);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hotel:hotel:update")
	public R update(@RequestBody HotelEntity hotel){
		hotelService.update(hotel);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hotel:hotel:delete")
	public R delete(@RequestBody Long[] ids){
		hotelService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
