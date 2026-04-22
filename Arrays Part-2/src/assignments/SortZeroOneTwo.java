package assignments;

/*
Problem Statement:
You are given an array containing only 0s, 1s and 2s.
Sort the array in a single scan without using extra space.
*/

public class SortZeroOneTwo {
	public static void printArray(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void sort012(int[] arr) {
		int nextZero = 0;
		int i = 0;
		int nextTwo = arr.length - 1;

		while(i <= nextTwo) {
			if(arr[i] == 0) {
				int temp = arr[i];
				arr[i] = arr[nextZero];
				arr[nextZero] = temp;
				i++;
				nextZero++;
			}
			else if (arr[i] == 2) {
				int temp = arr[i];
				arr[i] = arr[nextTwo];
				arr[nextTwo] = temp;
				nextTwo--;
			}
			else {
				i++;
			}
		}
	}

	public static void main(String[] args) {
		int arr [] = {0, 1, 2, 0, 2, 0, 1};
		sort012(arr);
		printArray(arr);
	}
}

/*
Sample Input 1:
0 1 2 0 2 0 1

Sample Output 1:
0 0 0 1 1 2 2

Sample Input 2:
2 2 0 1 1

Sample Output 2:
0 1 1 2 2
*/