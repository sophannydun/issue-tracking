package com.issue.tracking.model;

public class Department {
	private int departmentId;
	private String description;
	private String code;
	private String createBy;
	private String updateBy;
	private String createDate;
	private String updateDate;
	public Department() {
		super();
	}
	public Department(int departmentId, String description, String code, String createBy, String updateBy,
			String createDate, String updateDate) {
		super();
		this.departmentId = departmentId;
		this.description = description;
		this.code = code;
		this.createBy = createBy;
		this.updateBy = updateBy;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
		return "Department [departmentId=" + departmentId + ", description=" + description + ", code=" + code
				+ ", createBy=" + createBy + ", updateBy=" + updateBy + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

	
}
