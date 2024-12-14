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
    public boolean validate(String inputUsername, String inputPassword, long inputPhone, int otp) {
        return inputUsername.equals(Name) && inputPassword.equals(Password) && inputPhone == Phone && otp==7979;
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
                    System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t" + "      Enter OTP " + "\n" + RESET);
                    int otp = scanner.nextInt();
                    if (crendital.validate(inputUsername, inputPassword, inputPhone,otp)) {
                        System.out.println(BRIGHTCYAN+ "\t\t\t    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..Login successful! Welcome..<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ "" + RESET);
			System.out.println();
                        break; // Exit the loop after successful login
                    } else {
                        System.out.println(RED + "\t\t\t\t\t\t\t" + "Invalid credentials. Please try again." + RESET);
                    }
                }
            } else if (choice == 3) {
                // Exit the application
                System.out.println(RED + "\t\t\t\t\t\t\t" + "Exiting the application. Goodbye!" + RESET);
                System.exit(0); // Terminate the program

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
                    System.out.println(CYAN + "\t\t              ............................Current's Date & Time:"+date+"............................" + RESET);
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
                            System.out.println(BRIGHTYELLOW+ "\t\t\t\t   ..............................Your Flight Number is AI101.............................." + RESET);
			    	
		            Choose.choose();
                            break;
                        } else if (src.equalsIgnoreCase("Dubai") && dst.equalsIgnoreCase("Mumbai")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t   ..............................Your Flight Number is EK202.............................." + RESET);
                            			    	
		            Choose.choose();
			    break;
 
                        } else if (src.equalsIgnoreCase("Singapore") && dst.equalsIgnoreCase("Sydney")) {
                            System.out.println(BRIGHTYELLOW+ "\t\t\t\t   ..............................Your Flight Number is SQ404.............................." + RESET);
			    	
		            Choose.choose();                            
                            break;
                        } else if (src.equalsIgnoreCase("London") && dst.equalsIgnoreCase("Paris")) {
                            System.out.println(BRIGHTYELLOW + "\t\t\t\t   ..............................Your Flight Number is BA303.............................." + RESET);
			    	
		            Choose.choose();
                           
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
                    System.exit(0); // Terminate the program
		    break;

                default:
                    // Handle invalid input
                    System.out.println(RED+ "\t\t\t\t\t\t             Invalid choice! Please select a valid option.");
			break;
            }
        }

    }
}


// Economy class extending Source

class EconomyClass extends Source {
    // ANSI escape codes for colors
    private static final String YELLOW = "\033[33m";
    private static final String BRIGHTYELLOW = "\033[93m";
    private static final String BRIGHTCYAN = "\033[96m";
    private static final String RESET = "\033[0m";

    // Actual seat costs
    private static final int COST_A1 = 20;   // A1: Window seat
    private static final int COST_A2 = 15;   // A2: Middle seat
    private static final int COST_A3 = 12;   // A3: Middle seat
    private static final int COST_A4 = 20;   // A4: Window seat

public static void displayEconomyFeatures() {
     System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "   Economy Class" + RESET);
     System.out.println();

    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTYELLOW + "\t         Seat Number\t    \t    \t    Type \t\t\t AV/NA   \t\t      Cost " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    // Series B
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    // Series C
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");

	while(true){
			System.out.println();
                	System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Enter the Seat Number" + RESET);
		String seat = sc.next();
		
		if(seat.equals("A1") ||seat.equals("A1") ||seat.equals("A4") ||seat.equals("B1") ||seat.equals("B4") ||seat.equals("C1") ||seat.equals("C4") ){
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
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
     			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
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




// Premium class extending Source

class PremiumClass extends Source {

    // ANSI escape codes for colors
    private static final String YELLOW = "\033[33m";
    private static final String BRIGHTYELLOW = "\033[93m";
    private static final String BRIGHTCYAN = "\033[96m";
    private static final String RESET = "\033[0m";

    // Actual seat costs
    private static final int COST_A1 = 22;   // A1: Window seat
    private static final int COST_A2 = 17;   // A2: Middle seat
    private static final int COST_A3 = 14;   // A3: Middle seat
    private static final int COST_A4 = 22;   // A4: Window seat

public static void displayPremiumFeatures() {
     System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "   Premium Class" + RESET);
     System.out.println();

    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTYELLOW + "\t         Seat Number\t    \t    \t    Type \t\t\t AV/NA   \t\t      Cost " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             A4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    // Series B
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             B4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    // Series C
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C1\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A1 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C2\t    \t    \t \t   Middle  \t\t\t  NA  \t\t\t      $" + COST_A2 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C3\t    \t    \t \t   Aisle  \t\t\t  AV  \t\t\t      $" + COST_A3 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                  	      |");
    System.out.println("            	   |   " + BRIGHTCYAN + "\t             C4\t    \t    \t \t   Window  \t\t\t  AV  \t\t\t      $" + COST_A4 + "  " + RESET + YELLOW + "           |");
    System.out.println("             	   |                                                                                                                 	      |");
    
    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");

	while(true){
			System.out.println();
                	System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Enter the Seat Number" + RESET);
		String seat = sc.next();
		
		if(seat.equals("A1") ||seat.equals("A1") ||seat.equals("A4") ||seat.equals("B1") ||seat.equals("B4") ||seat.equals("C1") ||seat.equals("C4") ){
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
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
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
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

    // ANSI escape codes for colors
    private static final String YELLOW = "\033[33m";
    private static final String BRIGHTYELLOW = "\033[93m";
    private static final String BRIGHTCYAN = "\033[96m";
    private static final String RESET = "\033[0m";

    // Actual seat costs
    private static final int COST_A1 = 24;   // A1: Window seat
    private static final int COST_A2 = 19;   // A2: Middle seat
    private static final int COST_A3 = 16;   // A3: Middle seat
    private static final int COST_A4 = 24;   // A4: Window seat

public static void displayBusinessFeatures() {
     System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + "   Bussiness Class" + RESET);
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
    
    System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");

	while(true){
			System.out.println();
                	System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Enter the Seat Number" + RESET);
		String seat = sc.next();
		
		if (seat.equals("A1") || seat.equals("A4") || seat.equals("B1") || seat.equals("B4") || seat.equals("C1") || seat.equals("C4")) {
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			System.out.println();
			break;
		} else if (seat.equals("A2") || seat.equals("B2") || seat.equals("C2")) {
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
			System.out.println();
			break;
		} else if (seat.equals("A3") || seat.equals("B3") || seat.equals("C3")) {
    			System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t " + seat + " is a Window Seat"+ RESET);
			System.out.println();
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
	public static void choose(){
		Scanner sc = new Scanner(System.in);
		System.out.println();
                System.out.println(YELLOW + "                    --------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("             	   |                                                                                                                 	      |");
                    
		System.out.println("            	   |   " + BLUE + "S.No.\t   Feature \t    Economy Class \t Premium Economy Class   \t Business Class   " + RESET + YELLOW + "\t\t      |");
                System.out.println("             	   |                                                                                                                          |");
		System.out.println("            	   |     " + GREEN + "1\tSeating Comfort     Standard seats\t      Wider seats    \t\t recliners seats " + RESET + YELLOW + "\t\t      |");
                System.out.println("             	   |                                                                                                                 	      |\t");

		System.out.println("            	   |     " + GREEN + "2\tMeal Options  \t    Basic meals\t\t    Upgraded meals        \t Gourmet meals\t" + RESET + YELLOW + "\t\t      |");

                System.out.println("             	   |                                                                                                                          |");

		System.out.println("            	   |     " + GREEN + "3\tAmenities \t      Basic\t\t\tUpgraded   \t\t    Opulent \t" + RESET + YELLOW + "\t\t      |");
                System.out.println("             	   |                                                                                                                          |");
		System.out.println("            	   |     " + GREEN + "4\tCost  \t\t     Low\t      \t     Medium - High    \t\t    Highest \t   " + RESET + YELLOW + "\t\t      |");

                System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
               System.out.println("");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");

		 System.out.println("             	   |                                                                                                                          |");
		System.out.println("            	   |   " + BRIGHTCYAN + "\t1.Economy Class \t           2. Premium Economy Class    \t\t3. Business Class         \t4.Exit" + RESET + YELLOW +"        |");
		 System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);

		System.out.println();
		
//.............................................
	Upgrade food = new Food();
//.............................................


		while(true){
			System.out.println("Enter your Choice: ");
			int n=sc.nextInt();
			if(n==1){
				EconomyClass.displayEconomyFeatures();
				food.displayFeatures();
				break;
			}
			
			else if(n==2){
				 PremiumClass.displayPremiumFeatures();
				 break;
			}
			
			else if(n==3){
				BusinessClass.displayBusinessFeatures();
				break;
			}
			else if(n==4){
				Credit.cred();
				break;
			}
			else{
                System.out.println(RED + "\t\t\t\t\t\t\t" + "   Enter Valid Choice!" + RESET);

			}
		break;
		}
	} 
}


abstract class Upgrade{

    public abstract void displayFeatures();
}


class Food extends Upgrade {
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

    @Override
    public void displayFeatures() {
	Scanner sc = new Scanner(System.in);
         System.out.println(RED + "\t\t\t\t\t\t\t" + " 1.Flex Plus               2. Saver              3.Exit" + RESET);
	System.out.println();

rev:while(true){
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
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t1.Sandwich \t               1   \t\t  $5 " + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t2.Chips \t               1   \t\t  $2 " + RESET + YELLOW +"                \t\t       |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t3.Soft Drink \t               1   \t\t  $3 " + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t4.Water Bottle \t               1   \t\t  $1 " + RESET + YELLOW +"                \t\t      |");

        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);

	System.out.println();
        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
		 System.out.println("             	   |                                                                                                                          |"+RESET);
		System.out.println("            	   |"+RESET+RED+"\t\t\t   					5.Exit" + RESET + YELLOW +"\t\t\t\t\t\t\t|");
		 System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);
		System.out.println();
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Select Food/Snack Option" + RESET);

        int foodChoice = sc.nextInt();
	
        switch (foodChoice) {
            case 1:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Sandwich"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t" + "The Price for "+qty+" Sandwich Quantity is: "+"$"+(qty*5)+ RESET);
	System.out.println();

        break ;

            case 2:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Chips"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty1=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty1+ RESET);
	System.out.println(); 
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t" + "The Price for "+qty1+" Chips Quantity is: "+"$"+(qty1*2)+ RESET);
	System.out.println();

        break ;

            case 3:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Soft-Drink"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);
	int qty2=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty2+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t" + "The Price for"+qty2+" Soft-Drink Quantity is: "+"$"+(qty2*3)+ RESET);
	System.out.println();

        break ;

            case 4:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty3=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty3+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW+ "\t\t\t\t\t\t\t\t" + "The Price for "+qty3+" Water Bottle Quantity is: "+"$"+(qty3*1)+ RESET);
	System.out.println();

        break;

            default:
                    System.out.println(RED + "Returning to the main menu..." + RESET);
		break rev;
        }


	}

	}
	
	if(choice==5) break rev;

	else if(choice ==2){
		System.out.println("Continue....");
		break rev;
	}
	else {
                    System.out.println(RED + "Returning to the main menu..." + RESET);
			break rev;
	}
	
	}
        // Seat selection

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
	
	Choose.choose();

	EconomyClass.displayEconomyFeatures();
	PremiumClass.displayPremiumFeatures();

    }
}
