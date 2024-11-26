import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = "1234567890123456";
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Encrypt a file");
            System.out.println("2. Decrypt a file");
            System.out.println("Type 'q' to quit.");
            System.out.print("Your choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    System.out.print("Enter the name of the file to encrypt: ");
                    String encryptFileName = scanner.nextLine();
                    try {
                        AES_Encryption.encryptFile(encryptFileName, "ciphertext.txt", key.getBytes());
                        System.out.println("File encrypted successfully! Output: ciphertext.txt");
                    } catch (Exception e) {
                        System.out.println("Error during encryption: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Enter the name of the encrypted file to decrypt: ");
                    String encryptedFileName = scanner.nextLine();
                    System.out.print("Enter the name for the decrypted output file: ");
                    String decryptedOutputName = scanner.nextLine();
                    try {
                        AES_Encryption.decryptFile(encryptedFileName, decryptedOutputName, key.getBytes());
                        System.out.println("File decrypted successfully! Output: " + decryptedOutputName);
                    } catch (Exception e) {
                        System.out.println("Error during decryption: " + e.getMessage());
                    }
                    break;

                case "q":
                case "Q":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 'q' to quit.");
            }
        }

        scanner.close();
    }
}
