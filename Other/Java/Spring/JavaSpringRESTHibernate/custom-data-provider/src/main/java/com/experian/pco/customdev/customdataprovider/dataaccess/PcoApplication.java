package com.experian.pco.customdev.customdataprovider.dataaccess;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "APPLICATION", schema = "EDA_TENANT1")
public class PcoApplication {
    @Id
    private Long ids_application;
    private String internalid;
    private String status;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ids_application")
    private Set<Applicant> applicants = new HashSet<>();
    
    PcoApplication() {
        super();
    }

    public Long getIds_application() {
        return ids_application;
    }

    public void setIds_application(Long ids_application) {
        this.ids_application = ids_application;
    }

    public String getInternalid() {
        return internalid;
    }

    public void setInternalid(String internalid) {
        this.internalid = internalid;
    }

    public String getStatus() {
        return status;
    }

    public Set<Applicant> getApplicants() {
        return applicants;
    }
    
}
