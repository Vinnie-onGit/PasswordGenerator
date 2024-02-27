package gen;

import java.util.Scanner;

public class Main {
    private static final Scanner keyboard = new Scanner( System.in );
    public static void main(String[] args) {
        Generator gen =  new Generator( keyboard );
        gen.mainLoop();
        keyboard.close();
    }
}