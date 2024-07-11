
// import java.util.Scanner; // Import the Scanner class 

// /**
//  * see https://www.w3schools.com/java/java_user_input.asp
//  */

// class Main {

//     public static void userInOut() {
//         Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//         System.out.println("Enter username");

//         String userName = myObj.nextLine();  // Read user input
//         System.out.println("Username is: " + userName);  // Output user input
//     }

//   public static void main(String[] args) {
//     URL hp = new URL("http://www.mit.edu");
//     String mitHomepage = new Scanner(hp.openStream(), "UTF-8").useDelimiter("\\A").next();
//     System.out.println(mitHomepage);
//   }
// }


/**
 * Enums review for Fail fast example
 * 
 */

// public class Main {

//     public enum Month {
//         JANUARY, FEBRUARY,
//     }

//     public static void main(String[] args) {
//         Month x = Month.FEBRUARY;
//         System.out.println(x);
//   }
// }

// recursive method using local variables and inmutable parameters

public class Main {
    public static int recursiveF(final int x) {
        System.out.println("in" + x);
        if (x <= 0 ) {
            return x;
        } else {
            int y = x - 1;
            System.out.println("out" + y);
            return recursiveF(y);
        }
    }
    public static void main(String[] args) {
        recursiveF(3);
    }
}