package usingInorderPostorder_BuildBT;
import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Given inorder and postorder traversal arrays, construct the binary tree.
*/

public class BinaryTreeUse {
    // O(n)
    public static void printLevelwise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();   // current node
            System.out.print(front.data + ":");

            if (front.left != null) {
                nodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);   // left
            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                nodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);   // right
            } else {
                System.out.print(",R:-1");
            }

            System.out.println();
        }
    }

    // O(n^2)
    public static BinaryTreeNode<Integer> buildTreeUsingInorderPostorder(int[] postOrder, int[] inOrder) {
        return buildTreeFromPostInHelper(postOrder, 0, postOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
    }

    private static BinaryTreeNode<Integer> buildTreeFromPostInHelper(int[] postOrder, int postStart, int postEnd,
                                                                     int[] inOrder, int inStart, int inEnd) {
        if (postStart > postEnd || inStart > inEnd) {
            return null;   // no node
        }

        int rootValue = postOrder[postEnd];   // root from postorder
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootValue);

        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inOrder[i] == rootValue) {
                rootIndex = i;   // find root in inorder
                break;
            }
        }

        int leftSize = rootIndex - inStart;   // left subtree size
        int rightSize = inEnd - rootIndex;    // right subtree size

        root.left = buildTreeFromPostInHelper(postOrder, postStart, postStart + leftSize - 1,
                inOrder, inStart, rootIndex - 1);   // left

        root.right = buildTreeFromPostInHelper(postOrder, postEnd - rightSize, postEnd - 1,
                inOrder, rootIndex + 1, inEnd);    // right

        return root;
    }

    public static void main(String[] args) {
        int inOrder[] = {4, 2, 5, 1, 6, 3, 7};
        int postOrder[] = {4, 5, 2, 6, 7, 3, 1};

        BinaryTreeNode<Integer> root = buildTreeUsingInorderPostorder(postOrder, inOrder);
        printLevelwise(root);
    }
}

/*
Time Complexity:
O(n^2)
- Searching root in inorder each time

Space Complexity:
O(h)
- Recursive stack

Explanation:
- Root is last element of postorder
- Split inorder into left and right parts
- Recursively build subtrees
*/

/*
Sample Input 1:
Inorder:
2 1 3
Postorder:
2 3 1

Tree 1:
   1
  / \
 2   3

Sample Output 1:
1:L:2,R:3
2:L:-1,R:-1
3:L:-1,R:-1


Sample Input 2:
Inorder:
4 2 5 1 6 3 7
Postorder:
4 5 2 6 7 3 1

Tree 2:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

Sample Output 2:
1:L:2,R:3
2:L:4,R:5
3:L:6,R:7
4:L:-1,R:-1
5:L:-1,R:-1
6:L:-1,R:-1
7:L:-1,R:-1


Sample Input 3:
Inorder:
4 2 1 3
Postorder:
4 2 3 1

Tree 3:
    1
   / \
  2   3
 /
4

Sample Output 3:
1:L:2,R:3
2:L:4,R:-1
3:L:-1,R:-1
4:L:-1,R:-1
*/