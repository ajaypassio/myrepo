
package com.virgin.ecommerce.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;

@Component
public class CartHelper {

    private static Logger log = LoggerFactory.getLogger(CartHelper.class);

    public JsonNode getAllProductIdFromOrder( String jsonResp) {

        JsonNode plIds = JsonPath.read(jsonResp, "$.orderItems[*].productId");
        if (plIds != null) {
            log.debug("plIds " + plIds + ", plIds string: " + plIds.toString() + ", PlIds size () " + plIds.size());
        }

        return plIds;

    }

}
