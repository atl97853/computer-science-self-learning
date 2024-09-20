public class a {

    public static void doStuff(t obj, Integer x) {
        obj.age = obj.age - 100;
        x = x - 10;
    }

    public static void main(String[] args) {
        t objA;
        t objB;
        Integer x = 10;
        objA = new t(234, "Ragnar");
        objB = objA;
        objA = new t(123,"Tohru");

        doStuff(objA, x);
        System.out.println(objA.getAge());
        System.out.println(x);
    }

}