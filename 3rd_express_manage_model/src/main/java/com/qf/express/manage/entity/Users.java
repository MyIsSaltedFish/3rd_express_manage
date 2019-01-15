package com.qf.express.manage.entity;

public class Users {
    private Short uid;

    private String uname;

    private String utruename;

    private String upassword;

    private Integer roleid;
    //角色名
    private String rolename;
    
    @Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", utruename=" + utruename + ", upassword=" + upassword
				+ ", roleid=" + roleid + ", rolename=" + rolename + "]";
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Short getUid() {
        return uid;
    }

    public void setUid(Short uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUtruename() {
        return utruename;
    }

    public void setUtruename(String utruename) {
        this.utruename = utruename == null ? null : utruename.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}