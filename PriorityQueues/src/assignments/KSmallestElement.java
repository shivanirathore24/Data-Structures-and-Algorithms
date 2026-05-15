package assignments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Problem Statement:
Find k smallest elements from the array using Priority Queue.
*/

public class KSmallestElement {
	// O(n log k)
	public static ArrayList<Integer> printKSmallest(int n, int[] arr, int k) {
		// making Max Priority Queue
		PriorityQueue<Integer> pq =
				new PriorityQueue<Integer>(Collections.reverseOrder());

		// insert first k elements
		for (int i = 0; i < k; i++) {
			pq.add(arr[i]);
		}

		// process remaining elements
		for (int i = k; i < n; i++) {
			if (pq.peek() > arr[i]) {
				pq.poll();
				pq.add(arr[i]);
			}
		}

		ArrayList<Integer> output = new ArrayList<>();

		// store k smallest elements
		while (!pq.isEmpty()) {
			output.add(pq.poll());
		}
		return output;
	}

	public static void main(String[] args) {
		int[] arr = {4, 1, 6, 3, 7, 2, 9, 8};
		int k = 3;

		ArrayList<Integer> output =
				printKSmallest(arr.length, arr, k);

		for (int i : output) {
			System.out.println(i);
		} // 3 2 1
	}
}

/*
Time Complexity:
O(n log k)
- Each insertion/removal in Priority Queue takes O(log k)

Space Complexity:
O(k)
- Priority Queue stores only k elements

Explanation:
- Maintain Max Priority Queue of size k
- Largest among k smallest elements stays at root
- Replace root if smaller element is found
- Remaining elements in heap are k smallest elements
*/

/*
Sample Input 1:
2 12 9 16 10 5 3 20 25 11 1 8 6
4

Sample Output 1:
1
2
3
5


Sample Input 2:
4 1 6 3 7 2 9 8
3

Sample Output 2:
1
2
3
*/