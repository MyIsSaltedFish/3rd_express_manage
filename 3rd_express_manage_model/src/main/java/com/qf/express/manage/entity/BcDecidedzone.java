package com.qf.express.manage.entity;

public class BcDecidedzone {
    private String id;

    private String name;

    private String staffId;
    
    //快递员
    private BcStaff staff;
    
    public BcStaff getStaff() {
		return staff;
	}

	public void setStaff(BcStaff staff) {
		this.staff = staff;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }
}