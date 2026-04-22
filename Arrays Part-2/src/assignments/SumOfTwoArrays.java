package assignments;

/*
Problem Statement:
You are given two arrays representing numbers.
Find their sum and store the result in an output array.
*/

public class SumOfTwoArrays {
	public static void printArray(int [] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void sumOfTwoArrays(int [] arr1, int [] arr2, int [] output) {
		int i = arr1.length - 1;
		int j = arr2.length - 1;
		int k = output.length - 1;
		int carry = 0;

		while(i >= 0 && j >= 0) {
			int sum = arr1[i] + arr2[j] + carry;
			output[k] = sum % 10;
			carry = sum / 10;
			i--;
			j--;
			k--;
		}

		while(i >= 0) {
			int sum = arr1[i] + carry;
			output[k] = sum % 10;
			carry = sum / 10;
			i--;
			k--;
		}

		while(j >= 0) {
			int sum = arr2[j] + carry;
			output[k] = sum % 10;
			carry = sum / 10;
			j--;
			k--;
		}
		output[0] = carry;
	}

	public static void main(String[] args) {
		int arr1[] = {9, 9, 9, 1, 3, 4};
		int arr2[] = {2, 0, 6, 6};
		int output[] = new int[1 + Math.max(arr1.length, arr2.length)];
		sumOfTwoArrays(arr1, arr2, output);
		printArray(output);
	}
}

/*
Sample Input 1:
arr1 = 6 2 4
arr2 = 7 5 6

Sample Output 1:
1 3 8 0

Sample Input 2:
arr1 = 8 5 2
arr2 = 1 3

Sample Output 2:
0 8 6 5
*/