/**
 * Task 4: Dessert.java
 * */

public class Dessert {

    int flavor;
    int price;
    private static int numDesserts;

    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        ++numDesserts;
    }

    public void printDessert() {
        System.out.println(this.flavor + " " + this.price + " " + numDesserts);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
