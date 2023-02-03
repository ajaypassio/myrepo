package com.questdiagnostics.campaignservice.response.model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
public class ResponseObjectModel {
	private HttpStatus status;

	private String message;

	private String authToken;
	
	private long count;
	
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Object data;

	private long total;

	private long totalPages;
	
	public int getStatus() {
		if(null!=status) {
			return status.value();
		}
		return 0;
	}

	public HttpStatus getHttpStatus() {
		return status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setHttpStatus(HttpStatus ok) {
		this.status = ok;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}


}