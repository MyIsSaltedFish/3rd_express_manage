package com.qf.express.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.express.common.AppExcption;
import com.qf.express.common.AppResult;
import com.qf.express.common.DataGridResult;
import com.qf.express.manage.api.RegionService;
import com.qf.express.manage.entity.BcRegion;
import com.qf.express.manage.entity.BcRegionExample;
import com.qf.express.manage.entity.BcSubarea;
import com.qf.express.manage.mapper.BcRegionMapper;
import com.qf.express.manage.mapper.BcSubareaMapper;
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private BcRegionMapper regionMapper;
	@Autowired
	private BcSubareaMapper subareaMapper;
	
	@Override
	public void addRegions(List<BcRegion> list) {
		for (BcRegion bcRegion : list) {
			int count = regionMapper.insert(bcRegion);
			if(count<1) {
				throw new AppExcption(203, "上传失败 失败id=["+bcRegion.getId()+"]");
			}
		}

	}

	@Override
	public List<BcRegion> findAllRegion() {
		// TODO Auto-generated method stub
		return regionMapper.selectByExample(null);
	}

	@Override
	public DataGridResult<BcRegion> findRegion(Integer page,Integer rows) {	
		PageHelper.startPage(page, rows);
		List<BcRegion> list = regionMapper.selectByExample(null);
		PageInfo<BcRegion> info = new PageInfo<BcRegion>(list);
		DataGridResult<BcRegion> model = new DataGridResult<>(list, (int)info.getTotal());
		return model;
	}

	@Override
	public List<BcRegion> findRegionsByKeys(String q) {
		BcRegionExample example = new BcRegionExample();
		if(StringUtils.isEmpty(q)==false) {
			example.or().andProvinceLike("%"+q+"%");
			example.or().andCityLike("%"+q+"%");
			example.or().andDistrictLike("%"+q+"%");
			example.or().andShortcodeLike("%"+q+"%");
			example.or().andCitycodeLike("%"+q+"%");
		}
		return regionMapper.selectByExample(example);
	}

	
	@Override
	public AppResult addSubarea(BcSubarea subarea) {
		int count = subareaMapper.insert(subarea);
		if(count<1) {
			throw new AppExcption(203,"添加失败！");
		}
		return new AppResult(200, "添加成功", null);
	}

	@Override
	public DataGridResult<BcSubarea> findSubarea(Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		List<BcSubarea> list = subareaMapper.selectByExample(null);
		for (BcSubarea bcSubarea : list) {
			BcRegion region = regionMapper.selectByPrimaryKey(bcSubarea.getRegionId());
			bcSubarea.setRegion(region);
		}
		PageInfo<BcSubarea> info = new PageInfo<>(list);
		return new DataGridResult<>(list, (int)info.getTotal());
	}

	@Override
	public AppResult delSubarea(String[] id) {
		for (String string : id) {
			int count = subareaMapper.deleteByPrimaryKey(string);
			if(count<1) {
				throw new AppExcption(204, "删除失败，从id:"+string+"开始！");
			}
		}
		return new AppResult(200, "删除成功", null);
	}

	@Override
	public AppResult delregion(String[] id) {
		for (String string : id) {
			int count = regionMapper.deleteByPrimaryKey(string);
			if(count<1) {
				throw new AppExcption(204, "删除失败，从id:"+string+"开始！");
			}
		}
		return new AppResult(200, "删除成功", null);
	}

	@Override
	public AppResult addregion(BcRegion region) {
		int count = regionMapper.insert(region);
		if(count<1) {
			throw new AppExcption(203,"添加失败！");
		}
		return new AppResult(200, "添加成功", null);
	}

}
