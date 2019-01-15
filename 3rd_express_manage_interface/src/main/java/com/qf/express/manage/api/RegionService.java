package com.qf.express.manage.api;

import java.util.List;

import javax.jws.WebService;

import com.qf.express.common.AppResult;
import com.qf.express.common.DataGridResult;
import com.qf.express.manage.entity.BcRegion;
import com.qf.express.manage.entity.BcSubarea;
@WebService
public interface RegionService {
	//添加
	void addRegions(List<BcRegion> list);
	
	//查询
	List<BcRegion> findAllRegion();
	
	//查询
	DataGridResult<BcRegion> findRegion(Integer page,Integer rows);
	
	//根据key查询BcRegion
	List<BcRegion> findRegionsByKeys(String q);
	
	//添加bc_subarea
	AppResult addSubarea(BcSubarea subarea);
	
	//查询所有bc_subarea
	DataGridResult<BcSubarea> findSubarea(Integer page,Integer rows);
	
	//删除bc_subarea
	AppResult delSubarea(String[] id);
	
	//删除region
	AppResult delregion(String[] id);
	
	//添加region
	AppResult addregion(BcRegion region);
}
