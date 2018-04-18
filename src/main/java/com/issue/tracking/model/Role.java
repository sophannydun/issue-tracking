package com.issue.tracking.model;

public class Role{
/*implements GrantedAuthority{*/
	private int roleId;
	private String role;
	private String createby;
	private String updateby;
	private String createdate;
	private String updatedate;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCreateby() {
		return createby;
	}
	public void setCreateby(String createby) {
		this.createby = createby;
	}
	public String getUpdateby() {
		return updateby;
	}
	public void setUpdateby(String updateby) {
		this.updateby = updateby;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public Role(int roleId, String role, String createby, String updateby, String createdate, String updatedate) {
		super();
		this.roleId = roleId;
		this.role = role;
		this.createby = createby;
		this.updateby = updateby;
		this.createdate = createdate;
		this.updatedate = updatedate;
	}
	public Role() {
		super();
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", role=" + role + ", createby=" + createby + ", updateby=" + updateby
				+ ", createdate=" + createdate + ", updatedate=" + updatedate + "]";
	}
	
	
	
}
