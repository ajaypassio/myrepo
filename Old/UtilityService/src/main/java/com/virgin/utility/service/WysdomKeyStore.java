
package com.virgin.utility.service;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

/**
 * This class and related keystore is used for JWT decoding
 * 
 * @author CrowdCare
 */
public class WysdomKeyStore {

    private final String KEY_STORE_TYPE            = "JCEKS";

    /**
     * constants below are sample values in production, these information should not be hard coded here, and should be stored somewhere safe
     */
    private final String KEY_STORE_FILE_WYSDOM     = "wysdom_local_key_store.jceks";
    private final String KEY_STORE_PASSWORD_WYSDOM = "storepass";
    private final String KEY_ALIAS_ENC             = "rsa_enc";
    private final String KEY_PASSWORD_ENC          = "keypass";
    private final String KEY_ALIAS_VER             = "rsa_ver";

    /**
     * Get private key "rsa_enc" from "wysdom_local_key_store.jceks" for decryption
     * 
     * @return PrivateKey for decryption
     * @throws IOException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     */
    public PrivateKey getDecryptionPrivateKey() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException,
            UnrecoverableKeyException {
        KeyStore keyStore = getKeyStore(KEY_STORE_FILE_WYSDOM, KEY_STORE_PASSWORD_WYSDOM);
        return (PrivateKey) keyStore.getKey(KEY_ALIAS_ENC, KEY_PASSWORD_ENC.toCharArray());
    }

    /**
     * Get public key "rsa_ver" from "wysdom_local_key_store.jceks" for JWT signature verification
     * 
     * @return PublicKey for JWT signature verification
     * @throws IOException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     */
    public PublicKey getVerificationPublicKey() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore keyStore = getKeyStore(KEY_STORE_FILE_WYSDOM, KEY_STORE_PASSWORD_WYSDOM);
        Certificate cert = keyStore.getCertificate(KEY_ALIAS_VER);
        if (cert == null) {
            throw new KeyStoreException("Can't find public key for JWT signature verification. Alias: " + KEY_ALIAS_VER);
        }

        return cert.getPublicKey();
    }

    /**
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     */
    private KeyStore getKeyStore( String fileName, String storepass) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        InputStream fileInputStream = null;
        KeyStore keyStore = null;
        try {

            fileInputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            keyStore = KeyStore.getInstance(KEY_STORE_TYPE);
            keyStore.load(fileInputStream, storepass.toCharArray());
            return keyStore;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                fileInputStream.close();
        }
        return keyStore;
    }
}