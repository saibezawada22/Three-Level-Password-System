import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Instructions for Password Formation:");
        System.out.println("1. The textual password must be at least 8 characters long.");
        System.out.println("2. It should include at least one uppercase letter, one lowercase letter, one digit, and one special character.");
        System.out.println("3. The graphical password is a choice between 'sun', 'moon', or 'star'.");
        System.out.println("4. The security question will ask for your favorite color.\n");

        System.out.println("Registration: Set Your Passwords");

        String textualPassword = setTextualPassword(scanner);

        String graphicalPassword = setGraphicalPassword(scanner);

        System.out.print("Set your favorite color (answer for the security question): ");
        String securityAnswer = scanner.nextLine();

        System.out.println("\nRegistration complete. Now proceed to login.\n");

        System.out.println("Level 1: Textual Password Authentication");
        System.out.print("Enter your textual password: ");
        String userTextualPassword = scanner.nextLine();

        if (!validateTextualPassword(userTextualPassword, textualPassword)) {
            System.out.println("Authentication failed at Level 1.");
            return;
        }
        System.out.println("Level 1 Authentication Successful.\n");

        System.out.println("Level 2: Graphical Password Authentication");
        System.out.print("Choose the graphical password (options: sun, moon, star): ");
        String userGraphicalPassword = scanner.nextLine();

        if (!validateGraphicalPassword(userGraphicalPassword, graphicalPassword)) {
            System.out.println("Authentication failed at Level 2.");
            return;
        }
        System.out.println("Level 2 Authentication Successful.\n");

        System.out.println("Level 3: Security Question Authentication");
        System.out.print("What is your favorite color? ");
        String userSecurityAnswer = scanner.nextLine();

        if (!validateSecurityAnswer(userSecurityAnswer, securityAnswer)) {
            System.out.println("Authentication failed at Level 3.");
            return;
        }
        System.out.println("Level 3 Authentication Successful.\n");

        System.out.println("All levels authenticated successfully. Access granted.");
    }

    private static String setTextualPassword(Scanner scanner) {
        String password;
        while (true) {
            System.out.print("Set your textual password: ");
            password = scanner.nextLine();
            if (isValidPassword(password)) {
                break;
            } else {
                System.out.println("Password must be at least 8 characters long, include an uppercase letter, a lowercase letter, a digit, and a special character.");
            }
        }
        return password;
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUppercase = false, hasLowercase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUppercase = true;
            else if (Character.isLowerCase(c)) hasLowercase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecialChar = true;
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    private static String setGraphicalPassword(Scanner scanner) {
        String graphicalPassword;
        while (true) {
            System.out.print("Set your graphical password (options: sun, moon, star): ");
            graphicalPassword = scanner.nextLine();
            if (graphicalPassword.equalsIgnoreCase("sun") ||
                graphicalPassword.equalsIgnoreCase("moon") ||
                graphicalPassword.equalsIgnoreCase("star")) {
                break;
            } else {
                System.out.println("Invalid choice. Please choose either 'sun', 'moon', or 'star'.");
            }
        }
        return graphicalPassword;
    }

    private static boolean validateTextualPassword(String userPassword, String correctPassword) {
        return userPassword.equals(correctPassword);
    }

    private static boolean validateGraphicalPassword(String userGraphical, String correctGraphical) {
        return userGraphical.equalsIgnoreCase(correctGraphical);
    }

    private static boolean validateSecurityAnswer(String userAnswer, String correctAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer);
    }
}
