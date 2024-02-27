package gen;
import java.util.Objects;
import java.util.Scanner;
public class Generator {
    Alphabet alpha;
    public static Scanner keyboard ;

    public  Generator (Scanner scanner){
        keyboard = scanner;
    }
    public Generator (boolean hasUpper, boolean hasLower, boolean hasDigits, boolean hasSymbol){
        alpha = new Alphabet( hasUpper, hasLower, hasDigits, hasSymbol );
    }

    public void mainLoop (){
        System.out.println("Welcome to this password services :)");
        printMenu ();
        String userOption = "-1";

        while(!userOption.equals( "4" )){
            userOption=keyboard.next();

            switch (userOption){
                case "1" ->{
                    requestPassword ();
                    printMenu();
                }
                case "2"->{
                    checkPassword();
                    printMenu();
                }
                case "3"->{
                    printUsefulInfos();
                    printMenu();
                }
                case "4"->{
                    printQuitMessage();
                }
            }
        }

    }

    private void requestPassword() {
        boolean includeUpper = false;
        boolean includeLower = false;
        boolean includeDigit = false;
        boolean includeSymbol = false;

        boolean correctParmas ;

        System.out.println();
        System.out.println("Hello, welcome to the Password Generator :) answer"
                + " the following questions by Yes or No \n");

        do{
            String input;
            correctParmas = false;

            do{
                System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            }while (!input.equalsIgnoreCase( "Yes" ) && !input.equalsIgnoreCase( "No" ));
            if(isInclude( input )) includeLower = true;

            do {
                System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            if(isInclude( input )) includeUpper = true;

            do {
                System.out.println("Do you want Digitis \"1234...\" to be used? ");
                input = keyboard.next();
                PasswordRequestError( input );
            }while (!input.equalsIgnoreCase( "Yes" ) && !input.equalsIgnoreCase( "No" ));
            if(isInclude( input )) includeDigit = true;

            do {
                System.out.println( "Do you want symbols \"!@#$...\" to be used?" );
                input = keyboard.next();
                PasswordRequestError( input );
            } while (!input.equalsIgnoreCase( "Yes" ) && !input.equalsIgnoreCase( "No" ));
            if(isInclude( input )) includeSymbol = true;

            //No options selected
            if(!includeDigit && !includeLower && !includeUpper && !includeSymbol){
                System.out.println("You have selected no characters to generate your " +
                        "password, at least one of your answers should be Yes\n");
                correctParmas=true;
            }
    }while(correctParmas);

        System.out.println("Now insert password's length");
        int length = keyboard.nextInt();

        final Generator gen = new Generator( includeUpper, includeLower, includeDigit, includeSymbol );
        final Password pass = gen.GeneratePassword (length);

        System.err.println("Your generated password -> " + pass);
    }

    private Password GeneratePassword(int length) {
        final StringBuilder sb = new StringBuilder();
        final int alphabetLen = alpha.getAlphabet().length();

        int max = alphabetLen-1;
        int min = 0;
        int range = max-min+1;

        for (int i = 0; i<length; i++){
            int index = (int) (Math.random()*range)+min;
            sb.append(alpha.getAlphabet().charAt(index));
        }

        return new Password( sb.toString() );
    }

    private void printUsefulInfos (){
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software " +
                "systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number " +
                "sequences,\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the " +
                "aforementioned weak components");
    }

    private boolean isInclude(String input) {
        return input.equalsIgnoreCase( "Yes" );
    }

    private void PasswordRequestError(String str) {
        if(!str.equalsIgnoreCase( "Yes" ) && !str.equalsIgnoreCase( "No" )){
            System.out.println("You have entered something incorrect let's go over it again \n");
        }
    }

    private void checkPassword (){
        String input ;
        System.out.println("\nEnter your password:");
        input= keyboard.next();

        final Password password = new Password( input );

        System.out.println(password.CalculatePasswordStrength());
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }
    private void printQuitMessage() {
        System.out.println("Closing the program bye bye!");
    }
}
