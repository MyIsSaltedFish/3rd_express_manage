package com.qf.express.manage.api;

import java.util.List;

import javax.jws.WebService;

import com.qf.express.manage.entity.BcStaff;
import com.qf.express.manage.entity.QpNoticebill;

@WebService
public interface QpService {
	//添加订单
	BcStaff addQp(QpNoticebill qb, String dzid) throws Exception;

	// 查询所有没有指派去拍人员的单
	List<QpNoticebill> findAllNoAss();

	// 查询所有的去派人员
	List<BcStaff> findAllStaff();

	// 更新去派单（手动分派）
	void updateForAss(QpNoticebill qb);
}
