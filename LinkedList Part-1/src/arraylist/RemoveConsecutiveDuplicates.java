package arraylist;
import java.util.ArrayList;

public class RemoveConsecutiveDuplicates {
	public static ArrayList<Integer> removeConsecutiveDuplicates(int arr[])
	{
		ArrayList<Integer> result = new ArrayList<>();
		if(arr.length == 0) return result;  // handle empty array
		result.add(arr[0]);  // first element always added

		for(int i = 1; i < arr.length; i++)
		{
			// add only if different from previous element
			if(arr[i] != arr[i-1])
			{
				result.add(arr[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = {10, 10, 20, 20, 20, 30, 40, 10};
		ArrayList<Integer> result = removeConsecutiveDuplicates(arr);

		for(int i = 0; i < result.size(); i++)
		{
			System.out.println(result.get(i));
		}
		// 10 20 30 40 10
	}
}