package assignments;
import java.util.Stack;

/*
Problem Statement:
Given an array of stock prices, calculate the span for each day.

Span = number of consecutive days before current day
(including today) where price was less than or equal to current price.
*/

public class StockSpan {
    // O(n)
    public static int[] stockSpan(int[] price)
    {
        Stack<Integer> stk = new Stack<>();   // store indices
        int n = price.length;

        int[] output = new int[n];

        stk.push(0);          // first index
        output[0] = 1;        // span of first day

        for (int i = 1; i < n; ++i)
        {
            while (!stk.isEmpty() && price[stk.peek()] < price[i])
            {
                stk.pop();   // remove smaller elements
            }

            if (stk.isEmpty())
            {
                output[i] = i + 1;
            }
            else
            {
                output[i] = i - stk.peek();
            }

            stk.push(i);   // push current index
        }
        return output;
    }

    public static void main(String[] args)
    {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int[] ans = stockSpan(price);

        for (int i = 0; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");   // 1 1 1 2 1 4 6
        }
    }
}

/*
Time Complexity:
O(n)
- Each index pushed and popped at most once

Space Complexity:
O(n)
- Stack stores indices

Explanation:
- Use stack to track previous greater elements
- Remove smaller elements for each day
- If stack empty → span = i+1
- Else → span = distance from last greater index
*/

/*
Sample Input 1:
100 80 60 70 60 75 85

Sample Output 1:
1 1 1 2 1 4 6

Sample Input 2:
10 4 5 90 120 80

Sample Output 2:
1 1 2 4 5 1
*/