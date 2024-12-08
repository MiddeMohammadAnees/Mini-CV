import java.util.*;

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
    public static final String BLUE = "\u001B[34m";
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

                // .Setter..................................................................

                crendital.setAll(Name, Password, Phone);
                // ........................................................................

                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t" + "  Sign Up successful! You can now sign in.");
                System.out.println();
                System.out.println("");
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
                break;
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

            switch (choice) {
                case 1:
                    System.out.println(CYAN + "\t\t                  ............................Today's Date: December 08, 2024............................" + RESET);
                    System.out.println("\n");
                    // Display available flights
                    System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t               Flights that are Available are       " + RESET);
                    System.out.println();

                    System.out.println(YELLOW + "                    --------------------------------------------------------------------------------------------------------------------");
                    System.out.println("             	   |                                                                                                                 	|");
                    System.out.println("            	   |     " + BLUE + "\t\t  S.No.\t Flight No.\tFrom \t  To   \t Arrival Time \t  Departure Time    " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |                                                                                                                 	|");
                    System.out.println("            	   |     " + GREEN + " \t\t  1\t   AI101      New York \t London     06:30AM    \t     02:00AM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |                                                                                                                 	|");
                    System.out.println("            	   |     " + GREEN + " \t\t  2\t   EK202      Dubai \t Mumbai     11:45PM    \t     09:30PM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |                                                                                                                 	|");
                    System.out.println("            	   |     " + GREEN + " \t\t  3\t   SQ404      Singapore  Sydney     09:00PM    \t     05:30PM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |                                                                                                                 	|");
                    System.out.println("            	   |     " + GREEN + " \t\t  4\t   BA303      London     Paris      08:15AM   \t     06:50AM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |                                                                                                                 	|");
                    System.out.println("                   ---------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("" + RESET);
                    System.out.println();
                    break;

                case 2:
                    // Search for a flight
                    while (true) {
                        System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t" + "   Enter Source " + "\n" + RESET);
                        String src = sc.nextLine();
                        System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t" + "   Enter Destination " + "\n" + RESET);
                        String dst = sc.nextLine();

                        if (src.equalsIgnoreCase("New York") && dst.equalsIgnoreCase("London")) {
                            System.out.println(BRIGHTYELLOW+ "\t\t\t\t   ..............................Your Flight Ticket is AI101.............................." + RESET);
                            break;
                        } else if (src.equalsIgnoreCase("Dubai") && dst.equalsIgnoreCase("Mumbai")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t   ..............................Your Flight Ticket is EK202.............................." + RESET);
                            break;
                        } else if (src.equalsIgnoreCase("Singapore") && dst.equalsIgnoreCase("Sydney")) {
                            System.out.println(BRIGHTYELLOW+ "\t\t\t\t   ..............................Your Flight Ticket is SQ404.............................." + RESET);
                            break;
                        } else if (src.equalsIgnoreCase("London") && dst.equalsIgnoreCase("Paris")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t   ..............................Your Flight Ticket is BA303.............................." + RESET);
                            break;
                        } else {
                            System.out.println(RED+ "\t\t\t\t\t             Enter the flights which are present on board                      " + RESET);
                            source();
                            System.out.println("\n");
                        }
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println(RED + "Returning to the main menu..." + RESET);
                    cred(); // Call the `cred` method from `Credit` class
                    return;

                default:
                    // Handle invalid input
                    System.out.println(RED+ "\t\t\t\t\t\t             Invalid choice! Please select a valid option.");
            }
        }
    }
}


class Welcome {

    // ANSI escape codes for colors
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String Blue = "\u001B[34m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // ............................................................................................................................................
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Welcome Screen - First part at the top
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println(CYAN
                + "                    =-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-= WELCOME TO SKYHIGH AIRLINES RESERVATION SYSTEM -=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-= "
                + RESET);

        // Airplane Art shifted slightly to the right
        System.out.println("\n"); // Space before airplane art for proper alignment
        System.out.println("\t\t\t\t\t\t\t\t" + YELLOW + "          __|__");
        System.out.println("\t\t\t\t\t\t\t\t" + "  _______/     \\_______");
        System.out.println("\t\t\t\t\t\t\t\t" + CYAN + " /    o o o o o o o    \\" + RESET);
        System.out.println("\t\t\t\t\t\t\t" + "        /-----------------------\\");
        System.out.println("\t\t\t\t\t\t\t" + "        |    " + YELLOW + "SKYHIGH AIRLINES " + RESET + "  |");
        System.out.println("\t\t\t\t\t\t\t\t" + "\\_______________________/");
        System.out.println("\t\t\t\t\t\t\t\t" + Blue + "     |    |    |    |" + RESET);
        System.out.println("\t\t\t\t\t\t\t\t" + Blue + "     |    |    |    |" + RESET);
        System.out.println("\t\t\t\t\t\t\t\t" + Blue + "     |    |    |    |" + RESET);
        System.out.println("\t\t\t\t\t\t\t\t" + "    /     |    |     \\" + MAGENTA);
        System.out.println("\t\t\t\t\t\t\t\t" + "   /      |    |      \\");
        System.out.println("\t\t\t\t\t\t\t\t" + "  /_______|____|_______\\" + RESET);
        System.out.println();
        System.out.println();

        System.out.println(CYAN
                + "                    =-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-= "
                + RESET);

        Credit.cred();

        Source.source();

        /*
         * // ....................................................
         * // Reservation options menu in yellow
         * 
         * 
         * System.out.println("\n");
         * System.out.println(YELLOW +
         * "                    --------------------------------------------------------------------------------------------------------------------- "
         * );
         * System.out.
         * println("             	   |                                                                                                                 	|"
         * );
         * System.out.
         * println("             	   |                                   		   [1] List All Flights                                            	|"
         * );
         * System.out.
         * println("             	   |                                  		   [2] Search For A Flight                      		     	|"
         * );
         * System.out.
         * println("             	   |                                   		   [3] Book A Ticket                            		     	|"
         * );
         * System.out.
         * println("                   |                                  		   [4] Print A Ticket                           		     	|"
         * );
         * System.out.
         * println("             	   |                                		   [5] Cancel A Ticket                          		     	|"
         * );
         * System.out.
         * println("              	   |                                                                                   			             	|"
         * );
         * System.out.
         * println("                   ---------------------------------------------------------------------------------------------------------------------- "
         * );
         * System.out.println("");
         * System.out.println("" + RESET);
         */
    }
}
