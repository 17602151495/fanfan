
package com.wqf.imports.web.controller.hotel;

import java.util.List;
import java.util.Map;

import com.wqf.imports.hotel.entity.HManagementTypeEntity;
import com.wqf.imports.hotel.service.HManagementTypeService;
import com.wqf.imports.common.base.Query;
import com.wqf.imports.common.base.R;
import com.wqf.imports.web.controller.sys.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





/**
 * 
 * 
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-17 00:33:22
 */
@RestController
@RequestMapping("/hotel/hmanagementtype")
public class HManagementTypeController extends AbstractController {
	@Autowired
	private HManagementTypeService hManagementTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HManagementTypeEntity> hManagementTypeList = hManagementTypeService.queryList(query);
		int total = hManagementTypeService.queryTotal(query);

		return R.page(hManagementTypeList,total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("hotel:hmanagementtype:info")
	public R info(@PathVariable("id") Integer id){
		HManagementTypeEntity hManagementType = hManagementTypeService.queryObject(id);
		
		return R.ok().put("hManagementType", hManagementType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("hotel:hmanagementtype:save")
	public R save(@RequestBody HManagementTypeEntity hManagementType){
		hManagementTypeService.save(hManagementType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("hotel:hmanagementtype:update")
	public R update(@RequestBody HManagementTypeEntity hManagementType){
		hManagementTypeService.update(hManagementType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("hotel:hmanagementtype:delete")
	public R delete(@RequestBody Integer[] ids){
		hManagementTypeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
