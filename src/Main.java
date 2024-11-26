import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: \n1. EncryptFile \n2. DecryptFile \nType 'q' to quit.");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.equals("1")) {


                System.out.println("Enter a filename to encrypt:");
                String filename = scanner.nextLine();
                System.out.println("Enter the Output file name");
                String outputfile = scanner.nextLine();
                System.out.println("Enter Shift:");
                int shift = scanner.nextInt();
                scanner.nextLine();

                try {
                    AES_Encryption.EncryptUtil.EncryptFile(filename, outputfile, shift);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;


                if (input.equals("2")) {

                    System.out.println("Enter a filename to decrypt:");
                    filename = scanner.nextLine();
                    System.out.println("Enter the Output file name");
                    outputfile = scanner.nextLine();
                } else {
                    System.out.println("Invalid input, try again");

                }
            }

            scanner.close();
        }
    }
}