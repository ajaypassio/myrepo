/**
 * 
 */
package com.delphix.api.service;

import com.delphix.api.exception.DelphixAPIException;
import com.delphix.api.modal.APIModal;

/**
 * @author AK00487304
 *
 */
public interface DelphixAPIService {
	public APIModal callNASAAPI() throws DelphixAPIException;
    public void processLogic(double longitude,double latitude,APIModal modal) throws DelphixAPIException;
}
