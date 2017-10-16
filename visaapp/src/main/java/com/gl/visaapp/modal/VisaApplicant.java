/**
 * 
 */
package com.gl.visaapp.modal;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Ajay Kumar
 *
 */
@Document(collection="VisaApplicant")
public class VisaApplicant implements Serializable{

	
	private static final long serialVersionUID = 1397608846625941556L;
	
    @Id
	public String id;
    public String applicantName;
    public String jobType;
    public String workExp;
    public String marStatus;
    public String salary;
	
	

	/**
	 * @return the applicantName
	 */
	public String getApplicantName() {
		return applicantName;
	}

	/**
	 * @param applicantName the applicantName to set
	 */
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	/**
	 * @return the workExp
	 */
	public String getWorkExp() {
		return workExp;
	}

	/**
	 * @param workExp the workExp to set
	 */
	public void setWorkExp(String workExp) {
		this.workExp = workExp;
	}

	/**
	 * @return the marStatus
	 */
	public String getMarStatus() {
		return marStatus;
	}

	/**
	 * @param marStatus the marStatus to set
	 */
	public void setMarStatus(String marStatus) {
		this.marStatus = marStatus;
	}

	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(String salary) {
		this.salary = salary;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Applicant [applicantName=" + applicantName + ", jobType="
				+ jobType + ", workExp=" + workExp + ", marStatus=" + marStatus
				+ ", salary=" + salary + "]";
	}
	
	
	
}
