public class HelloWorld {
    static public void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String myText = keyboard.nextLine("Enter your name: ");
        System.out.print(myText);
    }
}