
package com.virgin.utility.service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class is a demo for JWT decoding
 * 
 * @author CrowdCare
 */
public class JWTDecoder {

    private static Logger log = LoggerFactory.getLogger(JWTDecoder.class);

    public Map<String, Object> decodeJWT( String jwt) {
        Map<String, Object> payload = null;
        try {

            // get encryption/verification keys
            WysdomKeyStore keyStoreService = new WysdomKeyStore();
            PublicKey verificationKey = keyStoreService.getVerificationPublicKey();
            PrivateKey decryptionKey = keyStoreService.getDecryptionPrivateKey();

            JwtConsumer jwtConsumer = new JwtConsumerBuilder().setRequireExpirationTime().setDecryptionKey(decryptionKey).setVerificationKey(verificationKey)
                    .build();

            JwtClaims jwtClaims = jwtConsumer.processToClaims(jwt);
            payload = jwtClaims.getClaimsMap();
            for ( Map.Entry<String, Object> entry : payload.entrySet()) {
                log.info(entry.getKey() + ": " + entry.getValue());
            }

            if (!payload.isEmpty() && !(payload == null)) {
                return payload;
            }
            log.info("payload is null");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return payload;

    }
}
