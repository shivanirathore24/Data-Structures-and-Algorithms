package printrecursive_binarytree;

public class BinaryUse {
    // O(n)
    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case → stop when node is null
        }
        System.out.println(root.data);   // print current node
        printTree(root.left);            // go left subtree
        printTree(root.right);           // go right subtree
    }

    // O(n)
    public static void printTreeDetailed(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;   // base case
        }

        System.out.print(root.data + ": ");   // print root
        if (root.left != null) {
            System.out.print("L" + root.left.data);   // left child
        }

        if (root.right != null) {
            if (root.left != null) {
                System.out.print(", ");   // print comma only if both exist
            }
            System.out.print("R" + root.right.data);   // right child
        }
        System.out.println();

        printTreeDetailed(root.left);   // recursive left
        printTreeDetailed(root.right);  // recursive right
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);

        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);
        root.left = rootLeft;
        root.right = rootRight;

        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);
        rootLeft.right = twoRight;
        rootRight.left = threeLeft;

        printTreeDetailed(root);
		/*
		Output:
		1: L2, R3
		2: R4
		4:
		3: L5
		5:
		*/
    }
}