/**
 * 
 */
package com.gl.visaapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.visaapp.exception.VisaApplicationException;
import com.gl.visaapp.modal.VisaApplicant;
import com.gl.visaapp.service.VisaApplicationService;
import com.gl.visaapp.utility.Constants;
import com.gl.visaapp.utility.VisaApplicationUtils;

/**
 * @author Ajay Kumar
 *
 */
@RestController
@RequestMapping("/api")
@Component
public class VisaApplicationController {

	private final VisaApplicationService service;

	@Autowired
	VisaApplicationController(VisaApplicationService service) {
		this.service = service;
	}
	@Autowired
	private VisaApplicationUtils utils;

	@RequestMapping(method = RequestMethod.GET, value="/visaapp")
	@ExceptionHandler(VisaApplicationException.class)
	List<VisaApplicant> findAll() {
		List<VisaApplicant> listofApplicants=new ArrayList<VisaApplicant>();

		/*Fetch from DB */
		listofApplicants=service.findAll();

		/*Fetch from file system*/
		listofApplicants.addAll(utils.readVisaApplicantsFromFile(Constants.EXTENSION_CSV));

		/* Rest API*/
		//listofApplicants.addAll(utils.readVisaApplicantsFromRestApi());

		return listofApplicants;
	}

	@RequestMapping(method = RequestMethod.GET, value="/visaappcond")
	@ExceptionHandler(VisaApplicationException.class)
	List<VisaApplicant> findDataWithCondition(@RequestParam("applicantName") String name,@RequestParam("workType") String workTp,
			@RequestParam("workExp") String workExp){
		List<VisaApplicant> listofApplicants=new ArrayList<VisaApplicant>();
		
		/*Fetch from DB */
		listofApplicants=service.findAll();
		
		/*Fetch from file system*/	
		listofApplicants.addAll(utils.readVisaApplicantsFromFile(Constants.EXTENSION_CSV));

		/*Apply condition*/		
		return utils.filterApplicantData(listofApplicants,name,workTp,workExp);	


	}

}
