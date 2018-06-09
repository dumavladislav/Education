package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PcoDataController {
    
    @Autowired
    private PcoApplicationsRepository applicationsRepository;
    
    @CrossOrigin
    @GetMapping("/applications")
    public List<PcoApplication> getAllApps() {
        return applicationsRepository.findAll();
    }
    
    @CrossOrigin
    @GetMapping("/application/{internalid}")
    public List<PcoApplication> getAppByInternalId(@PathVariable String internalid) {
        return applicationsRepository.findByInternalId(internalid);
    }
    
    @CrossOrigin
    @GetMapping("/applications/status/{status_id}")
    public List<PcoApplication> getAppsInStatus(@PathVariable String status_id)  {
        return applicationsRepository.findByStatus(status_id);
    }
    
}
