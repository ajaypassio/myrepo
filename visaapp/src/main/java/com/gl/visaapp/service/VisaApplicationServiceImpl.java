/**
 * 
 */
package com.gl.visaapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.visaapp.modal.VisaApplicant;
import com.gl.visaapp.repository.VisaApplicationRepo;

/**
 * @author Ajay Kumar
 *
 */
@Service
public class VisaApplicationServiceImpl implements VisaApplicationService{

	private final VisaApplicationRepo repository; 
	
	 @Autowired
	 VisaApplicationServiceImpl(VisaApplicationRepo repository) {
	        this.repository = repository;
	 }
	 
	@Override
	    public List<VisaApplicant> findAll() {
	        List<VisaApplicant> listOfApplicants = repository.findAll();
	        return listOfApplicants;
	    }
}
