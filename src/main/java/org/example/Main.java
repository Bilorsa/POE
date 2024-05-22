package org.example;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;



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



                return  hasCapital && hasNumber && hasSpecialChar;



            }

        }



 class AccountSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();
        ArrayList<Task> tasks = new ArrayList<>();

        // Registration
        System.out.println("Registration:");
        System.out.println(login.registerUser());

        // Login
        System.out.println("\nLogin:");
        if (login.returnLoginStatus(login.loginUser()).contains("Welcome")) {
            System.out.println("Welcome to easy kanban");

            int option;
            do {
                System.out.println("Please select an option:");
                System.out.println("1) Add tasks");
                System.out.println("2) Show report");
                System.out.println("3) Quit");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("How many tasks do you want to enter?");
                        int numberOfTasks = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        for (int i = 0; i < numberOfTasks; i++) {
                            System.out.println("Enter task details:");
                            System.out.print("Task Name: ");
                            String taskName = scanner.nextLine();
                            System.out.print("Task Description: ");
                            String taskDescription = scanner.nextLine();
                            System.out.print("Developer First Name: ");
                            String devFirstName = scanner.nextLine();
                            System.out.print("Developer Last Name: ");
                            String devLastName = scanner.nextLine();
                            System.out.print("Task Duration (hours): ");
                            int taskDuration = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            Task task = new Task(taskName, i, taskDescription, devFirstName, devLastName, taskDuration);

                            if (!task.checkTaskDescription()) {
                                System.out.println("Please enter a task description of less than 50 characters");
                            } else {
                                tasks.add(task);
                                System.out.println("Task successfully captured");
                                String[] statuses = {"To Do", "Done", "Doing"};
                                int statusIndex = JOptionPane.showOptionDialog(null, "Select Task Status", "Task Status",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, statuses, statuses[0]);
                                task.setTaskStatus(statuses[statusIndex]);
                                JOptionPane.showMessageDialog(null, task.printTaskDetails());
                            }
                        }

                        int totalHours = tasks.stream().mapToInt(Task::getTaskDuration).sum();
                        System.out.println("Total hours for all tasks: " + totalHours);
                        break;

                    case 2:
                        System.out.println("Coming soon");
                        break;

                    case 3:
                        System.out.println("Exiting the system.");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (option != 3);
        } else {
            System.out.println("Username or password incorrect, please try again.");
        }
    }
}

class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Registration method
    public String registerUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        this.username = scanner.nextLine();
        System.out.println("Enter password: ");
        this.password = scanner.nextLine();
        System.out.println("Enter first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        this.lastName = scanner.nextLine();

        // Validate username
        if (!checkUsername()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no longer than 5 characters in length.";
        }

        // Validate password
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that your password contains at least 8 characters, a capital letter, a number, and a special character.";
        }

        return "Registration successful. Welcome, " + firstName + " " + lastName + "!";
    }

    // Login method
    public boolean loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username: ");
        String enteredUsername = scanner.nextLine();
        System.out.println("Enter password: ");
        String enteredPassword = scanner.nextLine();

        // Check if entered username and password match stored credentials
        return (enteredUsername.equals(username) && enteredPassword.equals(password));
    }

    // Check if username is valid
    public boolean checkUsername() {
        return (username.length() <= 5 && username.contains("_"));
    }

    // Check if password complexity requirements are met
    public boolean checkPasswordComplexity() {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        return password.matches(regex);
    }

    // Return login status message
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome, " + firstName + " " + lastName + ". It's great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}

class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private int taskDuration;
    private String taskStatus;
    private String taskID;

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        return (taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerLastName.substring(developerLastName.length() - 3).toUpperCase());
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus +
                "\nDeveloper Details: " + developerFirstName + " " + developerLastName +
                "\nTask Number: " + taskNumber +
                "\nTask Name: " + taskName +
                "\nTask Description: " + taskDescription +
                "\nTask ID: " + taskID +
                "\nTask Duration: " + taskDuration + " hours";
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}

