/**
 * 
 */
package com.gl.visaapp.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.gl.visaapp.modal.VisaApplicant;
/**
 * @author Ajay Kumar
 *
 */
@Component
public class VisaApplicationUtils {



	@Value("${filesystem.delimiter}")
	private String delimiter;

	public List<VisaApplicant> readVisaApplicantsFromFile(String extension) {	


		List<VisaApplicant> listofApplicants=null;
		/*Perform csv operation*/
		if(extension.equals(Constants.EXTENSION_CSV)){
			StringBuffer fileNameDefined=new StringBuffer(Constants.FILE_PATH).append(Constants.DOT).append(extension);
			File file = new File(fileNameDefined.toString());
			VisaApplicant applicant=null;
			Scanner inputStream=null;			
			try{
				listofApplicants=new ArrayList<VisaApplicant>();
				// read with Scanner class
				inputStream = new Scanner(file);
				// hashNext() loops line-by-line
				while(inputStream.hasNext()){	            	
					//read single line, put in string
					String[] dataList = inputStream.next().split(delimiter);               
					applicant=new VisaApplicant();
					applicant.setApplicantName(dataList[0]);
					applicant.setJobType(dataList[1]);
					applicant.setWorkExp(dataList[2]);
					applicant.setMarStatus(dataList[3]);	                
					applicant.setSalary(dataList[4]); 
					listofApplicants.add(applicant);	                
					System.out.println(Arrays.toString(dataList) + "***");
				} 
			}catch (FileNotFoundException e){
				e.printStackTrace();
			}finally{
				// after loop, close scanner
				inputStream.close();
			}
		}
		return listofApplicants;
	}

	public List<VisaApplicant> filterApplicantData(List<VisaApplicant> listofApplicants,String name,String workTp,String workExp){

		List<VisaApplicant> filteredApplicantList=null;
		if(!listofApplicants.isEmpty()){
			filteredApplicantList=new ArrayList<VisaApplicant>();
			for(VisaApplicant applicant:listofApplicants){
				if(applicant.getApplicantName().equals(name)  &&
						applicant.getJobType().equals(workTp) && 
						applicant.getWorkExp().equals(workExp)){
					filteredApplicantList.add(applicant);
				}else if(applicant.getApplicantName().equals(name)  ||
						applicant.getJobType().equals(workTp) || 
						applicant.getWorkExp().equals(workExp)){
					filteredApplicantList.add(applicant);
				}
			}
		}
		return filteredApplicantList;
	}	

	@SuppressWarnings("unchecked")
	public List<VisaApplicant> readVisaApplicantsFromRestApi(){

		List<VisaApplicant> restAPIApplicantList=new ArrayList<VisaApplicant>();

		RestTemplate restTemplate = new RestTemplate();

		restAPIApplicantList=restTemplate.getForObject("http://localhost:8082/api/restApi", List.class );

		return restAPIApplicantList;
	}
}
