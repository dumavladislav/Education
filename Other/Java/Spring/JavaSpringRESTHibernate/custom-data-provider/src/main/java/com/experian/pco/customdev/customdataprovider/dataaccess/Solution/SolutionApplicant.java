package com.experian.pco.customdev.customdataprovider.dataaccess.Solution;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="APPLICANT"/*, schema = "EDA_TENANT1"*/)
public class SolutionApplicant {

    @Id
    private Long ids_applicant;
    private Long ids_application;
    private Integer applicantid;
    private Integer clienttype;
    private String lastname;
    private String firstname;
    private String middlename;
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ids_extcalls")
    private Set<SolutionApplicantExtCalls> extcalls = new HashSet<>();
    
    SolutionApplicant() {
        super();
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

	public Integer getApplicantid() {
		return applicantid;
	}

	public Integer getClienttype() {
		return clienttype;
	}

	public Set<SolutionApplicantExtCalls> getExtcalls() {
		return extcalls;
	}
    
	
}
