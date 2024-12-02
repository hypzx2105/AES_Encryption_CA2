import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.SecureRandom;
import java.util.Random;

public class AESUtility {


    public static byte[] generateRandomKey() {
        byte[] key = new byte[16];
        Random random = new SecureRandom();
        random.nextBytes(key);
        return key;
    }


    public static void encryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            processFile(cipher, fis, fos);
        }
    }


    public static void decryptFile(String inputFile, String outputFile, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            processFile(cipher, fis, fos);
        }
    }


    private static void processFile(Cipher cipher, InputStream input, OutputStream output) throws Exception {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            byte[] outputBytes = cipher.update(buffer, 0, bytesRead);
            if (outputBytes != null) {
                output.write(outputBytes);
            }
        }
        byte[] finalBytes = cipher.doFinal();
        if (finalBytes != null) {
            output.write(finalBytes);
        }
    }
}


                                            ///***REFERENCES***///

///https://howtodoinjava.com/java/java-security/aes-256-encryption-decryption/
///https://mkyong.com/java/java-aes-encryption-and-decryption/
///https://stackoverflow.com/questions/62883618/encryption-decryption-aes-for-all-type-of-file-in-java
