package assignments;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Problem Statement:
Find time required for kth person to get the ticket.
*/

public class BuyTicket {
    // O(n log n)
    public static int buyTicket(int input[], int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Max Priority Queue
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        // insert all persons
        for (int i = 0; i < input.length; i++) {
            queue.add(i);
            pq.add(input[i]);
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int frontIndex = queue.poll();

            // highest priority person gets ticket
            if (input[frontIndex] == pq.peek()) {
                pq.poll();
                time++;

                // kth person got ticket
                if (frontIndex == k) {
                    return time;
                }
            }

            // move person to end of queue
            else {
                queue.add(frontIndex);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        int arr[] = {3, 9, 4};
        int k = 2;
        System.out.println(buyTicket(arr, k)); // 2
    }
}

/*
Time Complexity:
O(n log n)
- Priority Queue operations take O(log n)

Space Complexity:
O(n)
- Queue and Priority Queue store all persons

Explanation:
- Queue maintains order of persons
- Max Priority Queue stores highest priority
- If front person has highest priority,
  give ticket and increase time
- Otherwise move person to end of queue
*/

/*
Sample Input 1:
3 9 4
2

Queue Process:
3 9 4 -> 9 4 3
9 gets ticket -> time = 1
4 gets ticket -> time = 2

Sample Output 1:
2


Sample Input 2:
1 3 5 2 4
3

Queue Process:
1 3 5 2 4 -> 3 5 2 4 1
3 5 2 4 1 -> 5 2 4 1 3
5 gets ticket -> time = 1
4 gets ticket -> time = 2
3 gets ticket -> time = 3
2 gets ticket -> time = 4 (You)

Sample Output 2:
4
*/