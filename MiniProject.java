import java.util.*;

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
class Credit {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

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



    private static int generateOtp() {
        return 1000 + random.nextInt(9000); // Generates a 4-digit OTP
    }


    public static void cred() {

        Scanner scanner = new Scanner(System.in);

        // Create a User object
        Crenditals crendital = new Crenditals("Anees","7777",7075186108l);

        rev:while (true) {
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
                        + "    	  The User Phone Number is: " + crendital.getPhone() + "     " + RESET + YELLOW+ "\t\t\t\t" + "        |" + RESET);
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
		    System.out.println(GREEN + "\t\t\t\t\t\t\t" + "     Enter the Details to Sign In:" + "\n" + RESET);
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Username " + "\n" + RESET);
                    String inputUsername1 = scanner.nextLine();
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Password " + "\n" + RESET);
                    String inputPassword1 = scanner.nextLine();
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Phone Number " + "\n" + RESET);
                    long inputPhone1 = scanner.nextLong();


		if(crendital.getName().equals(inputUsername1) && crendital.getPassword().equals(inputPassword1) &&  crendital.getPhone() == inputPhone1){
                        System.out.println(BRIGHTCYAN+ "\t\t\t        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..Login successful! Welcome..<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ "" + RESET);
                        break rev; // Exit loop on successful login
		}
	
	 	  else if (crendital.getName() == null ||crendital.getPassword() == null || crendital.getName().equalsIgnoreCase("Anees")|| crendital.getPassword().equalsIgnoreCase("7777")|| crendital.getPhone()==7075186108l ) {
                    System.out.println(MAGENTA + "\t\t\t\t\t\t\t" + "No account found. Please SignUp first.");
                } else {
                    System.out.println(GREEN + "\t\t\t\t\t\t\t" + "     Enter the Details to Sign Up:" + "\n" + RESET);
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Username " + "\n" + RESET);
                    String inputUsername = scanner.nextLine();
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Password " + "\n" + RESET);
                    String inputPassword = scanner.nextLine();
                    System.out.print(GREEN + "\t\t\t\t\t\t\t\t" + "   Enter Phone Number " + "\n" + RESET);
                    long inputPhone = scanner.nextLong();

                    // Generate and validate OTP
                    int generatedOtp = generateOtp();
                    System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t    Generated OTP"+RED+" (Do not share): " +RESET+BRIGHTYELLOW + generatedOtp + RESET);
		    System.out.println();
                    System.out.print(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t" + "      Enter OTP " + "\n" + RESET);
                    int otp = scanner.nextInt();
		    System.out.println();
		    if (generatedOtp == otp && crendital.validate(inputUsername, inputPassword, inputPhone, otp)) {
                        System.out.println(BRIGHTCYAN+ "\t\t\t        >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..Login successful! Welcome..<<<<<<<<<<<<<<<<<<<<<<<<<<<"+ "" + RESET);
                        break; // Exit loop on successful login
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
			   break;
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

                	System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + " Enter Valid Choice!" + RESET);
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

                	System.out.println(RED + "\t\t\t\t\t\t\t\t\t" + " Enter Valid Choice!" + RESET);
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
	Upgrade food = new EcoFood();

	Upgrade Pfood = new PreFood();

	Upgrade Bfood = new BussFood();
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
				 Pfood.displayFeatures();
				 break;
			}
			
			else if(n==3){
				BusinessClass.displayBusinessFeatures();
				 Bfood.displayFeatures();
				break;
			}
			else if(n==4){
				Credit.cred();
				break;
			}
			else{
                System.out.println(RED + "\t\t\t\t\t\t\t" + "       Enter Valid Choice!" + RESET);

			}
		break;
		}
	} 
}


abstract class Upgrade{
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
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t2.Chips \t               1   \t\t  $2 " + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t3.Soft Drink \t               1   \t\t  $3 " + RESET + YELLOW +"                \t\t      |");
	System.out.println("             	   |                                                                                                                          |");
	System.out.println("                   |\t\t            	      " + BRIGHTCYAN + "\t4.Water Bottle \t               1   \t\t  $1 " + RESET + YELLOW +"                \t\t      |");

        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);

	System.out.println();
        System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------");
		 System.out.println("             	   |                                                                                                                          |"+RESET);
		System.out.println("            	   |"+RESET+RED+"\t\t\t   					5.Exit" + RESET + YELLOW +"\t\t\t\t\t\t\t      |");
		 System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);
		System.out.println();
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t"  + "Select Food/Snack Option" + RESET);

        int foodChoice = sc.nextInt();
	
        switch (foodChoice) {
            case 1:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Sandwich"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty+" Sandwich Quantity is: "+"$"+(qty*5)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n1=sc.nextInt();
		if(n1==1){
		User.Pri_Det();
		break rev;
		}
		else if(n1==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
		
        break ;

            case 2:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Chips"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t"  + "Enter the Quantity"+ RESET);

	int qty1=sc.nextInt();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty1+ RESET);
	System.out.println(); 
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty1+" Chips Quantity is: "+"$"+(qty1*2)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n2=sc.nextInt();
		if(n2==1){
		User.Pri_Det();
		break rev;
		}
		else if(n2==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 3:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Soft Drink"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);
	int qty2=sc.nextInt();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty2+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t"   + "The Price for "+qty2+" Soft Drink Quantity is: "+"$"+(qty2*3)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n3=sc.nextInt();
		if(n3==1){
		User.Pri_Det();
		break rev;
		}
		else if(n3==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 4:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty3=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity ais: "+qty3+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty3+" Water Bottle Quantity is: "+"$"+(qty3*1)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n4=sc.nextInt();
		if(n4==1){
		User.Pri_Det();
		break rev;
		}
		else if(n4==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;
            default:
                    System.out.println(RED + "Returning to the main menu..." + RESET);
		break rev;
        }

	
	}

	}
	
	if(choice==5) break rev;

	else if(choice ==2){
			User.Pri_Det();
		break rev;
	}
	else {
                    System.out.println(RED + "Returning to the main menu..." + RESET);
			break rev;
	}
	
	}
       
	
    }
}


class PreFood extends Upgrade {

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
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t"+ "Choose Food/Snack Option" + RESET);

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
		 System.out.println("             	   |                                                                                                                          |"+RESET);
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
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t"  + "Entered Quantity is: "+qty+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty+" Gourmet Sandwich Quantity is: "+"$"+(qty*5)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n1=sc.nextInt();
		if(n1==1){
		User.Pri_Det();
		break rev;
		}
		else if(n1==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 2:
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "You have selected Fruit Platter"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty1=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t"  + "Entered Quantity is: "+qty1+ RESET);
	System.out.println(); 
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty1+" Fruit Platter Quantity is: "+"$"+(qty1*2)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n2=sc.nextInt();
		if(n2==1){
		User.Pri_Det();
		break rev;
		}
		else if(n2==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 3:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Premium Soft Drink"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t"  + "Enter the Quantity"+ RESET);
	int qty2=sc.nextInt();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty2+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t"  + "The Price for "+qty2+" Premium Soft Drink Quantity is: "+"$"+(qty2*3)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n3=sc.nextInt();
		if(n3==1){
		User.Pri_Det();
		break rev;
		}
		else if(n3==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 4:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t"+ "Enter the Quantity"+ RESET);

	int qty3=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty3+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty3+" Water Bottle Quantity is: "+"$"+(qty3*1)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);

		int n4=sc.nextInt();
		if(n4==1){
		User.Pri_Det();
		break rev;
		}
		else if(n4==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;
            default:
                    System.out.println(RED + "Returning to the main menu..." + RESET);
		break rev;
        }


	}

	}
	
	if(choice==5) break rev;

	else if(choice ==2){
		User.Pri_Det();
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



class BussFood extends Upgrade {

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
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t" + "Choose Food/Snack Option" + RESET);

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
		System.out.println("            	   |"+RESET+RED+"\t\t\t   			5.Exit" + RESET + YELLOW +"\t\t\t\t\t\t\t      |");
		 System.out.println("             	   |                                                                                                                          |");
                System.out.println(YELLOW + "                   ----------------------------------------------------------------------------------------------------------------------------"+RESET);
		System.out.println();
        System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t\t\t" + "Select Food/Snack Option" + RESET);

        int foodChoice = sc.nextInt();
	
        switch (foodChoice) {
            case 1:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Gourmet Sandwich"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty=sc.nextInt();
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty+" Gourmet Sandwich Quantity is: "+"$"+(qty*5)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);
		int n1=sc.nextInt();
		if(n1==1){
		User.Pri_Det();
		break rev;
		}
		else if(n1==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		
		}
		else
        break ;
            case 2:
        System.out.println(BRIGHTCYAN +"\t\t\t\t\t\t\t\t\t"  + "You have selected Pasta"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t"  + "Enter the Quantity"+ RESET);

	int qty1=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty1+ RESET);
	System.out.println(); 
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty1+" Pasta Quantity is: "+"$"+(qty1*2)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);

		int n2=sc.nextInt();
		if(n2==1){
		User.Pri_Det();
		break rev;
		}
		else if(n2==3){
		BillGenerator.billgenerator();
		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 3:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Salad"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t"+ "Enter the Quantity"+ RESET);
	int qty2=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty2+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t"  + "The Price for "+qty2+" Salad Quantity is: "+"$"+(qty2*3)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);


		int n3=sc.nextInt();
		if(n3==1){
		User.Pri_Det();
		break rev;
		}
		else if(n3==3){
		BillGenerator.billgenerator();

		User.Pri_Det();

		break rev;
		}
		else
        break ;

            case 4:
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "You have selected Water Bottle"+ RESET);
	System.out.println();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Enter the Quantity"+ RESET);

	int qty3=sc.nextInt();
        System.out.println(BRIGHTCYAN + "\t\t\t\t\t\t\t\t\t" + "Entered Quantity is: "+qty3+ RESET);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "The Price for "+qty3+" Water Bottle Quantity is: "+"$"+(qty3*1)+ RESET);
	System.out.println("\n");
        System.out.println(CYAN + "\t\t\t\t\t\t\t\t  1.Continue        2.Another Snack        3.Confirm"+ RESET);

		int n4=sc.nextInt();
		if(n4==1){
		User.Pri_Det();
		break rev;
		}
		else if(n4==3){
		BillGenerator.billgenerator();

		User.Pri_Det();

		break rev;
		}
		else
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
		break rev;
	}
	else {
                    System.out.println(RED + "Returning to the main menu..." + RESET);
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

    public static void billgenerator() {
        Scanner scanner = new Scanner(System.in);
	System.out.println();
        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t" + "For Confirmation Please Fill Up the Details"+RESET);
	System.out.println();

        System.out.println(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t\t" + "Enter the Number of Items"+RESET);
        int itemCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] itemNames = new String[itemCount];
        double[] itemPrices = new double[itemCount];
        int[] itemQuantities = new int[itemCount];

        for (int i = 0; i < itemCount; i++) {
            System.out.print(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t\t" +"Enter the Name of item " +"\n"+ (i + 1) + ": "+RESET);
            itemNames[i] = scanner.nextLine();

            // Assign price based on item name
	rev:while(true){
            if (itemNames[i].equalsIgnoreCase("Sandwich") || itemNames[i].equalsIgnoreCase("Gourmet Sandwich")) {
                itemPrices[i] = 5.0;
		break rev;
            } else if (itemNames[i].equalsIgnoreCase("Chips") || itemNames[i].equalsIgnoreCase("Fruit Platter") || itemNames[i].equalsIgnoreCase("Pasta")) {
                itemPrices[i] = 2.0;
		break rev;
            } else if (itemNames[i].equalsIgnoreCase("Soft Drink") || itemNames[i].equalsIgnoreCase("Premium Soft Drink") || itemNames[i].equalsIgnoreCase("Salad")) {
                itemPrices[i] = 3.0;
		break rev;
            } else if (itemNames[i].equalsIgnoreCase("Water Bottle")) {
                itemPrices[i] = 3.0;
		break rev;
            } else if (itemNames[i] == null || itemPrices[i] <= 0 || itemQuantities[i] <= 0) {
    			System.out.println("Invalid data for item " + (i + 1));
    			
	    } else {
                System.out.print(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t\t" +"Enter the Items Correctly" + ": "+RESET);
            }
		break rev;
	}
            System.out.print(BRIGHTYELLOW +"\t\t\t\t\t\t\t\t      " +"Enter the quantity of "+ itemNames[i]  +"\n"+ ": "+RESET);
            itemQuantities[i] = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        }

        // Display Bill Summary
	System.out.println(BRIGHTMAGENTA+ "\t\t\t\t\t\t\t    ------------------Bill Summary------------------ " + RESET);
	double totalAmount = 0;
	System.out.println();
	for (int i = 0; i < itemCount; i++) {
    		double itemTotal = itemPrices[i] * itemQuantities[i];
    		totalAmount += itemTotal;

   	 System.out.printf(CYAN + "\t\t\t\t\t\t\t\t%-20s %d x %.2f = %.2f\n" + RESET, 
                      itemNames[i], itemQuantities[i], itemPrices[i], itemTotal);
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
            System.out.println(CYAN + "\t\t\t\t\t\t\t\t\t    OTP Verified Successfully!" + RESET);
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

    public static void Pri_Det() {
	System.out.println();
	System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t    Verification Required " + RESET);
	System.out.println();
        User obj = new User();
        boolean isEmailVerified = false;
        boolean isPhoneVerified = false;

        while (true) {
            System.out.println(BRIGHTMAGENTA + "\t\t\t\t\t\t\t 1. Email Verification\t\t\t2. Phone Number Verification" + RESET);
            System.out.println();

            // Email Verification
            while (!isEmailVerified) {
                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the Email: " + RESET);
                String email = sc.next();
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
                System.out.println(BRIGHTYELLOW + "\t\t\t\t\t\t\t\t\t       Enter the Phone Number: " + RESET);
                String phoneNumber = sc.next();
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

        //Credit.cred();

        
	//Source.source();
	
	Choose.choose();

	EconomyClass.displayEconomyFeatures();
	PremiumClass.displayPremiumFeatures();



    }
}
