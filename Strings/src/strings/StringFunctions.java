package strings;

public class StringFunctions {
    public static void main(String args[]) {
        char arr[] = {'C', 'o', 'd', 'i', 'n', 'g'};
        String str1 = "Coding";
        String str2 = " is fun";
        String str3 = "Ceding";

        System.out.println(str1.contains("ing")); // true

        str1 = str1.concat(str2);
        System.out.println(str1); // Coding is fun

        System.out.println(str1.equals(str3)); // false

        System.out.println(str1.compareTo(str3));
        // positive value (≈ 10)

        System.out.println(str1.charAt(2)); // d
        System.out.println(str1.charAt(6)); // (space)

        // String substr = str1.substring(1,7);
        // Runtime Error → StringIndexOutOfBoundsException

        String substr = str1.substring(1,6);
        System.out.println(substr); // oding

        System.out.println(substr.length()); // 5
    }
}