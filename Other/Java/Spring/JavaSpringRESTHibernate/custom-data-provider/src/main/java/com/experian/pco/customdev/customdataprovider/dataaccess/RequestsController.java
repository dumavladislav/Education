package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.experian.pco.customdev.customdataprovider.dataaccess.Solution.SolutionApplication;
import com.experian.pco.customdev.customdataprovider.dataaccess.Solution.SolutionApplicationsActionRequest;
import com.fasterxml.jackson.annotation.JsonRawValue;

@RestController
public class RequestsController {
	
	@Autowired
    private DatabaseAccess databaseAccess;
    
    @CrossOrigin
    @GetMapping("/applications")
    public List<SolutionApplication> getAllApps() {
        return databaseAccess.getAllApplications();
    }
    
    @CrossOrigin
    @GetMapping("/application/{internalid}")
    public List<SolutionApplication> getAppByInternalId(@PathVariable String internalid) {
        return databaseAccess.getAppByInternalId(internalid);
    }
    
    @CrossOrigin
    @GetMapping("/applications/status/{status_id}")
    public List<SolutionApplication> getAppsInStatus(@PathVariable String status_id)  {
        return databaseAccess.getAppsInStatus(status_id, null);
    }
    
    @CrossOrigin
    @GetMapping(value = "/applications/getSearchFormForAction/{actionid}", produces = "application/json")
    public @JsonRawValue @ResponseBody SolutionApplicationsActionRequest getSearchFormForAction(@PathVariable String actionid)  {
        //return "{\"ttt\": 111, \"qqq\": {\"aaa\": 222, \"bbb\": 333}}";
    	return new SolutionApplicationsActionRequest();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/applications/getApplicationsForAction/{actionid}", method=RequestMethod.POST)
    @ResponseBody
    public SolutionApplicationsActionRequest getApplicationsForAction(@RequestBody SolutionApplicationsActionRequest applicationActionRequest)  {
    	
    	SolutionApplicationsActionRequest bpsApplicationsActionRequest = new SolutionApplicationsActionRequest();

    	switch(applicationActionRequest.getAction()) {
    		case "RETURNFROMERROR":
    			bpsApplicationsActionRequest.setApplicationsList(databaseAccess.getAppsInStatus("10", applicationActionRequest.getApplicationsList()));
    			break;
    		default: break;
    	}
    	
    	return bpsApplicationsActionRequest;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/applications/action/{actionid}", method=RequestMethod.POST)
    @ResponseBody
    public RequestStatus setActionForApplications(@RequestBody SolutionApplicationsActionRequest applicationActionRequest) {
    	
    	RequestStatus requestStatus = new RequestStatus();
    	requestStatus.setStatus("0");
    	
    	
    	switch(applicationActionRequest.getAction()) {
	    	case "RETURNFROMERROR":
	    		databaseAccess.setActionForApplications(applicationActionRequest.getAction(), applicationActionRequest.getApplicationsList());
				break;
			default: {
				requestStatus.setStatus("-1");
				requestStatus.addError("-1", "Unknown Action ID");
				break;
			}
    	}
    	
        return requestStatus;
    }
    
}
