package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.experian.pco.customdev.customdataprovider.dataaccess.Solution.SolutionApplication;

@Service
public class DatabaseAccess  {
	 
	@Autowired
	private PcoApplicationsRepository applicationsRepository;
	
	public List<SolutionApplication> getAllApplications() {
		return applicationsRepository.findAll();
	}
	    
	public List<SolutionApplication> getAppByInternalId(@PathVariable String internalid) {
		return applicationsRepository.findByInternalId(internalid);
	}
	    
	public List<SolutionApplication> getAppsInStatus(@PathVariable String status_id,  List<SolutionApplication> applicationsList)  {
		List<SolutionApplication> appsList = new ArrayList<SolutionApplication>();
		if(applicationsList != null) {
			if (applicationsList.size() > 0) {
				ArrayList appsForFilter = new ArrayList();
				for(SolutionApplication app : applicationsList) {
					if (app.getInternalid() != null) {
						appsForFilter.add(app.getInternalid());
					}
				}
				appsList = applicationsRepository.findByStatusFiltered(status_id, appsForFilter);
			}
			else appsList = applicationsRepository.findByStatus(status_id);
		}
		else {
			appsList = applicationsRepository.findByStatus(status_id);
		}
		return appsList;	
	}
	
	@Transactional
	public void setActionForApplications(String action, List<SolutionApplication> applicationsList) {
		for(SolutionApplication app : applicationsList) {
			if(app.getInternalid() != null) {
				applicationsRepository.setActionByInternalId(action, app.getInternalid());
			}
		}
	}
}
