import java.util.Base64;
import java.util.Scanner;

///

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Encrypt a File");
            System.out.println("2. Decrypt a File");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter the file name to encrypt: ");
                    String inputFile = scanner.nextLine();
                    String outputFile = "ciphertext.txt";
                    byte[] key = AESUtility.generateRandomKey();
                    try {
                        AESUtility.encryptFile(inputFile, outputFile, key);
                        System.out.println("File encrypted successfully!");
                        System.out.println("Encrypted file: " + outputFile);
                        System.out.println("Encryption Key (Base64): " + Base64.getEncoder().encodeToString(key));
                    } catch (Exception e) {
                        System.out.println("Error encrypting file: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Enter the encrypted file name: ");
                    String encryptedFile = scanner.nextLine();
                    System.out.print("Enter the decryption key (Base64): ");
                    String keyInput = scanner.nextLine();
                    byte[] decryptionKey;
                    try {
                        decryptionKey = Base64.getDecoder().decode(keyInput);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid key format. Please enter a valid Base64-encoded key.");
                        break;
                    }
                    String decryptedFile = "plaintext.txt";
                    try {
                        AESUtility.decryptFile(encryptedFile, decryptedFile, decryptionKey);
                        System.out.println("File decrypted successfully!");
                        System.out.println("Decrypted file: " + decryptedFile);
                    } catch (Exception e) {
                        System.out.println("Error decrypting file: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}

