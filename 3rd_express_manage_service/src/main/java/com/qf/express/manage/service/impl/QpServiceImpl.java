package com.qf.express.manage.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.qf.express.manage.api.QpService;
import com.qf.express.manage.entity.BcDecidedzone;
import com.qf.express.manage.entity.BcStaff;
import com.qf.express.manage.entity.BcSubarea;
import com.qf.express.manage.entity.QpNoticebill;
import com.qf.express.manage.entity.QpNoticebillExample;
import com.qf.express.manage.mapper.BcDecidedzoneMapper;
import com.qf.express.manage.mapper.BcStaffMapper;
import com.qf.express.manage.mapper.BcSubareaMapper;
import com.qf.express.manage.mapper.QpNoticebillMapper;
@Service
public class QpServiceImpl implements QpService {
	
	@Autowired
	private BcDecidedzoneMapper bcDecidedzoneMapper;
	@Autowired
	private BcStaffMapper bcStaffMapper;
	@Autowired
	private BcSubareaMapper bcSubareaMapper;
	@Autowired
	private QpNoticebillMapper qpNoticebillMapper;
	
	@Override
	public BcStaff addQp(QpNoticebill qb, String dzid) throws Exception {
		BcStaff staff = null;
		//1: 判断有没有dzid
		if(StringUtils.isEmpty(dzid)==false) {
			//1 查出dzid 对应的去拍人员id
			BcDecidedzone bz = bcDecidedzoneMapper.selectByPrimaryKey(dzid);
			String staffid = bz.getStaffId();
			// 2 根据去派员id 查找去派员 信息
			System.out.println(staffid);
			staff =  bcStaffMapper.selectByPrimaryKey(Integer.parseInt(staffid));
			System.out.println("staff是"+staff.getName()+"---id是"+staff.getId());
			// 3 完善 信息
			qb.setOrdertype("1"); //自动分单
			qb.setStaffId(staffid);
			qb.setUserId(0);
			//qb.set
		}
		//2 比较地址看是否能自动分单
		if(staff==null) {
			List<String> keys = com.qf.express.utils.StringUtils.queryWords(qb.getPickaddress());
			System.out.println(keys);
			//1 通过地址查小区
			List<BcSubarea> list = bcSubareaMapper.selectXQbyAccessKey(keys);
			if(list!=null&&list.size()==1) {
				//获得小区的承包区
				BcSubarea bs = list.get(0);
				//1 查出dzid 对应的去拍人员id
				//BcDecidedzone bz = bcDecidedzoneMapper.selectByPrimaryKey(bs.getId());
				BcDecidedzone bz = bcDecidedzoneMapper.selectByPrimaryKey(bs.getDecidedzoneId());
				String staffid = bz.getStaffId();
				// 2 根据去派员id 查找去派员 信息
				staff =  bcStaffMapper.selectByPrimaryKey(Integer.parseInt(staffid));
				// 3 完善 信息
				qb.setOrdertype("1"); //自动分单
				qb.setStaffId(staffid);
				qb.setUserId(0);
				
			}
		}
		//添加
		qb.setId(UUID.randomUUID().toString());
		qpNoticebillMapper.insert(qb);
		return staff;
	}

	@Override
	public List<QpNoticebill> findAllNoAss() {
		
		QpNoticebillExample example = new QpNoticebillExample();
		example.createCriteria().andStaffIdIsNull();
		example.or().andStaffIdEqualTo("");
		return qpNoticebillMapper.selectByExample(example);
	}

	@Override
	public List<BcStaff> findAllStaff() {
		
		return bcStaffMapper.selectByExample(null);
	}

	@Override
	public void updateForAss(QpNoticebill qb) {
		qpNoticebillMapper.updateByPrimaryKeySelective(qb);
	}
	
}
