public class MyClass {
    public static final String MY_NAME = "Atl";
    private String name;
    private int id;
    public MyClass(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public static void helloWorld(String name){
        System.out.println("Hello World " + name);
    }
}