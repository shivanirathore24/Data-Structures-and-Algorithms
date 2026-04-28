package chainedgenericpairs;

// nested generics → generic inside another generic
public class PairUse {
    public static void main(String[] args) {
        Pair<String, Integer> pInner = new Pair<>("abc", 100);

        Pair<Pair<String, Integer>, String> p = new Pair<>();
        p.setFirst(pInner);
        p.setSecond("Shiv");

        // avoid printing object reference → print meaningful values
        System.out.println(p.getSecond()); // Shiv
        System.out.println(p.getFirst().getFirst()); // abc
        System.out.println(p.getFirst().getSecond()); // 100
    }
}