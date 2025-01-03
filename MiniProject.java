import java.util.*;
import java.util.InputMismatchException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;

// Class to store credentials

class Crenditals {

    private String Name;
    private String Password;
    private long Phone;

    // Constructor

    Crenditals(String Name, String Password, long Phone) {
		this.Name=Name;
		this.Password=Password;
		this.Phone= Phone;
	}


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
    public boolean validate(String inputUsername, String inputPassword, long inputPhone, int otp) {
        return inputUsername.equals(Name) && inputPassword.equals(Password) && inputPhone == Phone;
    }

}

// Class to handle user operations
// Class to handle user operations
class Credit {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    // ANSI escape codes for colors

    public static final String PINK = "\u001B[38;5;206m"; // Custom pink

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
public static final String BRIGHTRED = "\u001B[91m";


    private static int generateOtp() {
        return 1000 + random.nextInt(9000); // Generates a 4-digit OTP
    }

    public static void cred() throws InputMismatchException {
    Scanner scanner = new Scanner(System.in);

    // Create a User object
    Crenditals crendital = new Crenditals("user", "7777", 1234567890L);

    rev: while (true) {
        // Display options
        System.out.println("\n");
        System.out.println(YELLOW
                + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
        System.out.println(
                "             	   |                                                                                                                 		|");
        System.out.println(
                "             	   |                                   		   	Select an Option                                           		|");
        System.out.println(
                "             	   |                                  		   	[1] SignUp                      		     			|");
        System.out.println(
                "             	   |                                   		   	[2] SignIn                            		     			|");
        System.out.println(
                "                   |                                  		   	[3] Exit                          		     			|");
        System.out.println(
                "                   ------------------------------------------------------------------------------------------------------------------------------ " + RESET);
        System.out.println("");
        System.out.println("" + RESET);
        System.out.println();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // Sign Up
            System.out.println(GREEN + "\t\t\t\t\t\t\t\t" + "  Enter the Details to Sign Up:" + "\n" + RESET);
            System.out.print(GREEN + "\t\t\t\t\t\t\t\t\t" + "Enter Username " + "\n" + RESET);
            String Name = scanner.nextLine();
            System.out.print(GREEN + "\t\t\t\t\t\t\t\t\t" + "Enter Password " + "\n" + RESET);
            String Password = scanner.nextLine();
            System.out.print(GREEN + "\t\t\t\t\t\t\t\t       " + "Enter Phone Number " + "\n" + RESET);

            try {
                long Phone = scanner.nextLong();

                // Validate phone number length (should be 10 digits)
                if (String.valueOf(Phone).length() != 10) {
                    System.out.println(RED + "\t\t\t\t\t\t\tInvalid Phone Number. Please try again." + RESET);
                    continue; // Go back to the start of the loop to try again
                }

                // Set details
                crendital.setAll(Name, Password, Phone);

                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t" + "      Sign Up successful! You can now sign in." + RESET);
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\t\t\t Invalid input! Please try again!");
                cred(); // Recursively call cred() to re-enter information
                break; // Exit current loop and handle invalid input
            }
        } else if (choice == 2) {
            // Sign In
            System.out.println(GREEN + "\t\t\t\t\t\t\t\t" + "    Enter the Details to Sign In:" + "\n" + RESET);
            System.out.print(GREEN + "\t\t\t\t\t\t\t\t\t" + "  Enter Username " + "\n" + RESET);
            String inputUsername = scanner.nextLine();
            System.out.print(GREEN + "\t\t\t\t\t\t\t\t\t" + "  Enter Password " + "\n" + RESET);
            String inputPassword = scanner.nextLine();
            System.out.print(GREEN + "\t\t\t\t\t\t\t\t\t" + "Enter Phone Number " + "\n" + RESET);

            try {
                long inputPhone = scanner.nextLong();

                // Validate phone number length (should be 10 digits)
                if (String.valueOf(inputPhone).length() != 10) {
                    System.out.println(RED + "\t\t\t\t\t\t\t\tPhone number should contain exactly 10 digits. Please try again." + RESET);
                    continue; // Go back to the start of the loop to try again
                }

                // Validate credentials
                if (crendital.getName().equals(inputUsername) && crendital.getPassword().equals(inputPassword)
                        && crendital.getPhone() == inputPhone) {

                    // Generate OTP for sign-in
                    int generatedOtp = generateOtp();
                    System.out.println(RED + "\t\t\t\t\t\t\t\tGenerated OTP (Do not share): " + RESET + BRIGHTCYAN + generatedOtp + RESET);
                    System.out.println();
                    System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t" + "   Enter OTP " + "\n" + RESET);
                    int enteredOtp = scanner.nextInt();

                    if (enteredOtp == generatedOtp) {
                        System.out.println(BRIGHTCYAN
                                + "\t\t\t\t  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..Login successful! Welcome..<<<<<<<<<<<<<<<<<<<<<<<<<<<" + "" + RESET);
                        break rev; // Exit loop on successful login
                    } else {
                        System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid OTP. Please try again." + RESET);
                    }
                } else {
                    System.out.println(RED + "\t\t\t\t\t\t\t\t" + "Invalid credentials. Please try again!" + RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println("\t\t\t\t\t\t\t\t Invalid input! Please try again");
                cred(); // Clear invalid input from the scanner
            }
        } else if (choice == 3) {
            System.out.print(RED + "\t\t\t\t\t\t\t\t" + "Exiting the application" + RESET);
            for (int i = 5; i >= 0; i--) {
                System.out.print(RED + "." + RESET);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            System.out.println("\n");
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t" + "Thank you for using the Application. Goodbye!" + RESET);
            System.out.println();
            System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t" + "           Visit Again" + RESET);

            System.exit(0);
        } else {
            System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid option. Please select 1, 2, or 3." + RESET);
        }
    }
}

}


// Class Source - Destination


class Source extends Credit {

    private static String src;  // Static variables for shared access
    private static String dst;
    private static String date1;

    static String selectedSeat = null;

    // Getter methods for accessing variables
    public static String getSrc() {
        return src;
    }

    public static String getDst() {
        return dst;
    }

    public static String getDate1() {
        return date1;
    }

    // Scanner instance for user input
    static Scanner sc = new Scanner(System.in);

	static String a1 = "AI101";
	static String a2 = "EK202";
	static String a3 = "SQ404";
	static String a4 = "BA303";
 
    public static void source() {
        Date date = new Date();

        while (true) {
            System.out.println("\n");

            System.out.println(YELLOW
                    + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
            System.out.println(
                    "             	   |                                                                                                                 		|");
            System.out.println(
                    "             	   |                                   		   	Select an Option                                           		|");
            System.out.println(
                    "             	   |                                  		   	[1] List All Flights                      		     		|");
            System.out.println(
                    "             	   |                                   		   	[2] Search For A Flight                            		     	|");
            System.out.println(
                    "                   |                                  		   	[3] Exit                          		     			|");
            System.out.println(
                    "                    ----------------------------------------------------------------------------------------------------------------------------- "+RESET);
            System.out.println("");

            System.out.print("Enter your choice: ");
	
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println(CYAN + "\t\t              ............................Current's Date & Time: " + date + "............................" + RESET);
                    System.out.println("\n");
                    // Display available flights
                    System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t    Flights that are Available are       " + RESET);
                    System.out.println();

                    System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("             	   |\t                                                                                                                 	|");
                    System.out.println("            	   |\t     " + BLUE + "\t\t      S.No.\t Flight No.\tFrom \t  To   \t Arrival Time \t  Departure Time    " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |\t                                                                                                                 	|");

                    System.out.println("            	   |\t     " + GREEN + " \t\t        1\t   "+a1+"      New York \t London     06:30AM    \t     02:00AM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |\t                                                                                                                 	|");

                    System.out.println("            	   |\t     " + GREEN + " \t\t        2\t   "+a2+"      Dubai \t Mumbai     11:45PM    \t     09:30PM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |\t                                                                                                                 	|");

                    System.out.println("            	   |\t     " + GREEN + " \t\t        3\t   "+a3+"      Singapore  Sydney     09:00PM    \t     05:30PM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |\t                                                                                                                 	|");

                    System.out.println("            	   |\t     " + GREEN + " \t\t        4\t   "+a4+"      London     Paris      08:15AM   \t     06:50AM       " + RESET + YELLOW + " 	                |");
                    System.out.println("             	   |\t                                                                                                                 	|");

                    System.out.println("                    ----------------------------------------------------------------------------------------------------------------------------- "+ RESET);
                    System.out.println("");
                    break;

                case 2:
                    // Search for a flight
                    while (true) {
                        System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t" + "\t   Enter Source " + "\n" + RESET);
                        src = sc.nextLine();
                        System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t" + "\t   Enter Destination " + "\n" + RESET);
                        dst = sc.nextLine();
                        System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t" + "\tEnter Date (yyyy-MM-dd): " + "\n" + RESET);
			System.out.println();

                        String inputDate = sc.nextLine();
                        if (!isValidFutureDate(inputDate)) {
                            System.out.println(RED + "\t\t\t\t\t\t             Invalid date! Please enter today or a future date." + RESET);
			System.out.println();
                            continue;
                        }

                        date1 = inputDate;

                        if (src.equalsIgnoreCase("New York") && dst.equalsIgnoreCase("London")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t   ..............................Your Flight Number is AI101.............................." + RESET);
                            Choose.choose();
                            break;
                        } else if (src.equalsIgnoreCase("Dubai") && dst.equalsIgnoreCase("Mumbai")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t   ..............................Your Flight Number is EK202.............................." + RESET);
                            Choose.choose();
                            break;
                        } else if (src.equalsIgnoreCase("Singapore") && dst.equalsIgnoreCase("Sydney")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t   ..............................Your Flight Number is SQ404.............................." + RESET);
                            Choose.choose();
                            break;
                        } else if (src.equalsIgnoreCase("London") && dst.equalsIgnoreCase("Paris")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t   ..............................Your Flight Number is BA303.............................." + RESET);
                            Choose.choose();
                            break;
                        } else {
                            System.out.println(RED + "\t\t\t\t\t\t             Enter the flights which are present on board                      " + RESET);
                            source();
                            break;
                        }
                    }
                    break;

                case 3:
                    // Exit the program
                    System.out.println(RED + "Returning to the main menu..." + RESET);
                    cred(); // Call the `cred` method from `Credit` class
                    System.exit(0);
                    break;

                default:
                    // Handle invalid input
                    System.out.println(RED + "\t\t\t\t\t\t             Invalid choice! Please select a valid option.");
                    break;
            }
        }
    }

    // Helper method to validate the date
    private static boolean isValidFutureDate(String inputDate) {
        try {
            LocalDate enteredDate = LocalDate.parse(inputDate);
            LocalDate today = LocalDate.now();
            return !enteredDate.isBefore(today);
        } catch (DateTimeParseException e) {
            return false; // Invalid format
        }
    }
}


// Economy class extending Source

class EconomyClass extends Source {

// Additional ANSI escape codes for colors
public static final String BRIGHTRED = "\u001B[91m";
public static final String BRIGHTGREEN = "\u001B[92m";
public static final String BRIGHTBLUE = "\u001B[94m";
public static final String BRIGHTWHITE = "\u001B[97m";
public static final String DARKGRAY = "\u001B[90m";
public static final String LIGHTGRAY = "\u001B[37m";
public static final String BRIGHTBLACK = "\u001B[90m"; // Same as dark gray
public static final String ORANGE = "\u001B[38;5;208m"; // Custom orange
public static final String PURPLE = "\u001B[38;5;93m"; // Custom purple
public static final String PINK = "\u001B[38;5;206m"; // Custom pink
public static final String TEAL = "\u001B[38;5;45m"; // Custom teal

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

    // Actual seat costs
     static final int COST_A1 = 20;   // A1: Window seat
     static final int COST_A2 = 15;   // A2: Middle seat
     static final int COST_A3 = 12;   // A3: Middle seat
     static final int COST_A4 = 20;   // A4: Window seat

public static String selectedSeat;

public static void displayEconomyFeatures() {
     System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "    Economy Class" + RESET);
     System.out.println();

    System.out.println(YELLOW + "                    -----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTYELLOW + "\t         Seat Number\t    \t    \t    Type \t\t\t AV/NA   \t\t      Cost " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                  	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    
    // Series B
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                  	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    
    // Series C
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                  	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    
   System.out.println(YELLOW + "                    -----------------------------------------------------------------------------------------------------------------------------"+ RESET);

	while(true){
			System.out.println();
                	System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t" + "\t  Enter the Seat Number" + RESET);
			String seat = sc.next();
		
		if(seat.equals("A1") ||seat.equals("A1") ||seat.equals("A4") ||seat.equals("B1") ||seat.equals("B4") ||seat.equals("C1") ||seat.equals("C4") ){
			selectedSeat = seat;
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t   " + seat + " is a Window Seat"+ RESET);
			System.out.println();
	
			System.out.println();
			break;
		}

		else if(seat.equals("A2") ||seat.equals("B2") ||seat.equals("C2") ){
                		System.out.println(RED + "\t\t\t\t\t\t\t\t    " + "Sorry! Entered Seat is Not Available " + RESET);

				System.out.println();
                		System.out.println(GREEN + "\t\t\t\t\t\t\t\t    " + " Choose the seat which is Available " + RESET);
			System.out.println();

		}

		else if(seat.equals("A3") ||seat.equals("B3") ||seat.equals("C3") ){
     			System.out.println(BRIGHTYELLOW +  "\t\t\t\t\t\t\t\t\t   " + seat + " is a Window Seat"+ RESET);
			selectedSeat = seat;
			System.out.println();
			System.out.println();
				break;
		}
		else{

                	System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "    Enter Valid Choice!" + RESET);
			System.out.println();

		}
	}
			
  }
}




// Premium class extending Source

class PremiumClass extends Source {

    // ANSI escape codes for colors

    // Additional ANSI escape codes for colors
    public static final String BRIGHTRED = "\u001B[91m";
    public static final String BRIGHTGREEN = "\u001B[92m";
    public static final String BRIGHTBLUE = "\u001B[94m";
    public static final String BRIGHTWHITE = "\u001B[97m";
    public static final String DARKGRAY = "\u001B[90m";
    public static final String LIGHTGRAY = "\u001B[37m";
    public static final String BRIGHTBLACK = "\u001B[90m"; // Same as dark gray
    public static final String ORANGE = "\u001B[38;5;208m"; // Custom orange
    public static final String PURPLE = "\u001B[38;5;93m"; // Custom purple
    public static final String PINK = "\u001B[38;5;206m"; // Custom pink
    public static final String TEAL = "\u001B[38;5;45m"; // Custom teal

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

    // Actual seat costs
     static final int COST_A1 = 20;   // A1: Window seat
     static final int COST_A2 = 15;   // A2: Middle seat
     static final int COST_A3 = 12;   // A3: Middle seat
     static final int COST_A4 = 20;   // A4: Window seat

public static String selectedSeat;

public static void displayPremiumFeatures() {
     System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "    Premium Class" + RESET);
     System.out.println();

   System.out.println(YELLOW + "                    -----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTYELLOW + "\t         Seat Number\t    \t    \t    Type \t\t\t AV/NA   \t\t      Cost " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                  	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    
    // Series B
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                  	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    
    // Series C
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                  	        |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "             |");
    System.out.println("             	   |                                                                                                                 	        |");
    
   System.out.println(YELLOW + "                    -----------------------------------------------------------------------------------------------------------------------------"+ RESET);

	while(true){
			System.out.println();
                	System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t" + "\t  Enter the Seat Number" + RESET);
		String seat = sc.next();
		
		if(seat.equals("A1") ||seat.equals("A1") ||seat.equals("A4") ||seat.equals("B1") ||seat.equals("B4") ||seat.equals("C1") ||seat.equals("C4") ){
    			System.out.println(BRIGHTYELLOW +  "\t\t\t\t\t\t\t\t\t   " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			selectedSeat = seat;
			System.out.println();
				break;
		}

		else if(seat.equals("A2") ||seat.equals("B2") ||seat.equals("C2") ){
                		System.out.println(RED + "\t\t\t\t\t\t\t\t    " + "Sorry! Entered Seat is Not Available " + RESET);
				System.out.println();
                		System.out.println(GREEN + "\t\t\t\t\t\t\t\t    " + " Choose the seat which is Available " + RESET);
			System.out.println();
			System.out.println();

		}

		else if(seat.equals("A3") ||seat.equals("B3") ||seat.equals("C3") ){
    			System.out.println(BRIGHTYELLOW +  "\t\t\t\t\t\t\t\t\t   " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			selectedSeat = seat;

			System.out.println();
				break;
		}
		else{

                	System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "   Enter Valid Choice!" + RESET);
			System.out.println();

		
		}
	}

  }
}



// Business class extending Source

class BusinessClass extends Source {

// Additional ANSI escape codes for colors
public static final String BRIGHTRED = "\u001B[91m";
public static final String BRIGHTGREEN = "\u001B[92m";
public static final String BRIGHTBLUE = "\u001B[94m";
public static final String BRIGHTWHITE = "\u001B[97m";
public static final String DARKGRAY = "\u001B[90m";
public static final String LIGHTGRAY = "\u001B[37m";
public static final String BRIGHTBLACK = "\u001B[90m"; // Same as dark gray
public static final String ORANGE = "\u001B[38;5;208m"; // Custom orange
public static final String PURPLE = "\u001B[38;5;93m"; // Custom purple
public static final String PINK = "\u001B[38;5;206m"; // Custom pink
public static final String TEAL = "\u001B[38;5;45m"; // Custom teal

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

    // Actual seat costs
     static final int COST_A1 = 20;   // A1: Window seat
     static final int COST_A2 = 15;   // A2: Middle seat
     static final int COST_A3 = 12;   // A3: Middle seat
     static final int COST_A4 = 20;   // A4: Window seat

public static String selectedSeat;


public static void displayBusinessFeatures() {
     System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "    Bussiness Class" + RESET);
     System.out.println();
    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTYELLOW + "\t         Seat Number\t    \t    \t    Type \t\t\t AV/NA   \t\t      Cost " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A2\t    \t    \t \t   Middle  \t\t\t  AV  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    // Series B
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B2\t    \t    \t \t   Middle  \t\t\t  AV  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    // Series C
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C2\t    \t    \t \t   Middle  \t\t\t  AV  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+ RESET);

	while(true){
			System.out.println();
                	System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Enter the Seat Number" + RESET);
		String seat = sc.next();
		
		if (seat.equals("A1") || seat.equals("A4") || seat.equals("B1") || seat.equals("B4") || seat.equals("C1") || seat.equals("C4")) {
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			selectedSeat = seat;

			System.out.println();
			break;
		} else if (seat.equals("A2") || seat.equals("B2") || seat.equals("C2")) {
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			selectedSeat = seat;

			System.out.println();
			break;
		} else if (seat.equals("A3") || seat.equals("B3") || seat.equals("C3")) {
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			selectedSeat = seat;

			System.out.println();
			 break;
		} else {
			
    			System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "Enter a valid choice!" + RESET);
			System.out.println();

		}

	}
     }
}


class Choose{

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
	public static void choose() throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
		System.out.println();
                System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
		
		System.out.println("             	   |                                                                                                                 	        |");
                    
		System.out.println("            	   |   " + BLUE + "          S.No.\t   Feature \t    Economy Class \t Premium Economy Class   \t Business Class   " + RESET + YELLOW + "\t        |");
		System.out.println("             	   |                                                                                                                 	        |");
		System.out.println("            	   |     " + GREEN + "          1\tSeating Comfort     Standard seats\t      Wider seats    \t\t recliners seats " + RESET + YELLOW + "\t        |");
		System.out.println("             	   |                                                                                                                 	        |");

		System.out.println("            	   |     " + GREEN + "          2\tMeal Options  \t    Basic meals\t\t    Upgraded meals        \t Gourmet meals\t" + RESET + YELLOW + "\t        |");

		System.out.println("             	   |                                                                                                                 	        |");

		System.out.println("            	   |     " + GREEN + "          3\tAmenities \t      Basic\t\t\tUpgraded   \t\t    Opulent \t" + RESET + YELLOW + "\t        |");
		System.out.println("             	   |                                                                                                                 	        |");
		System.out.println("            	   |     " + GREEN + "          4\tCost  \t\t     Low\t      \t     Medium - High    \t\t    Highest \t   " + RESET + YELLOW + "\t        |");

		System.out.println("             	   |                                                                                                                 	        |");
                System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
               System.out.println("");
                System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");

		 System.out.println("             	   |                                                                                                                          	|");
		System.out.println("            	   |   " + BRIGHTCYAN + "\t      1.Economy Class \t           2. Premium Economy Class    \t\t3. Business Class         \t4.Exit" + RESET + YELLOW +"        	|");
		 System.out.println("             	   |                                                                                                                          	|");
                System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- "+ RESET);

		System.out.println();
		
//.............................................
	Upgrade food = new EcoFood();

	Upgrade Pfood = new PreFood();

	Upgrade Bfood = new BussFood();
//.............................................


while (true) {
        System.out.println("Enter your Choice: ");
        try {
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    EconomyClass.displayEconomyFeatures();
                    new EcoFood().displayFeatures();
                    break;
                case 2:
                    PremiumClass.displayPremiumFeatures();
                    new PreFood().displayFeatures();
                    break;
                case 3:
                    BusinessClass.displayBusinessFeatures();
                    new BussFood().displayFeatures();
                    break;
                case 4:
                    Credit.cred();
                    return; // Exit the method
                default:
                    System.out.println(RED + "\t\t\t\t\t\t\t" + "Enter a Valid Choice!" + RESET);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            sc.nextLine(); // Clear invalid input from the scanner
        }
break;
    }

}

}
abstract class Upgrade {
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

    public abstract void displayFeatures();


}


class EcoFood extends Upgrade {

    @Override
    public void displayFeatures() {

        Scanner sc = new Scanner(System.in);
        System.out.println(RED + "\t\t\t\t\t\t\t" + "      1.Flex Plus          2. Saver          3.Exit" + RESET);
        System.out.println();

        // Label for outer loop
        rev: while (true) {
            try {
                System.out.println("Enter your choice:");
                int choice = sc.nextInt();

                if (choice == 1) {
                    // Adding food and snacks options
                    while (true) {
                        // Display food/snack options
                        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Choose Food/Snack Option" + RESET);
                        System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println("                   |\t\t            	      " + BRIGHTYELLOW + "\tFood/Snack \t           Quantity                 Price " + RESET + YELLOW + "                \t        |");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t1.Sandwich \t               1                      $5 " + RESET + YELLOW + "                \t        |");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t2.Chips \t               1                      $2 " + RESET + YELLOW + "                \t        |");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t3.Soft Drink \t               1                      $3 " + RESET + YELLOW + "                \t        |");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t4.Water Bottle \t               1                      $1 " + RESET + YELLOW + "                \t        |");
                        System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
                        System.out.println();
                        System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- ");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println("            	   |" + RESET + RED + "\t\t\t   					5.Exit" + RESET + YELLOW + "\t\t\t\t\t\t\t        |");
                        System.out.println("             	   |                                                                                                                            |");
                        System.out.println(YELLOW + "                    ----------------------------------------------------------------------------------------------------------------------------- " + RESET);
                        System.out.println();
                        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Select Food/Snack Option" + RESET);

                        int foodChoice = sc.nextInt();

                        switch (foodChoice) {
                            case 1:
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Sandwich" + RESET);
                                System.out.println();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity" + RESET);
                                int qty = sc.nextInt();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: " + qty + RESET);
                                System.out.println();
                                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t  " + "The Price for " + qty + " Sandwich Quantity is: " + "$" + (qty * 5) + RESET);
                                System.out.println("\n");
                                System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm" + RESET);
                                int n1 = sc.nextInt();
                                if (n1 == 1) {
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else if (n1 == 3) {
                                    BillGenerator.billgenerator();
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else {
                                    displayFeatures();
                                }
                                break;

                            case 2:
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Chips" + RESET);
                                System.out.println();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity" + RESET);
                                int qty1 = sc.nextInt();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: " + qty1 + RESET);
                                System.out.println();
                                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t  " + "The Price for " + qty1 + " Chips Quantity is: " + "$" + (qty1 * 2) + RESET);
                                System.out.println("\n");
                                System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm" + RESET);
                                int n2 = sc.nextInt();
                                if (n2 == 1) {
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else if (n2 == 3) {
                                    BillGenerator.billgenerator();
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else {
                                    displayFeatures();
                                }
                                break;

                            case 3:
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Soft Drink" + RESET);
                                System.out.println();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity" + RESET);
                                int qty2 = sc.nextInt();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: " + qty2 + RESET);
                                System.out.println();
                                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t  " + "The Price for " + qty2 + " Soft Drink Quantity is: " + "$" + (qty2 * 3) + RESET);
                                System.out.println("\n");
                                System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm" + RESET);
                                int n3 = sc.nextInt();
                                if (n3 == 1) {
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else if (n3 == 3) {
                                    BillGenerator.billgenerator();
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else {
                                    displayFeatures();
                                }
                                break;

                            case 4:
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle" + RESET);
                                System.out.println();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity" + RESET);
                                int qty3 = sc.nextInt();
                                System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: " + qty3 + RESET);
                                System.out.println();
                                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t  " + "The Price for " + qty3 + " Water Bottle Quantity is: " + "$" + (qty3 * 1) + RESET);
                                System.out.println("\n");
                                System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm" + RESET);
                                int n4 = sc.nextInt();
                                if (n4 == 1) {
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else if (n4 == 3) {
                                    BillGenerator.billgenerator();
                                    User.Pri_Det();
                                    Pass passManager = new Pass();
                                    passManager.managePassengers();
                                    break rev;
                                } else {
                                    displayFeatures();
                                }
                                break;

                            default:
                                System.out.println(RED + "Returning to the main menu..." + RESET);
                                Credit.cred();
                                break rev;
                        }

                    }
                }

                if (choice == 5) {
                    break rev;
                } else if (choice == 2) {
                    User.Pri_Det();
                    Pass passManager = new Pass();
                    passManager.managePassengers();
                    break rev;
                } else {
                    System.out.println(RED + "Returning to the main menu..." + RESET);
                    Credit.cred();
                    break rev;
                }

            } catch (Exception e) {
                System.out.println("\t\t\t\t\t\t\t\t Invalid input! Please try again!");
                System.out.println();
                displayFeatures();
                break rev;
            }
        }
    }
}


class PreFood extends Upgrade {

    @Override
    public void displayFeatures() {
	Scanner sc = new Scanner(System.in);
         System.out.println(RED + "\t\t\t\t\t\t\t" + "      1.Flex Plus          2. Saver          3.Exit" + RESET);
	System.out.println();



rev:while(true){
	try{
	System.out.println("Enter your choice:");
	int choice=sc.nextInt();

	if(choice==1){
while(true){
        // Adding food and snacks options
        System.out.println(BRIGHTMAGENTA +"\t\t\t\t\t\t\t\t\t" + "Select Food/Snack Option" + RESET);

	System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");

	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTYELLOW + "\tFood/Snack \t           Quantity   \t\t Price " + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |                             " + BRIGHTCYAN + "\t1.Gourmet Sandwich \t      1   \t\t  $5 "+RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t2.Fruit Platter \t      1   \t\t  $2" + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t3.Premium Soft Drink  \t      1   \t\t  $3" + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t4.Water Bottle                1   \t\t  $1" + RESET + YELLOW +"                \t\t      |");

        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);

	System.out.println();
        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
		 System.out.println("             	   |                                                                                                                          |");
		System.out.println("            	   |"+RESET+RED+"\t\t\t   					5.Exit" + RESET + YELLOW +"\t\t\t\t\t\t\t      |");
		 System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);
		System.out.println();
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t"  + "Select Food/Snack Option" + RESET);

        int foodChoice = sc.nextInt();
	
        switch (foodChoice) {
            case 1:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Gourmet Sandwich "+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);

	int qty=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty+" Gourmet Sandwich Quantity is: "+"$"+(qty*5)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n1=sc.nextInt();
		if(n1==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n1==3){
		BillGenerator.billgenerator();
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        break ;

            case 2:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Fruit Platter"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);

	int qty1=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty1+ RESET);
	System.out.println(); 
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty1+" Fruit Platter Quantity is: "+"$"+(qty1*2)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n2=sc.nextInt();
		if(n2==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n2==3){
		BillGenerator.billgenerator();
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        break ;

            case 3:
        System.out.println(BRIGHTCYAN +  "\t\t\t\t\t\t\t\t\t" + "You have selected Premium Soft Drink"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);
	int qty2=sc.nextInt();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty2+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty2+" Premium Soft Drink Quantity is: "+"$"+(qty2*3)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n3=sc.nextInt();
		if(n3==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n3==3){
		BillGenerator.billgenerator();
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        break ;

            case 4:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);

	int qty3=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty3+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty3+" Water Bottle Quantity is: "+"$"+(qty3*1)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);

		int n4=sc.nextInt();
		if(n4==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n4==3){
		BillGenerator.billgenerator();
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        break ;
            default:
                    System.out.println(RED + "Returning to the main menu..." + RESET);
			Credit.cred();
		break rev;
        }


	}

	}
	
	if(choice==5) break rev;

	else if(choice ==2){
		User.Pri_Det();
			Pass passManager = new Pass();
        		passManager.managePassengers();
		break rev;
	}
	else {
                    System.out.println(RED + "Returning to the main menu..." + RESET);
			Credit.cred();
			break rev;
	}
	}
	       	catch(Exception e){
		 System.out.println("\t\t\t\t\t\t\t\t Invalid input! Please  try again!");
		System.out.println();
		displayFeatures();
		break rev;
	}

	}

        // Seat selection

    }
}



class BussFood extends Upgrade {

    @Override
    public void displayFeatures() {
	Scanner sc = new Scanner(System.in);
         System.out.println(RED + "\t\t\t\t\t\t\t" + "      1.Flex Plus          2. Saver          3.Exit" + RESET);
	System.out.println();



rev:while(true){
try{
	System.out.println("Enter your choice:");
	int choice=sc.nextInt();

	if(choice==1){
while(true){
        // Adding food and snacks options
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Choose Food/Snack Option" + RESET);

	System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");

	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTYELLOW + "\tFood/Snack \t           Quantity   \t\t Price " + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |                             " + BRIGHTCYAN + "\t1.Gourmet Sandwich \t      1   \t\t  $5 "+RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t2.Pasta \t\t      1   \t\t  $2" + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t3.Salad  \t \t      1   \t\t  $3" + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t4.Water Bottle                1   \t\t  $1" + RESET + YELLOW +"                \t\t      |");

        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);

	System.out.println();
        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
		 System.out.println("             	   |                                                                                                                          |"+RESET);
		System.out.println("            	   |"+RESET+RED+"\t\t\t\t\t   			5.Exit" + RESET + YELLOW +"\t\t\t\t\t\t\t      |");
		 System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);
		System.out.println();
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Select Food/Snack Option" + RESET);

        int foodChoice = sc.nextInt();
	
        switch (foodChoice) {
            case 1:
        System.out.println(BRIGHTCYAN +  "\t\t\t\t\t\t\t\t\t" + "You have selected Gourmet Sandwich"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);

	int qty=sc.nextInt();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty+" Gourmet Sandwich Quantity is: "+"$"+(qty*5)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n1=sc.nextInt();
		if(n1==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n1==3){
		BillGenerator.billgenerator();
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        	break ;
            case 2:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Pasta"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);

	int qty1=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty1+ RESET);
	System.out.println(); 
        System.out.println(BRIGHTYELLOW+ "\t\t\t\t\t\t\t\t  " + "The Price for "+qty1+" Pasta Quantity is: "+"$"+(qty1*2)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);

		int n2=sc.nextInt();
		if(n2==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n2==3){
		BillGenerator.billgenerator();
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        break ;

            case 3:
        System.out.println(BRIGHTCYAN +  "\t\t\t\t\t\t\t\t\t" + "You have selected Salad"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);
	int qty2=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty2+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty2+" Salad Quantity is: "+"$"+(qty2*3)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);


		int n3=sc.nextInt();
		if(n3==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n3==3){

		BillGenerator.billgenerator();

		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        break ;

            case 4:
        System.out.println(BRIGHTCYAN +  "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "   Enter the Quantity"+ RESET);

	int qty3=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "  Entered Quantity is: "+qty3+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t  " + "The Price for "+qty3+" Water Bottle Quantity is: "+"$"+(qty3*1)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t1.Continue        2.Another Snack        3.Confirm"+ RESET);

		int n4=sc.nextInt();
		if(n4==1){
		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else if(n4==3){
		BillGenerator.billgenerator();

		User.Pri_Det();
		Pass passManager = new Pass();
        	passManager.managePassengers();
		break rev;
		}
		else
		displayFeatures();

        	break ;
            default:
                    System.out.println(RED + "Returning to the Snack menu..." + RESET);
		break;
        }



	}

	}
	
	if(choice==5) break rev;

	else if(choice ==2){
		User.Pri_Det();
			Pass passManager = new Pass();
        		passManager.managePassengers();
		break rev;
	}
	else {
                    System.out.println(RED + "Returning to the main menu..." + RESET);

			Credit.cred();
			break rev;
	}

	}
	       	catch(Exception e){
		 System.out.println("\t\t\t\t\t\t\t\t Invalid input! Please  try again!");
		System.out.println();
		displayFeatures();
		break rev;
	}
	}
	

    }
}


class BillGenerator {

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

    public static double totalAmount = 0;

    public static void billgenerator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\tFor Confirmation Please Fill Up the Details" + RESET);
        System.out.println();

        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\tEnter the Number of Items" + RESET);
        int itemCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] itemNames = new String[itemCount];
        double[] itemPrices = new double[itemCount];
        int[] itemQuantities = new int[itemCount];

        for (int i = 0; i < itemCount; i++) {
            boolean validItem = false;
            while (!validItem) {
                System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\tEnter the Name of item " + "\n" + (i + 1) + ": " + RESET);
                String itemName = scanner.nextLine();

                if (itemName.equalsIgnoreCase("Sandwich") || itemName.equalsIgnoreCase("Gourmet Sandwich")) {
                    itemPrices[i] = 5.0;
                    validItem = true;
                } else if (itemName.equalsIgnoreCase("Chips") || itemName.equalsIgnoreCase("Fruit Platter") || itemName.equalsIgnoreCase("Pasta")) {
                    itemPrices[i] = 2.0;
                    validItem = true;
                } else if (itemName.equalsIgnoreCase("Soft Drink") || itemName.equalsIgnoreCase("Premium Soft Drink") || itemName.equalsIgnoreCase("Salad")) {
                    itemPrices[i] = 3.0;
                    validItem = true;
                } else if (itemName.equalsIgnoreCase("Water Bottle")) {
                    itemPrices[i] = 3.0;
                    validItem = true;
                } else {
			System.out.println();

                    System.out.println(RED + "\t\t\t\t\t\t\t\t     Invalid item name. Please re-enter." + RESET);
			System.out.println();
                }

                if (validItem) {
                    itemNames[i] = itemName;
                }
            }

            System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t      Enter the quantity of " + itemNames[i] + "\n: " + RESET);
            itemQuantities[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        // Display Bill Summary
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t    ------------------Bill Summary------------------ " + RESET);
        System.out.println();
        for (int i = 0; i < itemCount; i++) {
            double itemTotal = itemPrices[i] * itemQuantities[i];
            totalAmount += itemTotal;

            System.out.printf(CYAN + "\t\t\t\t\t\t\t\t%-20s %d x %.2f = %.2f\n" + RESET,
                    itemNames[i], itemQuantities[i], itemPrices[i], itemTotal);
            System.out.println();
        }
        System.out.println();
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t------------------------------------------------------" + RESET);
        System.out.println();
        System.out.printf(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t  Total Amount: $%.2f\n" + RESET, totalAmount);
        System.out.println();
        System.out.println(MAGENTA + "\t\t\t\t\t\t\t------------------------------------------------------" + RESET);
        System.out.println();
    }
}



//..............Primary Contact Details...........

abstract class Primary_Details {

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

    static Scanner sc = new Scanner(System.in);

    // Utility methods for validations
    boolean isMobileNumberValid(String mobileNumber) {
        return mobileNumber.length() == 10 &&
                (mobileNumber.startsWith("9") ||
                        mobileNumber.startsWith("8") ||
                        mobileNumber.startsWith("7") ||
                        mobileNumber.startsWith("6"));
    }

    boolean mail(String email) {
        if (email.toLowerCase().endsWith("@gmail.com")) {
            return true;
        } else {
            System.out.println(RED + "\t\t\t\t\t\t\tInvalid email! Email should be in this format: your.email@gmail.com" + RESET);
            return false;
        }
    }

    // OTP generation and validation
    int generateOtp() {
        int min = 1000;
        int max = 9999;
        Random rand = new Random();
        int randomOtp = rand.nextInt(max - min + 1) + min;
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\tGenerated OTP" + RED + " (Do not share): " + RESET + BRIGHTYELLOW + randomOtp + RESET);
	System.out.println();
        return randomOtp;
    }

    boolean validateOtp(int generatedOtp) {
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t        Enter the OTP: " + RESET);
        int enteredOtp = sc.nextInt();
        if (enteredOtp == generatedOtp) {
            System.out.println(CYAN + "\t\t\t\t\t\t\t\t\t  OTP Verified Successfully!" + RESET);
            return true;
        } else {
		System.out.println();
            System.out.println(RED + "\t\t\t\t\t\t\t\t\tInvalid OTP. Please try again." + RESET);
	System.out.println();
            return false;
        }
    }
}

class User extends Primary_Details {


    private static String email;       // Static variable for email
    private static String phoneNumber; // Static variable for phone number

    // Getter methods to access email and phone number
    public static String getEmail() {
        return email;
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void Pri_Det() {
        System.out.println();
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t    Verification Required " + RESET);
        System.out.println();

        User obj = new User();

        boolean isEmailVerified = false;
        boolean isPhoneVerified = false;

        while (true) {
            System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t Email Verification\t\t\t Phone Number Verification" + RESET);
            System.out.println();

            // Email Verification
            while (!isEmailVerified) {
                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the Email: " + RESET);
                email = sc.next(); // Assign to the static variable
                if (obj.mail(email)) {
                    int emailOtp = obj.generateOtp();
                    if (obj.validateOtp(emailOtp)) {
                        isEmailVerified = true;
                        System.out.println();
                        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t   Email Verified Successfully!" + RESET);
                    }
                } else {
                    System.out.println();
                    System.out.println(RED + "\t\t\t\t\t\t\t\t\tInvalid Email. Please try again." + RESET);
                    System.out.println();
                }
            }

            // Phone Verification
            while (!isPhoneVerified) {
                System.out.println();
                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t   Enter the Phone Number: " + RESET);
                phoneNumber = sc.next(); // Assign to the static variable

                if (obj.isMobileNumberValid(phoneNumber)) {
                    int phoneOtp = obj.generateOtp();
		
                    if (obj.validateOtp(phoneOtp)) {
                        isPhoneVerified = true;
                        System.out.println();
                        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\tPhone Number Verified Successfully!" + RESET);
                    }
                } else {
                    System.out.println();
                    System.out.println(RED + "\t\t\t\t\t\t\t\t\tInvalid Phone Number. Please try again." + RESET);
                    System.out.println();
                }
            }

            // If both are verified, exit the loop
            if (isEmailVerified && isPhoneVerified) {
                System.out.println();
                System.out.println(GREEN + "\t\t\t\t\t\t\t\t    Both Email and Phone Verified Successfully!" + RESET);
                break;
            }
        }
    }
}


class Pass {

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

    static Scanner sc = new Scanner(System.in);
    ArrayList<Passenger> passengers;

    public Pass() {
        passengers = new ArrayList<>();
    }

    // Inner class to represent a passenger
    static class Passenger {
        public String name;
        public int age;
        public String gender;

        public Passenger(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void displayDetails() {
            System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "    Passenger Name: " + RESET + BRIGHTYELLOW + name + "\n" + RESET);
            System.out.println();
            System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "    Passenger Age: " + RESET + BRIGHTYELLOW + age + "\n" + RESET);
            System.out.println();
            System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "    Passenger Gender: " + RESET + BRIGHTYELLOW + gender + "\n" + RESET);
            System.out.println();
        }
    }

    // Method to add a passenger
    public void addPassenger(String name, int age, String gender) {
        Passenger newPassenger = new Passenger(name, age, gender);
        passengers.add(newPassenger);
    }

    // Method to display all passengers
    public void displayPassengers() {
        if (passengers.isEmpty()) {
            System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "    No passengers added yet." + RESET);
        } else {
            System.out.println();
            System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t >>>>>>>>>>>>>>>>>> Passenger Details are <<<<<<<<<<<<<<<<<<" + RESET);
            System.out.println();
            for (Passenger passenger : passengers) {
                passenger.displayDetails();
                System.out.println();
            }
        }
    }

    // Main logic for the program
    public void managePassengers() {
        while (true) {
            System.out.println();
            System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t >>>>>>>>>>>>>>>>>> Passenger Details <<<<<<<<<<<<<<<<<<" + RESET);
            System.out.println();
            System.out.print(CYAN + "\t\t\t\t\t\t\t\t\t" + "     1. Add Passenger " + "\n" + RESET);
            System.out.println();
            System.out.print(CYAN + "\t\t\t\t\t\t\t\t\t" + "     2. View Passengers " + "\n" + RESET);
            System.out.println();
            System.out.print(CYAN + "\t\t\t\t\t\t\t\t\t" + "     3. Exit " + "\n" + RESET);
            System.out.println();
            System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "     Choose an Option" + "\n" + RESET);
            System.out.println();
            System.out.println(MAGENTA + "\t\t\t\t\t\t\t    ------------------------------------------------------" + RESET);

            int n = sc.nextInt();
            sc.nextLine();

            switch (n) {
                case 1:
                    System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t     Enter Passenger Name " + "\n" + RESET);
                    String name = sc.next();
                    System.out.println();
                    System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t     Enter Passenger Age " + "\n" + RESET);
                    int age = sc.nextInt();

                    // Gender selection
                    System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t" + "     Select Gender " + "\n" + RESET);
                    System.out.println();
                    System.out.println(CYAN + "\t\t\t\t\t\t\t\t" + "      1. Male      2.Female     3.Others" + RESET);
                    System.out.println();

                    int genderOption = sc.nextInt();
                    String gender = "";

                    switch (genderOption) {
                        case 1:
                            gender = "Male";
                            break;
                        case 2:
                            gender = "Female";
                            break;
                        case 3:
                            gender = "Other";
                            break;
                        default:
                            System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "Invalid option. Defaulting to 'Other'." + RESET);
                            System.out.println();
                            gender = "Other";
                    }

                    addPassenger(name, age, gender);
                    System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t" + "Passenger added successfully!" + "\n" + RESET);
                    System.out.println();
                    break;

                case 2:
                    displayPassengers();
                    break;
                case 3:
                    if (passengers.isEmpty()) {
                        System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "No passengers to review." + RESET);
			System.out.println();
                        System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "   Add Passengers First" + RESET);

			managePassengers();
                    } else {
                        System.out.println(GREEN + "\t\t\t\t\t\t\t\t" + "          Reviewing all passenger details..." + RESET);
                        // Display all passengers
                        List<Pass.Passenger> passengersList = new ArrayList<>(passengers); // Convert passengers list to a new List
                        View.view(passengersList); // Pass the list of passengers to the view method
                    }

                    // Perform payment after reviewing all passengers
                    try {
                        Thread.sleep(2100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return;

                default:
                    System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "    Invalid Input. Please try again..." + RESET);
			return;
            }
        }
    }
}


class View {

    // Additional ANSI escape codes for colors
    public static final String BRIGHTRED = "\u001B[91m";
    public static final String BRIGHTGREEN = "\u001B[92m";
    public static final String BRIGHTBLUE = "\u001B[94m";
    public static final String BRIGHTWHITE = "\u001B[97m";
    public static final String DARKGRAY = "\u001B[90m";
    public static final String LIGHTGRAY = "\u001B[37m";
    public static final String BRIGHTBLACK = "\u001B[90m"; // Same as dark gray
    public static final String ORANGE = "\u001B[38;5;208m"; // Custom orange
    public static final String PURPLE = "\u001B[38;5;93m"; // Custom purple
    public static final String PINK = "\u001B[38;5;206m"; // Custom pink
    public static final String TEAL = "\u001B[38;5;45m"; // Custom teal

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

    public static void view(List<Pass.Passenger> passengers) {
        System.out.println();
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t   ....................... ReView ....................... " + RESET);

        System.out.println();

        // Review each passenger
        for (Pass.Passenger passenger : passengers) {
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t    ------------------------------------------------------" + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     1.Name:" + RESET + ORANGE + passenger.name + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     2.Age:" + RESET + ORANGE + passenger.age + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t    3.Gender:" + RESET + ORANGE + passenger.gender + RESET + BRIGHTBLACK + "                       " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     4.Mobile Number:" + RESET + ORANGE + User.getPhoneNumber() + RESET + BRIGHTBLACK + "          " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     5.Email:" + RESET + ORANGE + User.getEmail() + RESET + BRIGHTBLACK + "     		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     6.Source:" + RESET + ORANGE + Source.getSrc() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     7.Destination:" + RESET + ORANGE + Source.getDst() + RESET + BRIGHTBLACK + "     	         " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     8.Date:" + RESET + ORANGE + Source.getDate1() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t                                            		 " + RESET);
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t    ------------------------------------------------------" + RESET);
        }

        // After reviewing all passengers, call the payment method
        PaymentMethod.payments(passengers); // Pass the 'passengers' list here

    }
}


class PhonePay extends EconomyClass {

    private static final double TAX_RATE = 0.10; // 10% tax rate
    private static final double OFFER_DISCOUNT = 0.15; // Example: 15% discount
    public static double grandTotal = 0;
public static void phonepayment(List<Pass.Passenger> passengers, String seatClass) {  
    if (passengers.isEmpty()) {
        System.out.println();
        System.out.println(RED + "\t\t\t\t\t\t\t\tNo passengers found. Please add passengers first." + RESET);
        System.out.println();
        return;
    }

    // Set a default selectedSeat if seatClass is PremiumClass
    String selectedSeat = "A1";  // Default seat for PremiumClass, modify this to any valid seat you prefer
    if (seatClass.equals("PremiumClass") ||seatClass.equals("BusinessClass") && selectedSeat == null) {
        selectedSeat = "A1";  // Ensure it is not null by providing a default seat
    }

    System.out.println();
    System.out.println(PINK + "\t\t\t\t\t\t            ................... Payment Details ................... " + RESET);
    System.out.println();

    int passengerNumber = 1; // Counter for passenger number

    // Iterate through passengers and calculate cost for each
    for (Pass.Passenger passenger : passengers) {
        if (selectedSeat == null) {
            System.out.println("\t\t\t\t\t\t\t\t\t No seat selected for passenger: " + passenger.name);
            continue;
        }

        double baseCost = 0;

        // Determine base cost based on seat class
        if (seatClass.equals("EconomyClass")) {
            baseCost = switch (selectedSeat) {
                case "A1", "A4" -> COST_A1;
                case "A2" -> COST_A2;
                case "A3" -> COST_A3;
                default -> 0; // Default cost if seat is invalid
            };
        } else if (seatClass.equals("PremiumClass")) {
            baseCost = 150; // Example cost for Premium class
        } else if (seatClass.equals("BusinessClass")) {
            baseCost = 250; // Example cost for Business class
        }

        if (baseCost == 0) {
            System.out.println("\t\t\t\t\t\t\t\t\t Invalid seat for passenger: " + passenger.name);
            continue;
        }

        // Calculate tax
        double taxAmount = baseCost * TAX_RATE;
        double totalCost = baseCost + taxAmount;

        // Apply discount if applicable
        double discountAmount = 0;
        if (BillGenerator.totalAmount > 0) {
            discountAmount = totalCost * OFFER_DISCOUNT;
        }

        double finalAmount = totalCost - discountAmount;

        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        System.out.println();
        System.out.println(PINK + "\t\t\t\t\t\t              ................... Passenger " + passengerNumber + " ................... " + RESET);
        System.out.println();
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     1.Passenger: " + RESET + ORANGE + passenger.name + RESET + BRIGHTBLACK + "          " + RESET);
        System.out.println();
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     2.Base Cost: " + RESET + ORANGE + "$" + baseCost + RESET + BRIGHTBLACK + "     		   " + RESET);
        System.out.println();
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     3.Tax: " + RESET + ORANGE + "$" + taxAmount + RESET + BRIGHTBLACK + "     		           " + RESET);
        System.out.println();
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     4.Discount: " + RESET + ORANGE + "-$" + discountAmount + RESET + BRIGHTBLACK + "     		   " + RESET);
        System.out.println();
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     5.Final Amount(tax & discount): " + RESET + ORANGE + "$" + finalAmount + RESET + BRIGHTBLACK + "   " + RESET);
        System.out.println();

        // Include food costs for each passenger
        double passengerTotal = finalAmount + BillGenerator.totalAmount;
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     6.Total (with food): " + RESET + ORANGE + "$" + passengerTotal + RESET + BRIGHTBLACK + "   	   " + RESET);
        System.out.println();
        //System.out.printf("\t\t\t\t\t\t\t\t\t   Total (with food): $%.2f\n\n", passengerTotal);
        System.out.println();
        grandTotal += passengerTotal;

        passengerNumber++;
    }

    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
    System.out.println();
    System.out.println(PINK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
    System.out.println(PINK + "\t\t\t\t\t\t\t    |                                        		 |" + RESET);
    System.out.println(PINK + "\t\t\t\t\t\t\t    |    " + RESET + CYAN + "\t       Grand Total:  " + RESET + ORANGE + "$" + grandTotal + RESET + PINK + " \t\t |" + RESET);
    System.out.println(PINK + "\t\t\t\t\t\t\t    |                                        		 |" + RESET);
    System.out.println(PINK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
    System.out.println();
}
}

class PhonePay1 extends PremiumClass {
    private static final double TAX_RATE = 0.10; // 10% tax rate
    private static final double OFFER_DISCOUNT = 0.15; // 15% discount
    public static double grandTotal = 0;

    public static void phonepayment(List<Pass.Passenger> passengers) {
        if (passengers.isEmpty()) {
            System.out.println();
            System.out.println(RED + "\t\t\t\t\t\t\t\tNo passengers found. Please add passengers first." + RESET);
            System.out.println();
            return;
        }

        // Accumulate total for all passengers
        System.out.println();
        System.out.println(PINK + "\t\t\t\t\t\t            ................... Payment Details ................... " + RESET);
        System.out.println();

        int passengerNumber = 1; // Counter for passenger number

        // Iterate through passengers and calculate cost for each
        for (Pass.Passenger passenger : passengers) {
            if (selectedSeat == null) {
                System.out.println("\t\t\t\t\t\t\t\t\t No seat selected for passenger: " + passenger.name);
                continue;
            }

            // Calculate base cost based on selected seat
            double baseCost = switch (selectedSeat) {
                case "A1", "A4" -> COST_A1;
                case "A2" -> COST_A2;
                case "A3" -> COST_A3;
                default -> 0; // Default cost if seat is invalid
            };

            // Debugging outputs for cost calculations
            System.out.println("DEBUG: Passenger = " + passenger.name);
            System.out.println("DEBUG: Selected Seat = " + selectedSeat);
            System.out.println("DEBUG: Base Cost = " + baseCost);

            if (baseCost == 0) {
                System.out.println("\t\t\t\t\t\t\t\t\t Invalid seat for passenger: " + passenger.name);
                continue;
            }

            // Calculate tax
            double taxAmount = baseCost * TAX_RATE;
            double totalCost = baseCost + taxAmount;

            // Apply discount if applicable
            double discountAmount = 0;
            if (BillGenerator.totalAmount > 0) {
                discountAmount = totalCost * OFFER_DISCOUNT;
            }

            double finalAmount = totalCost - discountAmount;

            // Display passenger details
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
            System.out.println();
            System.out.println(PINK + "\t\t\t\t\t\t              ................... Passanger " + passengerNumber + " ................... " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     1.Passenger: " + RESET + ORANGE + passenger.name + RESET + BRIGHTBLACK + "          " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     2.Base Cost: " + RESET + ORANGE + "$" + baseCost + RESET + BRIGHTBLACK + "     		   " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     3.Tax: " + RESET + ORANGE + "$" + taxAmount + RESET + BRIGHTBLACK + "     		           " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     4.Discount: " + RESET + ORANGE + "-$" + discountAmount + RESET + BRIGHTBLACK + "     		   " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     5.Final Amount (tax & discount): " + RESET + ORANGE + "$" + finalAmount + RESET + BRIGHTBLACK + "   " + RESET);
            System.out.println();
            // Include food costs for each passenger
            double passengerTotal = finalAmount + BillGenerator.totalAmount;
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        " + RESET + CYAN + "\t     6.Total (with food): " + RESET + ORANGE + "$" + passengerTotal + RESET + BRIGHTBLACK + "   	   " + RESET);
            System.out.println();

            // Debugging output for final total calculation
            System.out.println("DEBUG: Final amount (with food) for passenger: " + passenger.name + " = " + passengerTotal);
            grandTotal += passengerTotal;

            passengerNumber++;
        }

        // Final Grand Total Display
        System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        System.out.println();
        System.out.println(PINK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        System.out.println(PINK + "\t\t\t\t\t\t\t    |                                        		 |" + RESET);
        System.out.println(PINK + "\t\t\t\t\t\t\t    |    " + RESET + CYAN + "\t       Grand Total:  " + RESET + ORANGE + "$" + grandTotal + RESET + PINK + " \t\t |" + RESET);
        System.out.println(PINK + "\t\t\t\t\t\t\t    |                                        		 |" + RESET);
        System.out.println(PINK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        displayPremiumFeatures();
        // Initialize your passenger list
        List<Pass.Passenger> passengers = null; // Initialize passengers list appropriately
        // Call the payment function after seat selection
        phonepayment(passengers);
    }
}


class PhonePay2 extends BusinessClass {

    private static final double TAX_RATE = 0.10; // 10% tax rate
    private static final double OFFER_DISCOUNT = 0.15; // Example: 15% discount
    public static double grandTotal = 0;
    public static void phonepayment(List<Pass.Passenger> passengers) {
        if (passengers.isEmpty()) {
		System.out.println();
            System.out.println(RED+"\t\t\t\t\t\t\t\tNo passengers found. Please add passengers first."+RESET);
		System.out.println();
            return;
        }

 // Accumulate total for all passengers
	System.out.println();
	System.out.println(PINK+ "\t\t\t\t\t\t            ................... Payment Details ................... " + RESET);
	System.out.println();
	
	int passengerNumber = 1; // Counter for passenger number

        // Iterate through passengers and calculate cost for each
        for (Pass.Passenger passenger : passengers) {
            if (selectedSeat == null) {
                System.out.println("\t\t\t\t\t\t\t\t\t No seat selected for passenger: " + passenger.name);
                continue;
            }

            double baseCost = switch (selectedSeat) {
                case "A1", "A4" -> COST_A1;
                case "A2" -> COST_A2;
                case "A3" -> COST_A3;
                default -> 0; // Default cost if seat is invalid
            };

            if (baseCost == 0) {
                System.out.println("\t\t\t\t\t\t\t\t\t Invalid seat for passenger: " + passenger.name);
                continue;
            }

            // Calculate tax
            double taxAmount = baseCost * TAX_RATE;
            double totalCost = baseCost + taxAmount;

            // Apply discount if applicable
            double discountAmount = 0;
            if (BillGenerator.totalAmount > 0) {
                discountAmount = totalCost * OFFER_DISCOUNT;
            }

            double finalAmount = totalCost - discountAmount;

	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------"+RESET);
	System.out.println();
	System.out.println(PINK+ "\t\t\t\t\t\t              ................... Passanger "+passengerNumber+" ................... " + RESET);

	System.out.println();
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        "+RESET+CYAN+"\t     1.Passanger: "+RESET+ORANGE+passenger.name+RESET+BRIGHTBLACK+"          "+RESET);
	System.out.println();
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        "+RESET+CYAN+"\t     2.Base Cost: "+RESET+ORANGE+"$"+baseCost+RESET+BRIGHTBLACK+"     		   "+RESET);
	System.out.println();
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        "+RESET+CYAN+"\t     3.Tax: "+RESET+ORANGE+"$"+taxAmount+RESET+BRIGHTBLACK+"     		           "+RESET);
	System.out.println();
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        "+RESET+CYAN+"\t     4.Discount: "+RESET+ORANGE+"-$"+discountAmount+RESET+BRIGHTBLACK+"     		   "+RESET);
	System.out.println();
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        "+RESET+CYAN+"\t     5.Final Amount(tax & discount): "+RESET+ORANGE+"$"+finalAmount+RESET+BRIGHTBLACK+"   "+RESET);
	System.out.println();
            // Include food costs for each passenger
            double passengerTotal = finalAmount + BillGenerator.totalAmount;
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t        "+RESET+CYAN+"\t     6.Total (with food): "+RESET+ORANGE+"$"+passengerTotal+RESET+BRIGHTBLACK+"   	   "+RESET);
	System.out.println();
            //System.out.printf("\t\t\t\t\t\t\t\t\t   Total (with food): $%.2f\n\n", passengerTotal);
	System.out.println();
            grandTotal += passengerTotal;
		
	passengerNumber++;

        }
	    System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------"+RESET);
	System.out.println();
	    System.out.println(PINK + "\t\t\t\t\t\t\t   --------------------------------------------------------"+RESET);
	    System.out.println(PINK + "\t\t\t\t\t\t\t    |                                        		 |" + RESET);
	    System.out.println(PINK + "\t\t\t\t\t\t\t    |    "+RESET+CYAN+"\t       Grand Total:  "+RESET+ORANGE+"$"+grandTotal+RESET+PINK+" \t\t |"+RESET);
            System.out.println(PINK + "\t\t\t\t\t\t\t    |                                        		 |" + RESET);
	    System.out.println(PINK + "\t\t\t\t\t\t\t   --------------------------------------------------------"+RESET);
	System.out.println();

 
   }

}


abstract class Project
{
	static Scanner sc=new Scanner(System.in);
	int cvv;
	 boolean isCvvValid() {
		  
	        return (cvv >= 100 && cvv <= 999);
	    }
	abstract void pay(float a);
}



class Payment extends Project {

    // Additional ANSI escape codes for colors
    public static final String BRIGHTRED = "\u001B[91m";
    public static final String BRIGHTGREEN = "\u001B[92m";
    public static final String BRIGHTYELLOW = "\u001B[93m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[91m";
    public static final String RESET = "\u001B[0m";

    static Scanner scan = new Scanner(System.in);

    // Overriding pay method
    @Override
    void pay(float a) {
        // Payment logic is delegated to individual methods
    }

    public void UPIPayment() {
        String upid;
        while (true) {
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter UPID " + RESET);
            upid = scan.next();
            if (upid.length() == 14 && (upid.endsWith("@ybl") || upid.endsWith("@ibl") || upid.endsWith("@axl"))) {
                break;
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Wrong UPID, please try again." + RESET);
            }
        }

        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the UPI pin: " + RESET);
        int upin = scan.nextInt();
        if (upin >= 1000 && upin <= 9999) {
            System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t       Validation Completed" + RESET);
        } else {
            System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Entered a wrong UPI pin" + RESET);
        }

    }

    public void CardPayment() {
        String cardNumber;
        while (true) {
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter your card number: " + RESET);
            cardNumber = scan.next();
            if (cardNumber.length() == 16) {
                System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t       Valid card number" + RESET);
                break;
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Invalid card number" + RESET);
            }
        }

        String cvv;
        while (true) {
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the CVV number: " + RESET);
            cvv = scan.next();
            if (cvv.length() == 3 && cvv.matches("\\d{3}")) {
                System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t       Valid CVV number" + RESET);
                break;
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Invalid CVV number" + RESET);
            }
        }

        int MM;
        String YYYY;
        while (true) {
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the card validity (MM/YYYY): " + RESET);
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the Month: " + RESET);
            MM = scan.nextInt();
            System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the Year: " + RESET);
            YYYY = scan.next();

            if (MM >= 1 && MM <= 12) {
                System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t       Valid month" + RESET);
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Invalid month" + RESET);
                continue;
            }

            if (YYYY.length() == 4) {
                int expiryYear = Integer.parseInt(YYYY);
                int currentYear = LocalDate.now().getYear();
                if (expiryYear >= currentYear) {
                    System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t       Valid year" + RESET);
                    break;
                } else {
                    System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Card has expired, please try again." + RESET);
                }
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Invalid year format, please try again." + RESET);
            }
        }

        int min = 1000;
        int max = 9999;
        Random rand = new Random();
        int randomOTP = rand.nextInt(max - min + 1) + min;
        System.out.println(RED + "\t\t\t\t\t\t\t\t       Generated OTP (Do not share): " + RESET + BRIGHTYELLOW + randomOTP + RESET);

        while (true) {
            System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter OTP: " + RESET);
            int otp = scan.nextInt();
            if (otp == randomOTP) {
                System.out.println(GREEN + "\t\t\t\t\t\t\t\t\t       OTP Verified" + RESET);
                break;
            } else {
                System.out.println(RED + "\t\t\t\t\t\t\t\t\t       Invalid OTP, please try again." + RESET);
            }
        }
    }
}


class PaymentMethod {

    static Scanner sc = new Scanner(System.in);

    // ANSI escape codes for colors
    public static final String BRIGHTRED = "\u001B[91m";
    public static final String BRIGHTGREEN = "\u001B[92m";
    public static final String BRIGHTBLUE = "\u001B[94m";
    public static final String RESET = "\u001B[0m";
    public static final String BRIGHTYELLOW = "\u001B[93m";
    public static final String TEAL = "\u001B[38;5;45m";
    public static final String RED = "\u001B[91m";

   public static void payments(List<Pass.Passenger> passengers) {

    Payment payment = new Payment();

	EconomyClass e1  = new EconomyClass();

	PremiumClass p1  = new PremiumClass();

	BusinessClass b1 = new BusinessClass();


    System.out.println();
    while (true) {
        System.out.println();
        System.out.println(BRIGHTBLUE + "\t\t\t\t\t\t            --------------- Select Your Payment Mode --------------- " + RESET);
        System.out.println();
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter 1 for UPI " + "\n" + RESET);
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter 2 for Credit Card " + "\n" + RESET);
        System.out.println();

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println();
                System.out.println(TEAL + "\t\t\t\t\t\t\t\t     YOU HAVE SELECTED UPI FOR PAYMENT MODE " + RESET);
                System.out.println();
                payment.UPIPayment();
	
if (e1.getClass() == EconomyClass.class) {
    PhonePay.phonepayment(passengers, "EconomyClass"); // Pass the class name as a String
} else if (p1.getClass() == PremiumClass.class) {
    PhonePay.phonepayment(passengers, "PremiumClass"); // Pass the class name as a String
} else if (b1.getClass() == BusinessClass.class) {
    PhonePay.phonepayment(passengers, "BusinessClass"); // Pass the class name as a String
} else {
    System.out.println(RED + "\t\t Select a Valid Class" + RESET);
}

            break;
              

            case 2:
                System.out.println();
                System.out.println(TEAL + "\t\t\t\t\t\t\t\t     YOU HAVE SELECTED Credit Card FOR PAYMENT MODE " + RESET);
                System.out.println();
                payment.CardPayment();
if (e1.getClass() == EconomyClass.class) {
    PhonePay.phonepayment(passengers, "EconomyClass"); // Pass the class name as a String
} else if (p1.getClass() == PremiumClass.class) {
    PhonePay.phonepayment(passengers, "PremiumClass"); // Pass the class name as a String
} else if (b1.getClass() == BusinessClass.class) {
    PhonePay.phonepayment(passengers, "BusinessClass"); // Pass the class name as a String
} else {
    System.out.println(RED + "\t\t Select a Valid Class" + RESET);
}

                break;

            default:
                System.out.println(RED + "\t\t\t\t\t\t\t\t       Invalid choice! Please select a valid payment mode." + RESET);
                continue;
        }

        System.out.println();
        System.out.print(RED + "\t\t\t\t\t\t         1. Payment Confirmation          2. Return          3. Exit" + "\n" + RESET);

        int nextStep = sc.nextInt();

        if (nextStep == 1) {
            System.out.println();
            System.out.print(BRIGHTRED + "\t\t\t\t\t\t\t\t\t\t Confirming" + RESET);

            for (int i = 5; i >= 0; i--) {
                System.out.print(RED + "." + RESET);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            System.out.println();
            System.out.println();
            System.out.println(BRIGHTGREEN + "\t\t\t\t\t\t\t\t\t PAYMENT PROCEEDED SUCCESSFULLY " + "\n" + RESET);

            // Display ticket after successful payment
            Ticket.ticket(passengers);

            // Exit the loop after successful ticket booking
            break;

        } else if (nextStep == 2) {
            // Restart the payment process
            continue;

        } else if (nextStep == 3) {
            System.out.print(RED + "\t\t\t\t\t\t\t\t\t Exiting the application" + RESET);
            break;
        } else {
            System.out.println(RED + "\t\t\t\t\t\t\t\t       Invalid option! Please try again." + RESET);
        }
    }
}

}



class Ticket extends View {

    public static String generatePNR() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder pnr = new StringBuilder();

        // Generate a PNR of 6 characters
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            pnr.append(characters.charAt(index));
        }

        return pnr.toString();
    }

    static int otp() {
        int random;
        int min = 100000;
        int max = 999999;
        Random rand = new Random();
        random = rand.nextInt(max - min + 1) + min;
        return random;
    }

    public static void ticket(List<Pass.Passenger> passengers) {
        Source s = new Source();
        EconomyClass e = new EconomyClass();
        PremiumClass p = new PremiumClass();
        Ticket obj = new Ticket();
        obj.otp();
        String pnr = generatePNR();

        System.out.print(BRIGHTGREEN + "\t\t\t\t\t\t\t\t\t\tUser Ticket " + "\n" + RESET);

        // EconomyClass Block
        if (e.getClass() == EconomyClass.class) {
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Ticket Number: " + RESET + ORANGE + Ticket.otp() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     PNR: " + RESET + ORANGE + pnr + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Flight Number: " + RESET + ORANGE + s.a1 + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Source : " + RESET + ORANGE + Source.getSrc() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Destination: " + RESET + ORANGE + Source.getDst() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();

            int passengerNumber = 1; // Counter for passenger number
            for (Pass.Passenger passenger : passengers) {
                System.out.println(LIGHTGRAY + "\t\t\t\t\t\t                              Passanger " + passengerNumber + "                " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Name :" + RESET + ORANGE + passenger.name + RESET + BRIGHTBLACK + "     		         " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Age :" + RESET + ORANGE + passenger.age + RESET + BRIGHTBLACK + "     		         " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Gender :" + RESET + ORANGE + passenger.gender + RESET + BRIGHTBLACK + "                       " + RESET);
                System.out.println();
                passengerNumber++;
            }
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t      Total Price :" + RESET + ORANGE + "$" + PhonePay.grandTotal + RESET + BRIGHTBLACK + "                       " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        }
        // PremiumClass Block
        else if (p.getClass() == PremiumClass.class) {
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Ticket Number: " + RESET + ORANGE + Ticket.otp() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     PNR: " + RESET + ORANGE + pnr + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Flight Number: " + RESET + ORANGE + s.a1 + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Source : " + RESET + ORANGE + Source.getSrc() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Destination: " + RESET + ORANGE + Source.getDst() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();

            int passengerNumber = 1; // Counter for passenger number
            for (Pass.Passenger passenger : passengers) {
                System.out.println(LIGHTGRAY + "\t\t\t\t\t\t                              Passanger " + passengerNumber + "                " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Name :" + RESET + ORANGE + passenger.name + RESET + BRIGHTBLACK + "     		         " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Age :" + RESET + ORANGE + passenger.age + RESET + BRIGHTBLACK + "     		         " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Gender :" + RESET + ORANGE + passenger.gender + RESET + BRIGHTBLACK + "                       " + RESET);
                System.out.println();
                passengerNumber++;
            }
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t      Total Price :" + RESET + ORANGE + "$" + PhonePay.grandTotal + RESET + BRIGHTBLACK + "                       " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        } else {
            // Default Block for other cases
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Ticket Number: " + RESET + ORANGE + Ticket.otp() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     PNR: " + RESET + ORANGE + pnr + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Flight Number: " + RESET + ORANGE + s.a1 + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Source : " + RESET + ORANGE + Source.getSrc() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t     Destination: " + RESET + ORANGE + Source.getDst() + RESET + BRIGHTBLACK + "     		         " + RESET);
            System.out.println();

            int passengerNumber = 1; // Counter for passenger number
            for (Pass.Passenger passenger : passengers) {
                System.out.println(LIGHTGRAY + "\t\t\t\t\t\t                              Passanger " + passengerNumber + "                " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Name :" + RESET + ORANGE + passenger.name + RESET + BRIGHTBLACK + "     		         " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Age :" + RESET + ORANGE + passenger.age + RESET + BRIGHTBLACK + "     		         " + RESET);
                System.out.println();
                System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t       Gender :" + RESET + ORANGE + passenger.gender + RESET + BRIGHTBLACK + "                       " + RESET);
                System.out.println();
                passengerNumber++;
            }
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t         " + RESET + CYAN + "\t      Total Price :" + RESET + ORANGE + "$" + PhonePay.grandTotal + RESET + BRIGHTBLACK + "                       " + RESET);
            System.out.println();
            System.out.println(BRIGHTBLACK + "\t\t\t\t\t\t\t   --------------------------------------------------------" + RESET);
        }

        System.out.println();
        System.out.print(BRIGHTCYAN + "\t\t\t\t\t\t\t\t    YOUR TICKET IS BOOKED SUCCESSFULLY " + "\n" + RESET);
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
                + "                    =-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-= WELCOME TO SKYHIGH(TASMA) AIRLINES RESERVATION SYSTEM -=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-= "
                + RESET);

        // Airplane Art shifted slightly to the right
        System.out.println("\n"); // Space before airplane art for proper alignment
        System.out.println("\t\t\t\t\t\t\t\t " + YELLOW + "          __|__");
        System.out.println("\t\t\t\t\t\t\t\t " + "  _______/     \\_______");
        System.out.println("\t\t\t\t\t\t\t\t " + CYAN + " /    o o o o o o o    \\" + RESET);
        System.out.println("\t\t\t\t\t\t\t " + "        /-----------------------\\");
        System.out.println("\t\t\t\t\t\t\t " + "        |    " + YELLOW + "SKYHIGH AIRLINES " + RESET + "  |");
        System.out.println("\t\t\t\t\t\t\t\t " + "\\_______________________/");
        System.out.println("\t\t\t\t\t\t\t\t " + Blue + "     |    |    |    |" + RESET);
        System.out.println("\t\t\t\t\t\t\t\t " + Blue + "     |    |    |    |" + RESET);
        System.out.println("\t\t\t\t\t\t\t\t " + Blue + "     |    |    |    |" + RESET);
        System.out.println("\t\t\t\t\t\t\t\t " + "    /     |    |     \\" + MAGENTA);
        System.out.println("\t\t\t\t\t\t\t\t " + "   /      |    |      \\");
        System.out.println("\t\t\t\t\t\t\t\t " + "  /_______|____|_______\\" + RESET);
        System.out.println();
        System.out.println();

        System.out.println(CYAN
                + "                    =-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=--=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= "
                + RESET);

        Credit.cred();

        
	Source.source();
	
	Choose.choose();

	//EconomyClass.displayEconomyFeatures();
	//PremiumClass.displayPremiumFeatures();




    }
}
