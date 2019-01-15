package com.qf.express.manage.api;

import java.util.List;

import javax.jws.WebService;

import com.qf.express.common.AppResult;
import com.qf.express.common.DataGridResult;
import com.qf.express.common.UserCombobox;
import com.qf.express.manage.entity.Role;
import com.qf.express.manage.entity.Rright;
import com.qf.express.manage.entity.Users;
@WebService
public interface UserService {
	
	//根据用户名查找
	Users findUsersForLogin(String uname ,String upass);
	//为了生成 首页 的左边的菜单
	List<Rright> findRRightsForMenu(Integer roleid,Integer parentid);
	//添加或者修改
	void addOrUpdateRight(Rright right);
	//删除节点
    void delchildrright(Integer id,Integer parentid);
    
    //根据页面上传来的角色的名称 查询角色的集合
    DataGridResult<Role> findARolesByInput(String rolename,int pageno,int pagesize);
    
    //根据id删除role
    void delrolesbychecked(int id);
    //根据id删除user
    void delusersbychecked(int id);
    //根据页面上传来的roleid 和 爸爸id  来查询权利的集合 为了角色添加和修改
  	List<Rright> findRRightsForCurd(Integer roleid,Integer parentid);
  	
	// add role
	AppResult addRole(Role role);

	// upd role
	AppResult updRole(Role role);
	
	//根据页面上传来的用户的名称 查询角色的集合
	DataGridResult<Users> findAUsersByInput(String username,int pageno,int pagesize);

	//查找所有角色
	List<UserCombobox> findAllRole();
	
	//添加user
	AppResult addUser(Users user);
	
	//修改user
	AppResult updUser(Users user);
	
	//检查rrightname
	Boolean checkrightname(String righttext);
	
	List<Users> findRrighttext(String righttext);
}
