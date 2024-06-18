// public class Main {
//     static public void main(String[] args) {
//         System.out.println(MyClass.MY_NAME);
//         MyClass s = new MyClass("Ragnar", 00);
//         System.out.println(s.getName());
//         MyClass.helloWorld(s.getName());
//     }
// }

// this example passes the compile check but no the runtime check
// public class Main {
//     static public void main(String[] args) {
//         Integer[] list = new Integer[]{
//             1,2,3,4,5
//         };
//         for (int i = 1; i <= 6; i++) {
//             System.out.println(list[i - 1]);
//         } 
//     }
// }


// public class Main {
//     static public void main(String[] args) {
//         MyClass p = new MyClass(92045, 186);
//         System.out.println(p.getId());
//         System.out.println(p.getAge());
//         p.setAge(563);
//         System.out.println(p.getAge());
//     }
// }

// import java.util.*;

// public class Main {
//     static public void main(String[] args) {
//         List<String> list = new ArrayList<>(List.of("A","B"));
//         for (String item : list) {
//              System.out.println(item);
//         }
//         Set<Integer> numbers = new HashSet<>(List.of(1,2));
//         for (Integer item : numbers) {
//              System.out.println(item);
//         }
//         // List<String> list = new ArrayList<>(List.of("A","B"));
//         // for (String item : list) {
//         //      System.out.println(item);
//         // }
//     }
// }


public class Main {
    public enum Month { 
        JANUARY, FEBRUARY, MARCH, APRIL, 
        MAY, JUNE, JULY, AUGUST, 
        SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    }
    static public void main(String[] args) {
        Month month; // initialize variable
        month = Month.MARCH; // declare 
        Month nov = Month.NOVEMBER; // initialize and declare 
        System.out.println(nov);
    }
}