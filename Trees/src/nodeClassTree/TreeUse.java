package nodeClassTree;

public class TreeUse {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);

        // Adding children to root
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        // Adding children to node2
        node2.children.add(node4);
        node2.children.add(node5);
    }
}

/*
Tree Structure:
    4
 /  |  \
2   3   1
   / \
  5   6
*/