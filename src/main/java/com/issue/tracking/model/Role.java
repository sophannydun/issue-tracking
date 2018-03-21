package com.issue.tracking.model;

import java.sql.Timestamp;

public class Role {
	private int roleID;
	private String 	roleName;
	private String roleCode;
	private String createBy;
	private String updateBy;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	public Role(int roleID, String roleName, String roleCode, String createBy, String updateBy, Timestamp date,
			Timestamp date2) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.createBy = createBy;
		this.updateBy = updateBy;
		this.createDate = date;
		this.updateDate = date2;
	}
	public Role( String roleName, String roleCode, String createBy, String updateBy, Timestamp date,
			Timestamp date2) {
		super();
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.createBy = createBy;
		this.updateBy = updateBy;
		this.createDate = date;
		this.updateDate = date2;
	}
	public Role() {
		super();
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", roleCode=" + roleCode + ", createBy=" + createBy
				+ ", updateBy=" + updateBy + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
