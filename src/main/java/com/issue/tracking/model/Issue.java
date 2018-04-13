package com.issue.tracking.model;

public class Issue {
	private String issueName;

	private String userId;

	private int issueCategory;

	private String users;

	private String issueStatus;

	private int categoryId;

	private String issueId;

	private String departmentId;

	private String updateDate;

	private String issuedDate;

	private String issueDetail;

	public Issue() {
		super();
	}

	public Issue(String issueName, String userId, int issueCategory, String users, String issueStatus, int categoryId,
			String issueId, String departmentId, String updateDate, String issuedDate, String issueDetail) {
		super();
		this.issueName = issueName;
		this.userId = userId;
		this.issueCategory = issueCategory;
		this.users = users;
		this.issueStatus = issueStatus;
		this.categoryId = categoryId;
		this.issueId = issueId;
		this.departmentId = departmentId;
		this.updateDate = updateDate;
		this.issuedDate = issuedDate;
		this.issueDetail = issueDetail;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getIssueCategory() {
		return issueCategory;
	}

	public void setIssueCategory(int issueCategory) {
		this.issueCategory = issueCategory;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(String issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getIssueDetail() {
		return issueDetail;
	}

	public void setIssueDetail(String issueDetail) {
		this.issueDetail = issueDetail;
	}

	@Override
	public String toString() {
		return "Issue [issueName=" + issueName + ", userId=" + userId + ", issueCategory=" + issueCategory + ", users="
				+ users + ", issueStatus=" + issueStatus + ", categoryId=" + categoryId + ", issueId=" + issueId
				+ ", departmentId=" + departmentId + ", updateDate=" + updateDate + ", issuedDate=" + issuedDate
				+ ", issueDetail=" + issueDetail + "]";
	}

}