package generics;

// Generics → type-safe reusable code using reference types (wrapper classes for primitives)
public class PairUse {
    public static void main(String[] args) {
        Pair<String> pS = new Pair<>("shiv", "shakti");
        System.out.println(pS.getFirst() + " " + pS.getSecond()); // shiv shakti

        pS.setFirst("shiv");
        System.out.println(pS.getFirst() + " " + pS.getSecond()); // shiv shakti

        // Pair<Integer> pI = new Pair<Integer>(10, 20);
        Pair<Integer> pI = new Pair<>(10, 20);
        System.out.println(pI.getFirst() + " " + pI.getSecond()); // 10 20

        Pair<Double> pD = new Pair<>(10.1, 24.6);
        System.out.println(pD.getFirst() + " " + pD.getSecond()); // 10.1 24.6
    }
}