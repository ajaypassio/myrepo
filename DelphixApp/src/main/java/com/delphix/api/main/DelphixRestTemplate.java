/**
 * 
 */
package com.delphix.api.main;

import com.delphix.api.exception.DelphixAPIException;
import com.delphix.api.main.helper.DelphixUtils;
import com.delphix.api.modal.APIModal;
import com.delphix.api.service.DelphixAPIService;
import com.delphix.api.service.impl.DelphixAPIServiceImpl;

/**
 * @author Ajay Kumar
 *
 */
public class DelphixRestTemplate {

	/**
	 * @param args
	 */
	public void flyBy(double longitude,double latitude){
		if(DelphixUtils.isNotNull(longitude) && DelphixUtils.isNotNull(latitude)){
		try{
			/*Call NASA Rest Api*/
			DelphixAPIService delphixAPIService=new DelphixAPIServiceImpl();
			APIModal modal=delphixAPIService.callNASAAPI();
			delphixAPIService.processLogic(longitude, latitude,modal);
		}catch(DelphixAPIException de){
			de.printStackTrace();
		}
	  }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    new DelphixRestTemplate().flyBy(12.67,56.89);
	}

}
