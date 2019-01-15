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
import com.qf.express.manage.api.ExpressService;
import com.qf.express.manage.entity.BcStaff;
import com.qf.express.manage.entity.BcStaffExample;
import com.qf.express.manage.mapper.BcStaffMapper;
@Service
public class ExpressServiceImpl implements ExpressService {
	
	@Autowired
	private BcStaffMapper staffMapper;
	
	@Override
	public AppResult addStaff(BcStaff staff) {
		AppResult appResult = null;
		int count = 0;
		count = staffMapper.insertSelective(staff);
		if(count<1) {
			appResult = new AppResult(201, "快递员添加失败", null);
		}else {
			appResult = new AppResult(200,"快递员添加成功",null);
		}
		return appResult;
	}

	@Override
	public AppResult updStaff(Integer[] id) {
		int count = 0;
		for (Integer integer : id) {
			BcStaff staff = new BcStaff();
			staff.setId(integer);
			staff.setDeltag("1");
			count = staffMapper.updateByPrimaryKeySelective(staff);
			if(count<1) {
				throw new AppExcption(302,"废除失败");
			}
			count = 0;
		}

		return new AppResult(200,"快递员已经作废",null);
	}

	@Override
	public DataGridResult<BcStaff> findAllStacff(Integer page,Integer rows) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		List<BcStaff> list = staffMapper.selectByExample(null);
		PageInfo<BcStaff> info = new PageInfo<>(list);
		DataGridResult<BcStaff> dataResult = new DataGridResult<BcStaff>(list,(int)info.getTotal());
		return dataResult;
	}
	@Override
	public DataGridResult<BcStaff> findStacff(Integer page,Integer rows,String keys) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, rows);
		BcStaffExample exampl = new BcStaffExample();
		if(StringUtils.isEmpty(keys)==false) {
			exampl.or().andNameLike("%"+keys+"%");
			exampl.or().andTelephoneLike("%"+keys+"%");
			exampl.or().andStandardLike("%"+keys+"%");
			exampl.or().andStationLike("%"+keys+"%");
		}
		List<BcStaff> list = staffMapper.selectByExample(exampl);
		PageInfo<BcStaff> info = new PageInfo<>(list);
		DataGridResult<BcStaff> dataResult = new DataGridResult<BcStaff>(list,(int)info.getTotal());
		return dataResult;
	}

}
