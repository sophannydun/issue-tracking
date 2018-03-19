package com.issue.tracking.model;

import java.util.Date;

public class Role {
	private int roleID;
	private String 	roleName;
	private String roleCode;
	private String createBy;
	private String updateBy;
	private String createDate;
	private String updateDate;
	
	public Role(int roleID, String roleName, String roleCode, String createBy, String updateBy, String createDate,
			String updateDate) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleCode = roleCode;
		this.createBy = createBy;
		this.updateBy = updateBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", roleCode=" + roleCode + ", createBy=" + createBy
				+ ", updateBy=" + updateBy + ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}
	
}
