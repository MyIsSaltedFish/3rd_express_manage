package com.qf.express.manage.entity;

import java.util.List;

public class Role {
    private Integer roleid;

    private String rolename;

    //这个角色拥有的权利的字符串
    private String rightNames;
    // 当前角色对象 拥有的权限的id的集合
    private List<Integer> rights;
    
    @Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", rightNames=" + rightNames + ", rights=" + rights
				+ "]";
	}

	public List<Integer> getRights() {
		return rights;
	}

	public void setRights(List<Integer> rights) {
		this.rights = rights;
	}

	public String getRightNames() {
		return rightNames;
	}

	public void setRightNames(String rightNames) {
		this.rightNames = rightNames;
	}

	public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }
}