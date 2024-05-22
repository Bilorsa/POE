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

class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    //Allows user to insert
    public Task(String taskName, String developerDetails) {
        this.taskName = taskName;
        this.developerDetails = developerDetails;
        this.taskNumber = 0; // Initialize task number to 0
        this.taskStatus = "To Do"; // Initialize task status to "To Do"
    }

    public boolean checkTaskDescription(String description) {
        if (description.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            return false;
        }
        this.taskDescription = description;
        JOptionPane.showMessageDialog(null, "Task successfully captured");
        return true;
    }

    public String createTaskID() {
        this.taskID = (this.taskName.substring(0, 2) + ":" + this.taskNumber + ":" + this.developerDetails.substring(this.developerDetails.length() - 3)).toUpperCase();
        return this.taskID;
    }

    public String printTaskDetails() {
        return this.taskStatus + ", " + this.developerDetails + ", " + this.taskNumber + ", " + this.taskName + ", " + this.taskDescription + ", " + this.taskID + ", " + this.taskDuration;
    }

    public int returnTotalHours() {
        return this.taskDuration;
    }

    public void setTaskDuration(int duration) {
        this.taskDuration = duration;
    }

    public void setTaskStatus(String status) {
        this.taskStatus = status;
    }

    public void setTaskNumber(int number) {
        this.taskNumber = number;
    }
}

 class Task1 {
    public static void main(String[] args) {

        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add"));
        Task[] tasks = new Task[numTasks];
        int totalHours = 0;

        for (int i = 0; i < numTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details");
            tasks[i] = new Task(taskName, developerDetails);

            String description = JOptionPane.showInputDialog("Enter task description");
            while (!tasks[i].checkTaskDescription(description)) {
                description = JOptionPane.showInputDialog("Enter task description");
            }

            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration"));
            tasks[i].setTaskDuration(duration);
            totalHours += duration;

            tasks[i].setTaskNumber(i);
            tasks[i].createTaskID();
            JOptionPane.showMessageDialog(null, tasks[i].printTaskDetails());
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }
}

