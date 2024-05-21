package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


        public class Main {

            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);



                System.out.println("Welcome to the Registration and Login page");



                boolean loggedIn = false;



                while (!loggedIn) {

                    System.out.println("Please choose an option: ");

                    System.out.println("1. Register");

                    System.out.println("2. Login");

                    System.out.println("3. Exit");



                    int option = scanner.nextInt();

                    scanner.nextLine(); // New character line



                    switch (option) {

                        case 1:

                            registerUser(scanner);

                            break;



                        case 2:

                            loggedIn = login(scanner);

                            break;



                        case 3:

                            System.out.println("Thank you for using this page!");

                            return;



                        default:

                            System.out.println("Invalid option. Please try again.");

                            break;

                    }

                }

            }



            private static void registerUser(Scanner scanner) {

                System.out.println("===== Register =====");



                System.out.print("Enter your username (5 characters long and contain an underscore): ");

                String username = scanner.nextLine();



                while (username.length() != 5 || !username.contains("_")) { //User must insert an underscore

                    System.out.print("Invalid username. Please try again: ");

                    username = scanner.nextLine();

                }



                System.out.print("Enter your password (1 capital letter, 1 number, 1 special character): ");

                String password = scanner.nextLine();



                while (!isValidPassword(password)) {

                    System.out.print("Invalid password. Please try again: ");

                    password = scanner.nextLine();

                }



                System.out.print("Enter your first name: ");

                String firstName = scanner.nextLine();



                System.out.print("Enter your last name: ");

                String lastName = scanner.nextLine();



                System.out.println("Registration successful!");



            }



            private static boolean login(Scanner scanner) {

                System.out.println("===== Login =====");



                System.out.print("Enter your username: ");

                String username = scanner.nextLine();



                System.out.print("Enter your password: ");

                String password = scanner.nextLine();



                // Check if the username and password correlate



                if (username.equals("admin") && password.equals("admin123")) {

                    System.out.println("Login successful!");

                    return true;

                } else {

                    System.out.println("Invalid username password. Please try again.");

                    return false;

                }

            }

            // If user enters wrong Password

            private static boolean isValidPassword(String password) {

                boolean hasCapital = false;

                boolean hasNumber = false;

                boolean hasSpecialChar = false;



                for (char c : password.toCharArray()) {

                    if (Character.isUpperCase(c)) {

                        hasCapital = true;

                    } else if (Character.isDigit(c)) {

                        hasNumber = true;

                    } else if (!Character.isLetterOrDigit(c)) {

                        hasSpecialChar = true;

                    }

                }



                return hasCapital && hasNumber && hasSpecialChar;


            }

        }
        class Tasks {
            public static boolean task(Scanner scanner) {

                Scanner scanner = new scanner(System.in);

                System.out.println(" Welcome to EasyKenban");

               int option = scanner.nextInt();

               scanner.nextLine();

               switch (option) {

                   case 1:

                       tasks(scanner);

                       break;

            }
        }