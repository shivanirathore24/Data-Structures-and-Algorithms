package rehashing;

public class MapUse {
    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        for (int i = 0; i < 20; i++) {
            map.insert("abc" + i, i + 1);
            System.out.println(map.loadFactor());
        }

        map.removeKey("abc3");
        map.removeKey("abc7");

        for (int i = 0; i < 20; i++) {
            System.out.println("abc" + i + ":" + map.getValue("abc" + i));
        }
    }
}

/*
Sample Output:
0.2
0.4
0.6
Rehashing if loadFactor is greater than 0.7 :
...

abc0:1
abc1:2
abc2:3
abc3:null
abc4:5
abc7:null
...
*/