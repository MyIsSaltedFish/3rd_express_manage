package com.qf.express.manage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.express.common.AppExcption;
import com.qf.express.common.AppResult;
import com.qf.express.common.DataGridResult;
import com.qf.express.common.UserCombobox;
import com.qf.express.manage.api.UserService;
import com.qf.express.manage.entity.Role;
import com.qf.express.manage.entity.RoleExample;
import com.qf.express.manage.entity.RoleRight;
import com.qf.express.manage.entity.RoleRightExample;
import com.qf.express.manage.entity.Rright;
import com.qf.express.manage.entity.RrightExample;
import com.qf.express.manage.entity.Users;
import com.qf.express.manage.entity.UsersExample;
import com.qf.express.manage.mapper.RoleMapper;
import com.qf.express.manage.mapper.RoleRightMapper;
import com.qf.express.manage.mapper.RrightMapper;
import com.qf.express.manage.mapper.UsersMapper;

@Service
public class UsersServiceImpl implements UserService {
	
	@Autowired
	private UsersMapper usersMapper; 
	@Autowired
	private RrightMapper rightMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private RoleRightMapper roleRightMapper;
	@Override
	public Users findUsersForLogin(String uname, String upass) {
		UsersExample example = new UsersExample();
		example.createCriteria().andUnameEqualTo(uname);
		List<Users> list = usersMapper.selectByExample(example);
		if(list==null||list.size()==0) {
			throw new AppExcption(201, "用户名不存在");
		}
		if(list.get(0).getUpassword().equals(upass)==false) {
			throw new AppExcption(201, "密码错误");
		}
		return list.get(0);
	}

	@Override
	public List<Rright> findRRightsForMenu(Integer roleid, Integer parentid) {
		//查出最上层的权利节点
		List<Rright> rights = rightMapper.selectRightByPidAndRoleid(roleid, parentid);
		for (Rright rright : rights) {
			//以每一个节点id  为父亲 再去查新儿子节点的集合
			List<Rright> crights = rightMapper.selectRightByPidAndRoleid(roleid, rright.getRightid());
			rright.setChild(crights);
		}
		return rights;
	}

	@Override
	public void addOrUpdateRight(Rright right) {
		int count = 0;
		//1 根基rightid来确定 添加还是删除
		if(right.getRightid()==null) {
			right.setIsmenu(false);
			right.setRighttype(1);
			if(right.getParentid()==0) {
				right.setRighttype(0);
			}
			count = rightMapper.insertSelective(right);
		}else{
			count = rightMapper.updateByPrimaryKeySelective(right);
		}
		if(count<=0) {
			throw new AppExcption(201, "修改失败");
		}
		
	}

	@Override
	public void delchildrright(Integer id, Integer parentid) {
		int count = 0;
		
		count = rightMapper.deleteByPrimaryKey(id);
		if(parentid!=null&&parentid!=0) {
			RrightExample example = new RrightExample();
			example.createCriteria().andParentidEqualTo(parentid);
			count = rightMapper.deleteByExample(example);
		}
		if(count<=0) {
			throw new AppExcption(201, "修改失败");
		}
	}

	@Override
	public DataGridResult<Role> findARolesByInput(String rolename, int pageno, int pagesize) {
		PageHelper.startPage(pageno, pagesize);
		RoleExample example = null;
		if(StringUtils.isEmpty(rolename)==false) {
			example = new RoleExample();
			example.createCriteria().andRolenameLike("%"+rolename+"%");
		}
		List<Role> list = roleMapper.selectByExample(example);
		for (Role role : list) {
			StringBuilder rightNames = new StringBuilder();
			List<String> rights = roleMapper.selectRightNamesByRoleid(role.getRoleid());
			for (String string : rights) {
				rightNames.append(string+",");
			}
			String s = null;
			if(rightNames.length()>0) {
				s = rightNames.substring(0, rightNames.length()-1);
			}
			role.setRightNames(s);
		}
		PageInfo<Role> info = new PageInfo<>(list);
		DataGridResult<Role> model = new DataGridResult<>(list, (int)info.getTotal());
		return model;
	}
	
	@Override
	public DataGridResult<Users> findAUsersByInput(String username, int pageno, int pagesize) {
		PageHelper.startPage(pageno, pagesize);
		List<Users> list = usersMapper.selectUsersForInput(username);
		PageInfo<Users> info = new PageInfo<>(list);
		DataGridResult<Users> model = new DataGridResult<>(list, (int)info.getTotal());
		return model;
	}

	
	@Override
	public void delrolesbychecked(int id) {
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Rright> findRRightsForCurd(Integer roleid, Integer parentid) {
		// TODO Auto-generated method stub
		return rightMapper.selectrightsforcurd(roleid, parentid);
	}

	@Override
	public AppResult addRole(Role role) {
		//1 添加角色
		int count = roleMapper.insertSelective(role);
		if (count < 1) {
			throw new AppExcption(201, "添加角色失败");
		}
		// 2 添加的角色权利
		for (Integer rightid : role.getRights()) {
			RoleRight record = new RoleRight();
			record.setRoleid(role.getRoleid());
			record.setRightid(rightid);
			count = roleRightMapper.insertSelective(record);
			if (count < 1) {
				throw new AppExcption(201, "添加角色权利失败");
			}
		}

		return new AppResult(200, "添加角色成功", role);
	}

	@Override
	public AppResult updRole(Role role) {
		//1 修改角色
		int count = roleMapper.updateByPrimaryKeySelective(role);
		if (count < 1) {
			throw new AppExcption(201, "更新角色失败");
		}
		RoleRightExample example = new RoleRightExample();
		example.createCriteria().andRoleidEqualTo(role.getRoleid());
		// 2 根据角色id 删除所有的权利
		roleRightMapper.deleteByExample(example);
		// 3一条条添加权利
		for (Integer rightid : role.getRights()) {
			RoleRight record = new RoleRight();
			record.setRoleid(role.getRoleid());
			record.setRightid(rightid);
			count = roleRightMapper.insertSelective(record);
			if (count < 1) {
				throw new AppExcption(201, "添加角色权利失败");
			}
		}
		return new AppResult(200, "修改角色成功", role);
	}

	@Override
	public void delusersbychecked(int id) {
		int count = 0; 
		count = usersMapper.deleteByPrimaryKey((short) id);
		if(count<1) {
			throw new AppExcption(201,"删除失败！");
		}
	}

	@Override
	public List<UserCombobox> findAllRole() {
		// TODO Auto-generated method stub
		List<UserCombobox> list = new ArrayList<>();
		List<Role> roles = roleMapper.selectByExample(null);
		for (Role role : roles) {
			UserCombobox userCombobox = new UserCombobox();
			userCombobox.setRoleid(role.getRoleid());
			userCombobox.setRolename(role.getRolename());
			list.add(userCombobox);
		}
		return list;
	}

	@Override
	public AppResult addUser(Users user) {
		// 1 添加user
		int count = usersMapper.insertSelective(user);
		if (count < 1) {
			throw new AppExcption(201, "添加user失败");
		}
		return new AppResult(200, "添加user成功", user);
	}

	@Override
	public AppResult updUser(Users user) {
		// 1 修改user
		int count = usersMapper.updateByPrimaryKeySelective(user);
		if (count < 1) {
			throw new AppExcption(201, "更新user失败");
		}
		return new AppResult(200, "更新user成功", user);
	}

	@Override
	public Boolean checkrightname(String righttext) {
		Boolean flag = false;
		RrightExample example = new RrightExample();
		example.createCriteria().andRighttextEqualTo(righttext);
		List<Rright> list = rightMapper.selectByExample(example);
		if(list.size()==0||list==null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Users> findRrighttext(String righttext) {
		UsersExample example = new UsersExample();
		example.createCriteria().andUnameEqualTo(righttext);
		return usersMapper.selectByExample(example);
	}
}
