package assignments;
import java.util.ArrayList;
import java.util.HashMap;

/*
Problem Statement:
Remove duplicate elements from an array using HashMap.
*/

public class RemoveDuplicates {
	// O(n)
	private static ArrayList<Integer> removeDuplicates(int[] arr) {
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			// skip duplicate element
			if (map.containsKey(arr[i])) {
				continue;
			}

			output.add(arr[i]); // add unique element
			map.put(arr[i], true);
		}
		return output;
	}

	public static void main(String[] args) {
		int arr[] = {1, 3, 2, 2, 3, 1, 6, 2, 5};
		ArrayList<Integer> output = removeDuplicates(arr);
		System.out.println(output); // [1, 3, 2, 6, 5]
	}
}

/*
Time Complexity:
O(n)
- Each element is visited once

Space Complexity:
O(n)
- HashMap stores unique elements

Explanation:
- Traverse the array element by element
- If element already exists in HashMap, skip it
- Otherwise add it to output list and mark visited
*/

/*
Sample Input 1:
1 3 2 2 3 1 6 2 5

Sample Output 1:
[1, 3, 2, 6, 5]

Sample Input 2:
4 5 4 2 2 8 1 5 9

Sample Output 2:
[4, 5, 2, 8, 1, 9]
*/