package strings;

public class StringComparision {
    public static void main(String args[]) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = new String("abc");

        // == → reference, equals() → content
        System.out.println(str1 == str2); // true
        System.out.println(str1 == str3); // false

        if (str1.equals(str3)) {
            System.out.println("Both are equal");
        } else {
            System.out.println("Both are not equal");
        }
    }
}