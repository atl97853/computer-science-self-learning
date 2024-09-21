/**
 * Compilation: javac HelloGoodbye.java 
 * Execution: java HelloGoodbye
 * 
 * Command-line arguments. Write a program HelloGoodbye.java that takes two names as command-line arguments and 
 * prints hello and goodbye messages as shown below (with the names for the hello message in the same order as the 
 * command-line arguments and with the names for the goodbye message in reverse order).
 * 
 * % java HelloGoodbye
 * Hello Kevin and Bob.
 * Goodbye Bob and Kevin.
 * 
 * \nHello Alejandra and Bahati.
 * Goodbye Bahati and Alejandra.
 */

import java.util.Scanner; // Import the Scanner class

public class HelloGoodbye {

    public static String helloBye() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter person1: ");
        String person1 = keyboard.nextLine();
        System.out.println("Enter person2: ");
        String person2 = keyboard.nextLine();
        return "Hello " + person1 + " and " + person2 + "\nGoodbye " + person1 + " and " + person2;
    }

    public static void main(String[] args) {
        System.out.println(helloBye());
    }
}