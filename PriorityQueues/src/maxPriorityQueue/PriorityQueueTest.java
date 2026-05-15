package maxPriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Problem Statement:
Test Max Priority Queue implementation.
*/

public class PriorityQueueTest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue pq = new PriorityQueue();

        System.out.println("Commands:");
        System.out.println("1 number -> insert element");
        System.out.println("2 -> getMax");
        System.out.println("3 -> removeMax");
        System.out.println("4 -> getSize");
        System.out.println("5 -> isEmpty");
        System.out.println("-1 -> stop");

        while (true) {
            st = new StringTokenizer(br.readLine());
            int choice = Integer.parseInt(st.nextToken());

            if (choice == -1) {
                break;
            }

            switch (choice) {
                case 1:
                    int element = Integer.parseInt(st.nextToken());
                    pq.insert(element);
                    break;

                case 2:
                    System.out.println(pq.getMax());
                    break;

                case 3:
                    System.out.println(pq.removeMax());
                    break;

                case 4:
                    System.out.println(pq.getSize());
                    break;

                case 5:
                    System.out.println(pq.isEmpty());
            }
        }
    }
}

/*
Commands:
1 number -> insert element
2 -> getMax
3 -> removeMax
4 -> getSize
5 -> isEmpty
-1 -> stop

Sample Input 1:
1 3     // insert 3
1 4     // insert 4
1 63    // insert 63
1 21    // insert 21
1 9     // insert 9
2       // print maximum element
3       // remove and print maximum element
1 7     // insert 7
2       // print maximum element
3       // remove and print maximum element
2       // print maximum element
-1      // stop

Sample Output 1:
63      // getMax()
63      // removeMax()
21      // getMax()
21      // removeMax()
9       // getMax()


Sample Input 2:
1 10    // insert 10
1 50    // insert 50
1 30    // insert 30
2       // print maximum element
4       // print size
5       // check queue empty or not
3       // remove and print maximum element
2       // print maximum element
-1      // stop

Sample Output 2:
50      // getMax()
3       // size
false   // isEmpty()
50      // removeMax()
30      // getMax()
*/