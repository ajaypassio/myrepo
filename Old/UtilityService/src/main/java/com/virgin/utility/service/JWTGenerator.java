
package com.virgin.utility.service;


import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Map;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;

/**
 * This class is a demo for JWT generating
 * 
 * @author CrowdCare
 */

public class JWTGenerator {

    private final float JWT_EXPIRATION_MINUTES = 100000;

    public String createJWT( Map<String, Object> payload) {
        String jwt = null;

        try {
            // get encryption/verification keys
            VirginKeyStore keyStoreService = new VirginKeyStore();
            PublicKey encryptionKey = keyStoreService.getEncryptionPublicKey();
            PrivateKey verificationKey = keyStoreService.getSigningPrivateKey();

            // Create the Claims, which will be the content of the JWT
            JwtClaims claims = new JwtClaims();
            claims.setExpirationTimeMinutesInTheFuture(JWT_EXPIRATION_MINUTES);
            for ( Map.Entry<String, Object> entry : payload.entrySet()) {
                claims.setClaim(entry.getKey(), entry.getValue());
            }

            // create inner signed jwt
            JsonWebSignature jws = new JsonWebSignature();
            jws.setPayload(claims.toJson());
            jws.setKey(verificationKey);
            jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA512);
            String innerJwt = jws.getCompactSerialization();

            // jwt encryption
            JsonWebEncryption jwe = new JsonWebEncryption();
            jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.RSA_OAEP_256);
            jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_256_CBC_HMAC_SHA_512);
            jwe.setKey(encryptionKey);
            jwe.setContentTypeHeaderValue("JWT");
            jwe.setPayload(innerJwt);
            jwt = jwe.getCompactSerialization();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jwt;
    }
}
