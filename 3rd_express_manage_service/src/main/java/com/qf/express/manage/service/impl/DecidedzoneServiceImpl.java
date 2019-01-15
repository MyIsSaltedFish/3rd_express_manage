package com.qf.express.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.express.common.DataGridResult;
import com.qf.express.manage.api.DecidedzoneService;
import com.qf.express.manage.entity.BcDecidedzone;
import com.qf.express.manage.entity.BcStaff;
import com.qf.express.manage.mapper.BcDecidedzoneMapper;
import com.qf.express.manage.mapper.BcStaffMapper;
@Service
public class DecidedzoneServiceImpl implements DecidedzoneService {

	@Autowired
	private BcDecidedzoneMapper decidedzoneMapper;
	@Autowired
	private BcStaffMapper staffMapper;
	@Override
	public DataGridResult<BcDecidedzone> findDecidedzone(Integer rows, Integer page) {
		PageHelper.startPage(page, rows);
		List<BcDecidedzone> list = decidedzoneMapper.selectByExample(null);
		for (BcDecidedzone bcDecidedzone : list) {
			BcStaff staff = staffMapper.selectByPrimaryKey(Integer.parseInt(bcDecidedzone.getStaffId()));
			bcDecidedzone.setStaff(staff);
		}
		PageInfo<BcDecidedzone> info = new PageInfo<>(list);
		return new DataGridResult<>(list,(int)info.getTotal());
	}

}
