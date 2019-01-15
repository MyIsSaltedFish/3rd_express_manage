package com.qf.express.manage.api;


import javax.jws.WebService;

import com.qf.express.common.AppResult;
import com.qf.express.common.DataGridResult;
import com.qf.express.manage.entity.BcStaff;

//快递服务
@WebService
public interface ExpressService {
	//添加快递员
	AppResult addStaff(BcStaff staff);
	//废除快递员
	AppResult updStaff(Integer[] id);
	//查询所有快递员
	DataGridResult<BcStaff> findAllStacff(Integer page,Integer rows);
	
	DataGridResult<BcStaff> findStacff(Integer page,Integer rows,String keys);
}
