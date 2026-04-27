package assignments.dynamicarray;

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();

        for (int i = 1; i < 100; i++) {
            d.add(100 + i);
        }

        System.out.println(d.size()); // 99
        System.out.println(d.get(2)); // 103

        d.set(3, 170);
        System.out.println(d.get(3)); // 170

        while (!d.isEmpty()) {
            System.out.println(d.removeLast()); // elements in reverse
            System.out.println("size- " + d.size());
        }
    }
}

