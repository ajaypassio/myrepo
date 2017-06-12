
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
 * This class and related keystore is used for JWT generation
 * 
 * @author CrowdCare
 */

public class VirginKeyStore {

    private final String KEY_STORE_TYPE            = "JCEKS";

    /**
     * constants below are sample values in production, these information should not be hard coded here, and should be stored somewhere safe
     */
    private final String KEY_STORE_FILE_VIRGIN     = "virgin_local_key_store.jceks";
    private final String KEY_STORE_PASSWORD_VIRGIN = "storepass";
    private final String KEY_ALIAS_ENC             = "rsa_enc";
    private final String KEY_ALIAS_VER             = "rsa_ver";
    private final String KEY_PASSWORD_VER          = "keypass";

    /**
     * Get public key "rsa_enc" from "virgin_local_key_store.jceks" for encryption
     * 
     * @return PublicKey for data encryption
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws CertificateException
     * @throws IOException
     */
    public PublicKey getEncryptionPublicKey() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore keyStore = getKeyStore(KEY_STORE_FILE_VIRGIN, KEY_STORE_PASSWORD_VIRGIN);
        Certificate cert = keyStore.getCertificate(KEY_ALIAS_ENC);
        if (cert == null) {
            throw new KeyStoreException("Can't find public key for encryption. Alias: " + KEY_ALIAS_ENC);
        }

        return cert.getPublicKey();
    }

    /**
     * Get private key "rsa_ver" from "virgin_local_key_store.jceks" for signing JWT
     * 
     * @return PrivateKey for signing JWT
     * @throws IOException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     */
    public PrivateKey getSigningPrivateKey() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException {
        KeyStore keyStore = getKeyStore(KEY_STORE_FILE_VIRGIN, KEY_STORE_PASSWORD_VIRGIN);
        return (PrivateKey) keyStore.getKey(KEY_ALIAS_VER, KEY_PASSWORD_VER.toCharArray());
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
