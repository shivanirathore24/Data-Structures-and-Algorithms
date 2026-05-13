package inbuilt_hashmap;
import java.util.HashMap;
import java.util.Set;

/*
Problem Statement:
Perform basic operations using inbuilt HashMap in Java.
*/

public class InbuiltMapUse {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // insert  -- O(1)
        map.put("shiv", 24);
        map.put("mahi", 7);
        map.put("abhi", 13);

        // size  -- O(1)
        map.put("shiv", 24); // update existing key
        System.out.println(map.size()); // 3

        // search  -- O(1)
        System.out.println(map.containsKey("abc")); // false

        if (map.containsKey("shiv")) {
            System.out.println("Shiv Shakti"); // Shiv Shakti
        }

        // getValue  -- O(1)
        int v = 0;

        if (map.containsKey("shiv")) {
            v = map.get("shiv");
        }

        System.out.println(v); // 24

        // int v1 = map.get("abc"); // Error : NullPointerException
        // System.out.println(v1);

        int v1 = 0;

        // avoid NullPointerException
        if (map.containsKey("abc")) {
            v1 = map.get("abc");
        }

        System.out.println(v1); // 0

        // remove  -- O(1)
        map.remove("abc");
        map.remove("abhi");

        // iterate  -- O(n)
        Set<String> keys = map.keySet();

        for (String s : keys) {
            System.out.println(s);
        }

        // map.containsValue()  -- O(n)
        // map.containsKey()    -- O(1)
    }
}

/*
Time Complexity:
O(1)
- Insert, remove, search and get operations take constant time on average

Space Complexity:
O(n)
- HashMap stores n key-value pairs

Explanation:
- HashMap stores elements in key-value pairs
- Duplicate keys overwrite old values
- containsKey() prevents NullPointerException
- keySet() is used to iterate through keys
*/

/*
Sample Output:
3
false
Shiv Shakti
24
0
shiv
mahi
*/