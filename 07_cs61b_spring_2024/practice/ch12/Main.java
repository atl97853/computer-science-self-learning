public class Main {
    public static void main(String[] args) {
        /** Creating the ArraySet. */
        ArraySet<String> s = new ArraySet<>();
        s.add("Tokyo");
        s.add("Lagos");
        // s.add(null);
        System.out.println(s.contains("Tokyo")); // true
        System.out.println(s.size());
        /** Implementing the Iterator interface. */
        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        //Iterator<Integer> aseer = aset.iterator();
        /** Trying ugly iteration. */
        // while (aseer.hasNext()) {
        //     int i = aseer.next();
        //     System.out.println(i);
        // }

        /** Trying "nice" iteration. */
        for (int i : aset) {
            System.out.println(i);
        }
        /** Object methods. */
        System.out.println(aset.toString()); 
    }
}