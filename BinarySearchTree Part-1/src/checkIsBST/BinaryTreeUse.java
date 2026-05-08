package checkIsBST;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Problem Statement:
Check whether a Binary Tree is BST or not.
*/

public class BinaryTreeUse {
    public static BinaryTreeNode<Integer> takeInputLevelwise()  // iterative way
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root Data: ");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData); // creating node
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll(); // current node

            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();

            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();

            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }
        return root;
    }

    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // base case
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<BinaryTreeNode<Integer>>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll(); // current node
            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);
            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else {
                System.out.print(",R:-1");
            }

            System.out.println();
        }
    }

    public static BinaryTreeNode<Integer> buildTreeUsingInorderPreorder(int[] preOrder, int[] inOrder) {
        BinaryTreeNode<Integer> root = buildTreeFromPreInHelper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeFromPreInHelper(int[] preOrder, int[] inOrder,
                                                                   int siPre, int eiPre, int siIn, int eiIn) {
        if (siPre > eiPre) {
            return null; // base case
        }

        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

        int rootIndex = -1;

        for (int i = siIn; i <= eiIn; i++) {
            if (inOrder[i] == rootData) {
                rootIndex = i;
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int eiPreLeft;

        int siPreRight;
        int eiPreRight = eiPre;

        int siInLeft = siIn;
        int eiInLeft = rootIndex - 1;

        int siInRight = rootIndex + 1;
        int eiInRight = eiIn;

        int leftSubtreeLength = eiInLeft - siInLeft + 1;

        eiPreLeft = siPreLeft + leftSubtreeLength - 1;
        siPreRight = eiPreLeft + 1;

        BinaryTreeNode<Integer> left = buildTreeFromPreInHelper(preOrder, inOrder,
                siPreLeft, eiPreLeft, siInLeft, eiInLeft);

        BinaryTreeNode<Integer> right = buildTreeFromPreInHelper(preOrder, inOrder,
                siPreRight, eiPreRight, siInRight, eiInRight);

        root.left = left;
        root.right = right;

        return root;
    }

    // Way 1 -> O(n^2)
    public static boolean isBST1(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true; // base case
        }

        int leftMax = maximum(root.left);

        if (leftMax >= root.data) {
            return false;
        }

        int rightMin = minimum(root.right);

        if (rightMin < root.data) {
            return false;
        }

        boolean isLeftBST = isBST1(root.left);   // left subtree
        boolean isRightBST = isBST1(root.right); // right subtree

        return isLeftBST && isRightBST;
    }

    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    private static int maximum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    // Way 2 -> O(n)
    public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        IsBSTReturn leftAns = isBST2(root.left);   // left subtree
        IsBSTReturn rightAns = isBST2(root.right); // right subtree

        int min = Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max = Math.max(root.data, Math.max(leftAns.max, rightAns.max));

        boolean isBST = true;

        if (leftAns.max >= root.data) {
            isBST = false;
        }

        if (rightAns.min < root.data) {
            isBST = false;
        }

        if (!leftAns.isBST) {
            isBST = false;
        }

        if (!rightAns.isBST) {
            isBST = false;
        }

        return new IsBSTReturn(min, max, isBST);
    }

    // Way 3 -> O(n)
    public static boolean isBST3(BinaryTreeNode<Integer> root, int minRange, int maxRange) {
        if (root == null) {
            return true; // base case
        }

        if (root.data < minRange || root.data > maxRange) {
            return false;
        }

        boolean isLeftWithinRange = isBST3(root.left, minRange, root.data - 1);
        boolean isRightWithinRange = isBST3(root.right, root.data, maxRange);

        return isLeftWithinRange && isRightWithinRange;
    }

    public static void main(String[] args) {
        // taking predefined BST input
        int inOrder[] = {1, 2, 3, 4, 5, 6, 7};
        int preOrder[] = {4, 2, 1, 3, 6, 5, 7};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPreorder(preOrder, inOrder);

        printLevelwise(root);

        System.out.println(isBST1(root)); // true

        // taking predefined non BST input
        int inOrder2[] = {1, 2, 3, 4, 8, 6, 7};
        int preOrder2[] = {4, 2, 1, 3, 6, 8, 7};

        BinaryTreeNode<Integer> root2 = buildTreeUsingInorderPreorder(preOrder2, inOrder2);

        printLevelwise(root2);

        System.out.println(isBST1(root2)); // false

        // Way 2
        IsBSTReturn ans1 = isBST2(root);
        System.out.println(ans1.min + " " + ans1.max + " " + ans1.isBST);

        IsBSTReturn ans2 = isBST2(root2);
        System.out.println(ans2.min + " " + ans2.max + " " + ans2.isBST);

        // Way 3
        System.out.println(isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST3(root2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}

/*
Time Complexity:
- Way 1 : O(n^2)
- Way 2 : O(n)
- Way 3 : O(n)

Space Complexity:
O(h) - recursion stack

Explanation:
- Way 1 checks max and min repeatedly
- Way 2 stores min, max and BST status together
- Way 3 uses range validation
*/

/*
Sample BST Tree:
        4
      /   \
     2     6
    / \   / \
   1   3 5   7

Sample Output:
true
1 7 true
true


Sample Non-BST Tree:
        4
      /   \
     2     6
    / \   / \
   1   3 8   7

Sample Output:
false
1 8 false
false
*/