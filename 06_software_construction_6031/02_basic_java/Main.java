public class Main {
    static public void main(String[] args) {
        System.out.println(MyClass.MY_NAME);
        MyClass s = new MyClass("Ragnar", 00);
        System.out.println(s.getName());
        MyClass.helloWorld(s.getName());
    }
}



