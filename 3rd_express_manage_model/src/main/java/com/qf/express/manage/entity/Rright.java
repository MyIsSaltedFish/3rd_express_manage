package com.qf.express.manage.entity;

import java.util.List;

public class Rright {
	private Integer rightid;

	private String righttext;

	private Integer righttype;

	private String righturl;

	private Integer parentid;
	
	
	
	//指定角色是否具备权利  1 no 2 ok
	private Integer hasflag;
	
	

	@Override
	public String toString() {
		return "Rright [rightid=" + rightid + ", righttext=" + righttext + ", righttype=" + righttype + ", righturl="
				+ righturl + ", parentid=" + parentid + ", hasflag=" + hasflag + ", levelcount=" + levelcount
				+ ", ismenu=" + ismenu + ", child=" + child + "]";
	}

	public Integer getHasflag() {
		return hasflag;
	}

	public void setHasflag(Integer hasflag) {
		this.hasflag = hasflag;
	}

	private Integer levelcount;

	private Boolean ismenu;

	// 当前权利节点的 儿子节点
	private List<Rright> child;

	public List<Rright> getChild() {
		return child;
	}

	public void setChild(List<Rright> child) {
		this.child = child;
	}

	public Integer getRightid() {
		return rightid;
	}

	public void setRightid(Integer rightid) {
		this.rightid = rightid;
	}

	public String getRighttext() {
		return righttext;
	}

	public void setRighttext(String righttext) {
		this.righttext = righttext == null ? null : righttext.trim();
	}

	public Integer getRighttype() {
		return righttype;
	}

	public void setRighttype(Integer righttype) {
		this.righttype = righttype;
	}

	public String getRighturl() {
		return righturl;
	}

	public void setRighturl(String righturl) {
		this.righturl = righturl == null ? null : righturl.trim();
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getLevelcount() {
		return levelcount;
	}

	public void setLevelcount(Integer levelcount) {
		this.levelcount = levelcount;
	}

	public Boolean getIsmenu() {
		return ismenu;
	}

	public void setIsmenu(Boolean ismenu) {
		this.ismenu = ismenu;
	}
}