package strings;

public class StringStorage {
    public static void main(String args[]) {
        String str1 = "abc";   // pool
        String str2 = "abc";   // same ref (pool)
        String str3 = new String("abc"); // new object (heap)

        str1 = "xyz";          // new object
        str2 = str2 + "def";   // new object → "abcdef"

        String str4 = "abc";   // reuse pool

        System.out.println(str1); // xyz
        System.out.println(str2); // abcdef
        System.out.println(str3); // abc
        System.out.println(str4); // abc
    }
}