/**
 * 
 */
package com.gl.visaapp.service;

import java.util.List;

import com.gl.visaapp.modal.VisaApplicant;

/**
 * @author Ajay Kumar
 *
 */
public interface VisaApplicationService {

	List<VisaApplicant> findAll();
}
