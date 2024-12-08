import java.util.Scanner;

// Class to store credentials
class Crenditals {

    private String Name;
    private String Password;
    private long Phone;

    // Constructor

    // Setter method to update all fields
    void setAll(String Name, String Password, long Phone) {
        this.Name = Name;
        this.Password = Password;
        this.Phone = Phone;
    }

    // Getter methods
    String getName() {
        return Name;
    }

    String getPassword() {
        return Password;
    }

    long getPhone() {
        return Phone;
    }

    // Validate credentials
    public boolean validate(String inputUsername, String inputPassword, long inputPhone) {
        return inputUsername.equals(Name) && inputPassword.equals(Password) && inputPhone == Phone;
    }
}

// Class to handle user operations
class Credit {

    static Scanner sc = new Scanner(System.in);

    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String Blue = "\u001B[34m";
    public static final String RED = "\u001B[91m";
    public static final String BRIGHTCYAN = "\u001B[96m";
    public static final String BRIGHTMAGENTA = "\u001B[95m";
    public static final String BRIGHTYELLOW = "\u001B[93m";

    public static void cred() {
        Scanner scanner = new Scanner(System.in);

        // Create a User object
        Crenditals crendital = new Crenditals();

        while (true) {
            // Display options
            System.out.println("\n");
            System.out.println(YELLOW
                    + "                    --------------------------------------------------------------------------------------------------------------------- ");
            System.out.println(
                    "             	   |                                                                                                                 	|");
            System.out.println(
                    "             	   |                                   		   Select an Option                                           		|");
            System.out.println(
                    "             	   |                                  		   [1] SigUp                      		     			|");
            System.out.println(
                    "             	   |                                   		   [2] SigIn                            		     		|");
            System.out.println(
                    "                   |                                  		   [3] Exit                          		     			|");
            System.out.println(
                    "                   ---------------------------------------------------------------------------------------------------------------------- ");
            System.out.println("");
            System.out.println("" + RESET);
            System.out.println();

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.println();
                // Sign Up
                System.out.println(GREEN + "\t\t\t\t\t\t\t" + "     Enter the Details to Sign Up:" + "\n" + RESET);
                System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Username " + "\n" + RESET);
                String Name = scanner.nextLine();
                System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Password " + "\n" + RESET);
                String Password = scanner.nextLine();
                System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Phone Number " + "\n" + RESET);
                long Phone = scanner.nextLong();

                // Setter
                crendital.setAll(Name, Password, Phone);

                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t" + "  Sign Up successful! You can now sign in.");
                System.out.println();
                System.out.println(YELLOW
                        + "                    --------------------------------------------------------------------------------------------------------------------- ");
                System.out.println(YELLOW + "             	   |" + BRIGHTMAGENTA + "\t\t\t\t\t\t"
                        + "  Your Account Details are" + RESET + YELLOW + "\t\t\t\t\t\t" + "|" + RESET);

                System.out.println(YELLOW
                        + "             	   |                                                                                                                 	|"
                        + RESET);
                System.out.println(YELLOW + "             	   |                          		   " + RED + ""
                        + "    	  The User Name is: " + crendital.getName() + "     " + RESET + YELLOW + "\t\t\t\t\t\t"
                        + "|" + RESET);
                System.out.println(YELLOW + "             	   |                          		           "
                        + "\t\t\t\t\t\t\t\t" + "        |" + RESET);

                System.out.println(YELLOW + "             	   |                          		   " + RED + ""
                        + "    	  The User Password is: " + crendital.getPassword() + RESET + YELLOW + "\t\t\t\t\t\t"
                        + "|" + RESET);
                System.out.println(YELLOW
                        + "             	   |                                                                                                                 	|"
                        + RESET);

                System.out.println(YELLOW + "             	   |                          		   " + RED + ""
                        + "    	  The User Phone Number is: " + crendital.getPhone() + "     " + RESET + YELLOW
                        + "\t\t\t\t\t" + "|" + RESET);
                System.out.println(YELLOW
                        + "             	   |                                                                                                                 	|"
                        + RESET);

                System.out.println(YELLOW
                        + "                    --------------------------------------------------------------------------------------------------------------------- ");
                System.out.println();
                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t" + "     'SIGNIN'" + RESET + CYAN
                        + " IF YOU HAVE ALREADY" + RESET + BRIGHTCYAN + " 'SIGNUP'" + RESET);
            } else if (choice == 2) {
                // Sign In
                if (crendital.getName() == null) {
                    System.out.println(MAGENTA + "\t\t\t\t\t\t\t" + "No account found. Please SignUp first.");
                } else {
                    System.out.println(GREEN + "\t\t\t\t\t\t\t" + "     Enter the Details to Sign Up:" + "\n" + RESET);
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Username " + "\n" + RESET);
                    String inputUsername = scanner.nextLine();
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Password " + "\n" + RESET);
                    String inputPassword = scanner.nextLine();
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Phone Number " + "\n" + RESET);
                    long inputPhone = scanner.nextLong();
                    if (crendital.validate(inputUsername, inputPassword, inputPhone)) {
                        System.out.println(BRIGHTCYAN
                                + "\t\t\t\t>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..Login successful! Welcome..<<<<<<<<<<<<<<<<<<<<<<<<<<<"
                                + "" + RESET);
                        break; // Exit the loop after successful login
                    } else {
                        System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid credentials. Please try again." + RESET);
                    }
                }
            } else if (choice == 3) {
                // Exit the application
                System.out.println(RED + "\t\t\t\t\t\t\t" + "   Exiting the application. Goodbye!" + RESET);
                return; // Exit the method and return to the main program
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid option. Please select 1, 2, or 3." + RESET);
            }
        }
    }
}

// Class Source - Destination
class Source extends Credit {

    public static void source() {
        Date date = new Date();

        while (true) {
            // Display options
            System.out.println("\n");
            System.out.println(YELLOW
                    + "                    --------------------------------------------------------------------------------------------------------------------- ");
            System.out.println(
                    "             	   |                                                                                                                 	|");
            System.out.println(
                    "             	   |                                   		   Select an Option                                           		|");
            System.out.println(
                    "             	   |                                  		   [1] List All Flights                      		     		|");
            System.out.println(
                    "             	   |                                   		   [2] Search For A Flight                            		     	|");
            System.out.println(
                    "                   |                                  		   [3] Exit                          		     			|");
            System.out.println(
                    "                   ---------------------------------------------------------------------------------------------------------------------- ");
            System.out.println("");
            System.out.println("" + RESET);

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            System.out.println();
            switch (choice) {
                case 1:
                    // List all flights
                    System.out.println(GREEN
                            + "\t\t\t\t\t\t\t" + "Displaying all available flights...");
                    // Implementation to list flights
                    break;
                case 2:
                    // Search for a flight
                    System.out.println(GREEN + "\t\t\t\t\t\t\t" + "Enter destination:");
                    String destination = sc.nextLine();
                    System.out.println(GREEN + "\t\t\t\t\t\t\t" + "Searching for flights to " + destination + "...");
                    // Implementation to search for flights
                    break;
                case 3:
                    System.out.println(RED + "\t\t\t\t\t\t\t" + "Exiting to main menu..." + RESET);
                    return; // Exit the method and return to the main menu
                default:
                    System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid option. Please select 1, 2, or 3." + RESET);
            }
        }
    }
}

// Welcome class to display welcome message and options
class Welcome extends Source {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // Display welcome message
            System.out.println(YELLOW
                    + "                    --------------------------------------------------------------------------------------------------------------------- ");
            System.out.println(
                    "             	   |                                                                                                                 	|");
            System.out.println(
                    "             	   |                                   		   Welcome to Travel Agency                                    	|");
            System.out.println(
                    "                   ---------------------------------------------------------------------------------------------------------------------- ");
            System.out.println();
            System.out.println("" + RESET);

            System.out.println("Enter your choice:");
            System.out.println("1. Credit and Source");
            System.out.println("2. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (choice == 1) {
                // Call Credit and Source options
                cred();
                source();
            } else if (choice == 2) {
                System.out.println(RED + "\t\t\t\t\t\t\t" + "Exiting the application. Goodbye!" + RESET);
                break; // Exit the main loop
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid option. Please select 1 or 2." + RESET);
            }
        }
    }
}
