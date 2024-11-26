import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctPassword = "hola";

        while (true) {
            System.out.println("Choose an option: \n1. EncryptFile \n2. DecryptFile \nType 'q' to quit.");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.equals("1")) {

                    System.out.println("Enter password:");
                    String enteredPassword = scanner.nextLine();

                    if (enteredPassword.equals(correctPassword)) {
                        System.out.println("Password correct.");

                        System.out.println("Enter a filename to encrypt:");
                        String filename = scanner.nextLine();
                        System.out.println("Enter the Output file name");
                        String outputfile = scanner.nextLine();
                        System.out.println("Enter Shift:");
                        int shift = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            EncryptUtil.EncryptFile(filename, outputfile, shift);
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    } else {
                        System.out.println("Incorrect password. Try again.");

            }
        }

        scanner.close();
    }
}