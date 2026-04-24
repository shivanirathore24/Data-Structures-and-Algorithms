package strings;

public class PrintAllSubstrings {
    public static void printSubstrings(String str) {
        /* start to end approach
        for (int start = 0; start < str.length(); start++) {
            // print all substrings starting at index 'start'
            for (int end = start; end < str.length(); end++) {
                System.out.println(str.substring(start, end + 1));
            }
        } */

        // length-based approach
        for (int len = 1; len <= str.length(); len++) {
            // print all substrings of given length 'len'
            for (int start = 0; start <= str.length() - len; start++) {
                int end = start + len - 1;
                System.out.println(str.substring(start, end + 1));
            }
        }
    }

    public static void main(String args[]) {
        String str = "shiv";
        printSubstrings(str);
    }
}