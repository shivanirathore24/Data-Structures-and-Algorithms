package genericmethods;

public class Print {
    // generic method → works for any type
    public static <T> void printArray(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        printArray(arr);
        // 1 2 3 4 5


        String arrS[] = new String[5];
        for (int i = 0; i < arrS.length; i++) {
            arrS[i] = "shiv";
        }
        printArray(arrS);
        // shiv shiv shiv shiv shiv


        Vehicle v[] = new Vehicle[5];

        // object array → default values are null
        printArray(v);
        // null null null null null

        for (int i = 0; i < v.length; i++) {
            v[i] = new Vehicle();
        }

        // now references point to objects
        printArray(v);
        // genericmethods.Vehicle@<hashcode> ...
    }
}