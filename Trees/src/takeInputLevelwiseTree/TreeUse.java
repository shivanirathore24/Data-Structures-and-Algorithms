package takeInputLevelwiseTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    public static void printTree(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        //printing as pre-order
        System.out.print(root.data + ": ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();

        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    public static TreeNode<Integer> takeInput() {
        Scanner s = new Scanner(System.in);
        Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();

        System.out.println("Enter the root data:");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        TreeNode<Integer> root = new TreeNode<Integer>(rootData);
        pendingNodes.add(root);

        while (!pendingNodes.isEmpty()) {
            // processing current node level-wise
            TreeNode<Integer> front = pendingNodes.remove();

            System.out.println("Enter the no. of children for: " + front.data);
            int numChild = s.nextInt();

            for (int i = 0; i < numChild; i++) {
                System.out.println("Enter the " + i + "th child data for: " + front.data);
                int childData = s.nextInt();

                TreeNode<Integer> childNode = new TreeNode<>(childData);

                // connecting child with current node
                front.children.add(childNode);

                // adding child for further processing
                pendingNodes.add(childNode);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = takeInput();
        printTree(root);
    }
}

/*
Sample Input:
Enter the root data:
4
Enter the no. of children for: 4
3
Enter the 0th child data for: 4
2
Enter the 1th child data for: 4
3
Enter the 2th child data for: 4
1
Enter the no. of children for: 2
0
Enter the no. of children for: 3
2
Enter the 0th child data for: 3
5
Enter the 1th child data for: 3
6
Enter the no. of children for: 1
0
Enter the no. of children for: 5
0
Enter the no. of children for: 6
0


Tree Structure:
    4
 /  |  \
2   3   1
   / \
  5   6
*/

/*
Sample Output:
4: 2 3 1
2:
3: 5 6
5:
6:
1:
*/