package com.aryan.ecom.services;
// import javax.crypto.Cipher;
// import javax.crypto.KeyGenerator;
// import javax.crypto.SecretKey;
// import java.security.NoSuchAlgorithmException;
// import java.util.Base64;
// public class EncryptionUtil {
    
//     private static final String ALGORITHM = "AES";
//     private static SecretKey secretKey;

//     static {
//         try {
//             secretKey = generateSecretKey();
//         } catch (NoSuchAlgorithmException e) {
//             e.printStackTrace();
//             // Handle the exception appropriately
//         }
//     }

//     private static SecretKey generateSecretKey() throws NoSuchAlgorithmException {
//         KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
//         keyGenerator.init(256); // Choose the key size (128, 192, or 256)
//         return keyGenerator.generateKey();
//     }

//     public static String encrypt(String data) {
//         try {
//             Cipher cipher = Cipher.getInstance(ALGORITHM);
//             cipher.init(Cipher.ENCRYPT_MODE, secretKey);
//             byte[] encryptedData = cipher.doFinal(data.getBytes());
//             return Base64.getEncoder().encodeToString(encryptedData);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }

//     public static String decrypt(String encryptedData) {
//         try {
//             Cipher cipher = Cipher.getInstance(ALGORITHM);
//             cipher.init(Cipher.DECRYPT_MODE, secretKey);
//             byte[] decodedData = Base64.getDecoder().decode(encryptedData);
//             byte[] decryptedData = cipher.doFinal(decodedData);
//             return new String(decryptedData);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AESUtils {

    private static final String SECRET_KEY = "jkfj68"; // This should be kept secure

    // Encrypt data using AES algorithm
    public static String encrypt(String data) {
        try {
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Decrypt data using AES algorithm
    public static String decrypt(String encryptedData) {
        try {
            if (encryptedData == null || encryptedData.isEmpty()) {
                return null;
            }
            Key key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
