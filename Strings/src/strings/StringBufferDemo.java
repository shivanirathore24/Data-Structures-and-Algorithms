package strings;

public class StringBufferDemo {
    public static void main(String args[]) {
        // mutable string
        java.lang.StringBuffer str = new StringBuffer("abc");

        str.setCharAt(0, 'd'); // replace → dbc
        str.append("def");     // append → dbcdef

        System.out.println(str + " " + str.length()); // dbcdef 6

        // immutable string
        String s = "s";
        for (int i = 0; i < 5; i++) {
            s = s + 'h'; // new object each time
        }
        // final → shhhhh
    }
}