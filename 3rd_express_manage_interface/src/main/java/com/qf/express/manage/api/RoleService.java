package com.qf.express.manage.api;

import java.util.List;

import javax.jws.WebService;
@WebService
public interface RoleService {

	//根据角色id 操作权利的集合
	List<String> findAuthorityByRoleid(Integer roleid);
	
	//根据角色id 操作权利的集合
	List<String> findAuthorityTextByRoleid(Integer roleid);
}
