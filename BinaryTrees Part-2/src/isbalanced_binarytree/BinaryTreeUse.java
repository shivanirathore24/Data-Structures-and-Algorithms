package isbalanced_binarytree;
import java.util.Scanner;

/*
Problem Statement:
For a given Binary Tree, check whether it is height balanced.
A tree is balanced if for every node, the difference of heights of left and right subtree is at most 1.
*/

public class BinaryTreeUse {
    // O(n)
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data");   // root input
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData);   // left input
            } else {
                System.out.println("Enter right child of " + parentData);  // right input
            }
        }
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();   // read value

        if (rootData == -1) {
            return null;   // no node
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeTreeInputBetter(false, rootData, true);   // build left
        root.right = takeTreeInputBetter(false, rootData, false); // build right

        return root;
    }

    // O(n)
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        System.out.print(root.data + ": ");   // print node
        if (root.left != null) {
            System.out.print("L" + root.left.data + ", ");   // left
        }
        if (root.right != null) {
            System.out.print("R" + root.right.data);   // right
        }
        System.out.println();

        printTreeDetailed(root.left);   // left subtree
        printTreeDetailed(root.right);  // right subtree
    }

    // O(n)
    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;   // base case
        }

        int leftHeight = height(root.left);    // left height
        int rightHeight = height(root.right);  // right height

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // O(n^2)
    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;   // empty tree is balanced
        }

        int leftHeight = height(root.left);     // height of left subtree
        int rightHeight = height(root.right);   // height of right subtree

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;   // current node unbalanced
        }

        // check balance of subtrees
        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;
    }

    // O(n)
    public static BalancedTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            BalancedTreeReturn ans = new BalancedTreeReturn();
            ans.height = 0;
            ans.isBalanced = true;
            return ans;   // base case
        }

        BalancedTreeReturn leftOutput = isBalancedBetter(root.left);   // left result
        BalancedTreeReturn rightOutput = isBalancedBetter(root.right); // right result

        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        // check current node balance using height + subtree results
        boolean isBal = Math.abs(leftOutput.height - rightOutput.height) <= 1
                && leftOutput.isBalanced
                && rightOutput.isBalanced;

        BalancedTreeReturn ans = new BalancedTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;

        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);

        System.out.println("Is balanced ? : " + isBalanced(root));           // e.g. true / false
        System.out.println("Is balanced ? : " + isBalancedBetter(root).isBalanced); // e.g. true / false
    }
}

/*
Time Complexity:
- isBalanced → O(n^2)
- isBalancedBetter → O(n)

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Basic method recomputes height for each node
- Better method returns height + balance together
*/

/*
Sample Input 1:
1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

Tree 1:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Sample Output 1:
Is balanced ? : true
Is balanced ? : true


Sample Input 2:
1 2 3 4 -1 -1 -1 -1 -1

Tree 2:
     1
    /
   2
  /
 3
/
4

Sample Output 2:
Is balanced ? : false
Is balanced ? : false


Sample Input 3:
1 2 -1 4 -1 -1 3 -1 5 -1 -1

Tree 3:
     1
   /   \
  2     3
   \     \
    4     5

Sample Output 3:
Is balanced ? : true
Is balanced ? : true
*/