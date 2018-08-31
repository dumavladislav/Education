package com.experian.pco.customdev.customdataprovider.dataaccess.Solution;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.experian.pco.customdev.customdataprovider.dataaccess.DatabaseAccess;

public class SolutionApplicationsActionRequest {
	
	private String action;
	private List<HashMap<String, String>> additionalParameters;
	private List<SolutionApplication> applicationsList;
	
	@Autowired
    private DatabaseAccess databaseAccess;
	
	public SolutionApplicationsActionRequest() {
/*		additionalParameters = new ArrayList();
		HashMap<String, String> ttt = new HashMap<String, String>();
		ttt.put("QQQ", "123123");
		ttt.put("PPP", "ertertert");
		additionalParameters.add(ttt);*/
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<SolutionApplication> getApplicationsList() {
		return applicationsList;
	}

	public void setApplicationsList(List<SolutionApplication> applicationsList) {
		this.applicationsList = applicationsList;
	}

	public List<HashMap<String, String>> getAdditionalParameters() {
		return additionalParameters;
	}

	public void setAdditionalParameters(List<HashMap<String, String>> additionalParameters) {
		this.additionalParameters = additionalParameters;
	}

}
