package mirror_binarytree;
import java.util.Scanner;

/*
Problem Statement:
For a given Binary Tree of type integer, update it with its mirror image.
*/

public class BinaryTreeUse
{
    // O(n)
    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data");   // root input
        }
        else{
            if(isLeft){
                System.out.println("Enter left child of "+ parentData);   // left input
            }
            else{
                System.out.println("Enter right child of "+ parentData);  // right input
            }
        }
        Scanner s= new Scanner(System.in);
        int rootData = s.nextInt();   // read value

        if(rootData==-1){
            return null;   // no node
        }

        BinaryTreeNode<Integer> root= new BinaryTreeNode<>(rootData);
        root.left= takeTreeInputBetter(false, rootData, true);   // build left subtree
        root.right= takeTreeInputBetter(false, rootData, false); // build right subtree

        return root;
    }

    // O(n)
    public static void printTreeDetailed(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;   // base case
        }

        System.out.print(root.data+": ");   // print current node
        if(root.left != null)
        {
            System.out.print("L" + root.left.data+ ", ");   // show left child
        }
        if(root.right != null)
        {
            System.out.print("R"+ root.right.data);   // show right child
        }
        System.out.println();

        printTreeDetailed(root.left);   // traverse left
        printTreeDetailed(root.right);  // traverse right
    }

    // O(n)
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root)
    {
        if(root == null)
        {
            return;   // base case
        }

        // swap children
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right  = temp;

        // apply on subtrees
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }

    public static void main(String[] args)
    {
        BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);
        printTreeDetailed(root);

        mirrorBinaryTree(root);
        System.out.println("Mirror Binary Tree :"); // e.g. Mirror Binary Tree :
        printTreeDetailed(root);
    }
}

/*
Time Complexity:
O(n)
- Each node visited once

Space Complexity:
O(h)
- Recursive stack height

Explanation:
- Swap left and right child at each node
- Recursively mirror subtrees

Sample Input 1:
1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 7 -1 -1

Tree 1:
     1
   /   \
  2     3
 / \   / \
4   5 6   7

After Mirror:
     1
   /   \
  3     2
 / \   / \
7   6 5   4

Sample Output 1:
1: L3, R2
3: L7, R6
7:
6:
2: L5, R4
5:
4:


Sample Input 2:
5 10 2 -1 -1 3 -1 -1 6 -1 9 -1 -1

Tree 2:
      5
     / \
   10   6
  / \     \
 2   3     9

After Mirror:
      5
     / \
    6   10
   /     / \
  9     3   2

Sample Output 2:
5: L6, R10
6: L9
9:
10: L3, R2
3:
2:
*/