package com.experian.pco.customdev.customdataprovider.dataaccess.Solution;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EXTCALLS")
public class SolutionApplicantExtCalls {

	@Id
	private Long ids_extcalls;
	private String calltype;
	private String interfacename;
	private String interfaceon;
	private String callstatus;
	private Date calldate;
	private String calltime;
	private String errorcode;
	private String errordescription;
	
	SolutionApplicantExtCalls() {
        super();
    }

	public Long getIdsExtcalls() {
		return ids_extcalls;
	}

	public String getCalltype() {
		return calltype;
	}

	public String getInterfacename() {
		return interfacename;
	}

	public String getInterfaceon() {
		return interfaceon;
	}

	public String getCallstatus() {
		return callstatus;
	}

	public Date getCalldate() {
		return calldate;
	}

	public String getCalltime() {
		return calltime;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public String getErrordescription() {
		return errordescription;
	}
	
	
}
