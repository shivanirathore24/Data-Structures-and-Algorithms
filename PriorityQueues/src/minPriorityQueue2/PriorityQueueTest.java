package minPriorityQueue2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Problem Statement:
Test Min Priority Queue implementation.
*/

public class PriorityQueueTest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        PriorityQueue pq = new PriorityQueue();

        System.out.println("Commands:");
        System.out.println("1 number -> insert element");
        System.out.println("2 -> getMin");
        System.out.println("3 -> removeMin");
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
                    try {
                        System.out.println(pq.getMin());
                    }
                    catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;

                case 3:
                    try {
                        System.out.println(pq.removeMin());
                    }
                    catch (PriorityQueueException e) {
                        System.out.println(Integer.MIN_VALUE);
                        return;
                    }
                    break;

                case 4:
                    System.out.println(pq.size());
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
2 -> getMin
3 -> removeMin
4 -> getSize
5 -> isEmpty
-1 -> stop


Sample Input 1:
1 3     // insert 3
1 4     // insert 4
1 63    // insert 63
1 21    // insert 21
1 9     // insert 9
2       // print minimum element
3       // remove and print minimum element
1 7     // insert 7
3       // remove and print minimum element
4       // print size
5       // check queue empty or not
3       // remove and print minimum element
3       // remove and print minimum element
-1      // stop

Sample Output 1:
3       // getMin()
3       // removeMin()
4       // removeMin()
4       // size
false   // isEmpty()


Sample Input 2:
1 3     // insert 3
1 4     // insert 4
1 63    // insert 63
1 21    // insert 21
1 9     // insert 9
2       // print minimum element
3       // remove and print minimum element
1 7     // insert 7
2       // print minimum element
3       // remove and print minimum element
2       // print minimum element
3       // remove and print minimum element
3       // remove and print minimum element
-1      // stop

Sample Output 2:
3       // getMin()
3       // removeMin()
4       // getMin()
4       // removeMin()
7       // getMin()
7       // removeMin()
9       // removeMin()
*/