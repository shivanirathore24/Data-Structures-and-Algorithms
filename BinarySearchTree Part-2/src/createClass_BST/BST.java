package createClass_BST;

/*
Problem Statement:
Implement BST class with insert, search, remove and print operations.
*/

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    public int size() {
        return size;
    }

    // O(h)
    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private static boolean searchHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return false; // node not found
        }

        if (root.data == data) {
            return true; // node found
        } else if (root.data < data) {
            return searchHelper(root.right, data); // search right
        } else {
            return searchHelper(root.left, data); // search left
        }
    }

    // O(h)
    public void insert(int data) {
        root = insertHelper(root, data);
        size++;
    }

    private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return new BinaryTreeNode<>(data); // create node
        }

        if (root.data >= data) {
            root.left = insertHelper(root.left, data); // insert left
        } else {
            root.right = insertHelper(root.right, data); // insert right
        }
        return root;
    }

    // O(h)
    public void remove1(int data) {
        root = remove1Helper(root, data);
        size--;
    }

    private static BinaryTreeNode<Integer> remove1Helper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = remove1Helper(root.left, data);
            return root;
        } else if (data > root.data) {
            root.right = remove1Helper(root.right, data);
            return root;
        } else {
            // leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // only right child
            else if (root.left == null) {
                return root.right;
            }

            // only left child
            else if (root.right == null) {
                return root.left;
            }

            // both children
            else {
                BinaryTreeNode<Integer> minNode = root.right;

                while (minNode.left != null) {
                    minNode = minNode.left;
                }

                root.data = minNode.data;
                root.right = remove1Helper(root.right, minNode.data);
                return root;
            }
        }
    }

    // O(h)
    public boolean remove2(int data) {
        BSTRemoveReturn output = remove2Helper(root, data);
        root = output.root;

        if (output.deleted) {
            size--;
        }
        return output.deleted;
    }

    private static BSTRemoveReturn remove2Helper(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return new BSTRemoveReturn(null, false);
        }

        if (root.data < data) {
            BSTRemoveReturn outputRight = remove2Helper(root.right, data);

            root.right = outputRight.root;
            outputRight.root = root;

            return outputRight;
        }

        if (root.data > data) {
            BSTRemoveReturn outputLeft = remove2Helper(root.left, data);

            root.left = outputLeft.root;
            outputLeft.root = root;

            return outputLeft;
        }

        // node found

        // no child
        if (root.left == null && root.right == null) {
            return new BSTRemoveReturn(null, true);
        }

        // only left child
        if (root.left != null && root.right == null) {
            return new BSTRemoveReturn(root.left, true);
        }

        // only right child
        if (root.left == null && root.right != null) {
            return new BSTRemoveReturn(root.right, true);
        }

        // both children
        int rightMin = minimum(root.right);
        root.data = rightMin;

        BSTRemoveReturn outputRight = remove2Helper(root.right, rightMin);
        root.right = outputRight.root;

        return new BSTRemoveReturn(root, true);
    }

    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int minLeft = minimum(root.left);
        int minRight = minimum(root.right);

        return Math.min(root.data, Math.min(minLeft, minRight));
    }

    // O(n)
    public void printTree() {
        printTreeHelper(root);
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return; // base case
        }

        System.out.print(root.data + ":");
        if (root.left != null) {
            System.out.print("L:" + root.left.data + ",");
        }

        if (root.right != null) {
            System.out.print("R:" + root.right.data);
        }

        System.out.println();

        printTreeHelper(root.left);
        printTreeHelper(root.right);
    }
}