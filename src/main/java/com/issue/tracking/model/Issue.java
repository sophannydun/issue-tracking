package com.issue.tracking.model;

public class Issue {
	private String issueName;

	private String issueStatus;

	private String userId;

	private String categoryId;

	private String issueId;

	private String departmentId;

	private String updateDate;

	private String issuedDate;

	private String issueDetail;

	public Issue() {
		super();
	}

	public Issue(String issueName, String issueStatus, String userId, String categoryId, String issueId,
			String departmentId, String updateDate, String issuedDate, String issueDetail) {
		super();
		this.issueName = issueName;
		this.issueStatus = issueStatus;
		this.userId = userId;
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

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
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
		return "Issue [issueName=" + issueName + ", issueStatus=" + issueStatus + ", userId=" + userId + ", categoryId="
				+ categoryId + ", issueId=" + issueId + ", departmentId=" + departmentId + ", updateDate=" + updateDate
				+ ", issuedDate=" + issuedDate + ", issueDetail=" + issueDetail + "]";
	}

}