package com.qf.express.manage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qf.express.manage.api.RoleService;
import com.qf.express.manage.mapper.RoleAuthorityMapper;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleAuthorityMapper roleAuthorityMapper;
	
	@Override
	public List<String> findAuthorityByRoleid(Integer roleid) {
		// TODO Auto-generated method stub
		System.out.println("测试");
		return roleAuthorityMapper.selectAuthorityByRoleid(roleid);
	}

	@Override
	public List<String> findAuthorityTextByRoleid(Integer roleid) {
		// TODO Auto-generated method stub
		return roleAuthorityMapper.selectAuthorityTextByRoleid(roleid);
	}

}
