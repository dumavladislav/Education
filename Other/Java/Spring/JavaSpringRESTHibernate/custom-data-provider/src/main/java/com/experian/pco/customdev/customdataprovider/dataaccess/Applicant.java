package com.experian.pco.customdev.customdataprovider.dataaccess;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPLICANT", schema = "EDA_TENANT1")
public class Applicant {

    @Id
    private Long ids_applicant;
    private Long ids_application;
    private String lastname;
    private String firstname;
    private String middlename;
    
    Applicant() {
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
    
}
