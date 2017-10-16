/**
 * 
 */
package com.delphix.api.service.impl;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.delphix.api.exception.DelphixAPIException;
import com.delphix.api.modal.APIModal;
import com.delphix.api.service.DelphixAPIService;

/**
 * @author AK00487304
 *
 */
public class DelphixAPIServiceImpl implements DelphixAPIService{
	
	Logger log=LoggerFactory.getLogger(DelphixAPIServiceImpl.class);

	public void processLogic(double longitude, double latitude,APIModal modal)
			throws DelphixAPIException {
		// TODO Auto-generated method stub
		
		//String avgDate=restResponse[0];
		//String avgDateCount=restResponse[1];
		
		
	}

	public APIModal callNASAAPI() throws DelphixAPIException {	


		CloseableHttpClient client =HttpClients.createDefault();
		String ecareUrl	="http://services-rel03.stage.att.com" + "/kmservices/v2/contents/KM1086953?app-id=esupport" ;
			
		HttpGet get = new HttpGet(ecareUrl);
		get.addHeader("Accept", "application/json");
		CloseableHttpResponse  httpResponse=null;


		try {
			client = HttpClients.custom().build();
			httpResponse = client.execute(get);
			if(httpResponse.getStatusLine().getStatusCode() == 200){
		    String response = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			log.info(response);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(response);
			APIModal modal=new APIModal();
			modal.setAvgDate((String)jsonObject.get("avgDate"));
			modal.setAvgDateCount(Integer.parseInt((String)jsonObject.get("avgDateCount")));
			/*BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			String line;
			while((line = reader.readLine()) != null){				
				System.out.println("Next Plan : "+line );
			}*/
			return new APIModal("20/05/2017",10);
			}else{
				httpResponse.getEntity();
				httpResponse.getStatusLine().getStatusCode();				
				log.info(httpResponse.getStatusLine().getReasonPhrase());
			}

		} catch (IllegalStateException e) {
			log.error("EXCEPTION ::: ", e);
		} catch (IOException e) {
			log.error("EXCEPTION ::: ", e);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(null != httpResponse && null != client){
					httpResponse.close();
					client.close();
				}
			} catch (Exception e) {
				log.info("EXCEPTION ::: ", e);
			}
		}		
		return null;
	}

}
