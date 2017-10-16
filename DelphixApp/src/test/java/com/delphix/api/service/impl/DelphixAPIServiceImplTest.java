/**
 * 
 */
package com.delphix.api.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.delphix.api.exception.DelphixAPIException;
import com.delphix.api.modal.APIModal;
import com.delphix.api.service.DelphixAPIService;

/**
 * @author AK00487304
 *
 */

public class DelphixAPIServiceImplTest {

	public APIModal modal;
	
	@Mock
	DelphixAPIService delphixAPIService;
	
	@Before
	public void setup(){
		modal=new APIModal("20/5/2017", 23);
		delphixAPIService=mock(DelphixAPIServiceImpl.class);
		try {
			when(delphixAPIService.callNASAAPI()).thenReturn(modal);
		} catch (DelphixAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testRestAPI(){
		
        try {
        	modal=delphixAPIService.callNASAAPI();			
		} catch (DelphixAPIException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	   assertNotNull(modal);		
	}
}
