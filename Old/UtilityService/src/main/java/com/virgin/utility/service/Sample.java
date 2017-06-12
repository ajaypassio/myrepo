
package com.virgin.utility.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * This class is a demo for JWT
 * 
 * @author TechM
 */

@Component
public class Sample {

    public Map<String, Object> sampleData( String gigyaId) {

        Map<String, Object> userInfo = new HashMap<String, Object>();

        userInfo.put("account_number", "virgin_fan_007");
        userInfo.put("account_balance", 77.77);
        userInfo.put("wireless_number", "1(777)777-7777");
        userInfo.put("make", "Apple");
        userInfo.put("model", "iPhone7");
        userInfo.put("os_version", "10.0");
        userInfo.put("language", "en");
        userInfo.put("max_search_results", 7);
        userInfo.put("device_id", "virgin_device_007");
        userInfo.put("gigya_id", gigyaId);

        return userInfo;
    }
}
