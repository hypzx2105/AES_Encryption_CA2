
import java.io.IOException;


public class AES_Encryption {


    public static void EncryptFile(String[] args) throws IOException {
        String plainTextFileName = "plaintext.txt";
        String cypherTextFileName = "cyphertext.txt";
        String decryptedFileName = "plaintextDecrypted.txt";
        byte[] key = "1234567890".getBytes();
        encryptWith(plainTextFileName, cypherTextFileName, key);
        decryptWith(cypherTextFileName, decryptedFileName, key);
        System.out.println("File used for encryption" + plainTextFileName);
        System.out.println("Created encryptionFile" + cypherTextFileName);
        System.out.println("Created decryptionFile" + decryptedFileName);

    }


    public void AES_Cypher(String FilenamePlain, String FilenameEnc, byte[] key) throws IOException {
    }

}
