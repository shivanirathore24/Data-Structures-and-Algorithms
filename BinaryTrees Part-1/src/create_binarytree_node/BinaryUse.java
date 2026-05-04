package create_binarytree_node;

public class BinaryUse {
    public static void main(String[] args) {
        // create root node
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);

        // create left and right child of root
        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<Integer>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<Integer>(3);

        root.left = rootLeft;     // attach left child
        root.right = rootRight;   // attach right child

        // create further nodes
        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<Integer>(4);
        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<Integer>(5);

        // attach children to respective nodes
        rootLeft.right = twoRight;     // 2 → right → 4
        rootRight.left = threeLeft;   // 3 → left → 5

        // Final Tree:
        //        1
        //      /   \
        //     2     3
        //      \   /
        //       4 5
    }
}