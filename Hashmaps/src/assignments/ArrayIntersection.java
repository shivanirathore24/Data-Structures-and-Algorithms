package assignments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
Problem Statement:
Print the intersection of two arrays including duplicate elements.
The intersection elements should be printed in ascending order.
*/

public class ArrayIntersection {
	// O(n + m log m)
	public static void printIntersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();

		// store frequency of elements of arr1
		for (int i = 0; i < arr1.length; i++) {
			if (map.containsKey(arr1[i])) {
				int value = map.get(arr1[i]);
				map.put(arr1[i], value + 1);
			} else {
				map.put(arr1[i], 1);
			}
		}

		ArrayList<Integer> output = new ArrayList<>();

		// find common elements
		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i])) {
				int freq = map.get(arr2[i]);

				if (freq > 0) {
					output.add(arr2[i]);
					map.put(arr2[i], freq - 1);
				}
			}
		}
		// sort intersection elements
		Collections.sort(output);

		// print output
		for (int i : output) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		int arr1[] = {1, 4, 5, 2, 2, 3, 6, 5, 3, 2};
		int arr2[] = {0, 2, 3, 2, 6, 6, 5, 1};
		printIntersection(arr1, arr2); // 1 2 2 3 5 6
	}
}

/*
Time Complexity:
O(n + m log m)
- HashMap traversal takes O(n + m) and sorting takes O(m log m)

Space Complexity:
O(n)
- HashMap stores frequencies of array elements

Explanation:
- Store frequency of first array elements in HashMap
- Traverse second array and check common elements
- Reduce frequency after every match
- Sort and print the intersection elements
*/

/*
Sample Input 1:
arr1 = {1, 4, 5, 2, 2, 3, 6, 5, 3, 2}
arr2 = {0, 2, 3, 2, 6, 6, 5, 1}

Sample Output 1:
1 2 2 3 5 6

Sample Input 2:
arr1 = {7, 8, 3, 3, 9, 1, 7}
arr2 = {3, 7, 7, 10, 1}

Sample Output 2:
1 3 7 7
*/