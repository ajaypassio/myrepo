to Set Proxy >> git config --global http.proxy http://username:password@hostip:port

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AveDate {
	
	
	    

	public static void main(String[] args) {
		
		long lastDateInResponse=0L;
		List<Date> dates=new ArrayList();
		dates.add(getConvertedDate("2014-02-04T03:30:01"));
		dates.add(getConvertedDate("2014-02-20T06:29:47"));
		dates.add(getConvertedDate("2014-03-08T03:00:33"));
		
		
		long totalSeconds = 0L;
		for (int i=0;i<dates.size();i++) {
		     totalSeconds += dates.get(i).getTime() / 1000L;
		     if(i==dates.size()-1){		    	 
		    	 lastDateInResponse=dates.get(i).getTime();
		     }
		}
		long averageSeconds = totalSeconds / dates.size();
		Date last_date = new Date(averageSeconds+lastDateInResponse);
		long avg_time_delta=((last_date.getTime()-lastDateInResponse)/ (60 * 60 * 1000 ))/24;
		
		System.out.println(last_date);
		System.out.println(avg_time_delta);
	}
	
	public static Date getConvertedDate(String date){
		Date convertedDate=null;
		if(null!=date){
		String[] arr=date.split("T");		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
	    try {
	    	convertedDate=simpleDateFormat.parse(arr[0] + " " + arr[1]);
		} catch (ParseException e) {			
			e.printStackTrace();
		}	    
	}
		return convertedDate;
	}
}
