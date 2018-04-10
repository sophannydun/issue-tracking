package com.issue.tracking.model;

import java.util.List;

public class RoleCustomResponse {

	private String message;

    private boolean status;

    private List<Role> data;

	protected String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}

	protected boolean getStatus() {
		return status;
	}

	protected void setStatus(boolean status) {
		this.status = status;
	}

	protected List<Role> getData() {
		return data;
	}

	protected void setData(List<Role> data) {
		this.data = data;
	}



	@Override
	public String toString() {
		return "RoleCustomResponse [message=" + message + ", status=" + status + ", data=" + data + "]";
	}

	public RoleCustomResponse(String message, boolean status, List<Role> data) {
		super();
		this.message = message;
		this.status = status;
		this.data = data;
	}

	public RoleCustomResponse() {
		super();
	}
    
}
