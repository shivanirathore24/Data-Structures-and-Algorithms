package create_binarytree_node;

public class BinaryTreeNode<T> {
    public T data;                  // node value
    public BinaryTreeNode<T> left;  // left child
    public BinaryTreeNode<T> right; // right child

    public BinaryTreeNode(T data) {
        this.data = data;           // set value
    }
} // BinaryTree Node