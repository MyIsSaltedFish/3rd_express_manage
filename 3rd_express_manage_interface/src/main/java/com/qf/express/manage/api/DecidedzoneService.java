package com.qf.express.manage.api;

import javax.jws.WebService;

import com.qf.express.common.DataGridResult;
import com.qf.express.manage.entity.BcDecidedzone;
@WebService
public interface DecidedzoneService {
	
	//查询承包区带分页
	DataGridResult<BcDecidedzone> findDecidedzone(Integer rows,Integer page);
}
