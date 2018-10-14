package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestStatus {

	private String status;
	private List<Map<String,String>> error;
	
	public RequestStatus() {
		super();
		error = new ArrayList();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Map<String, String>> getError() {
		return error;
	}

	public void addError(String errorCode, String errorDescription) {
		HashMap<String,String> e = new HashMap<String,String>();
		e.put(errorCode, errorDescription);
		
		error.add(e);
	}
	
	
	
}
