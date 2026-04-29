package incrementelement_LL;

// Node → stores data and reference to next node
public class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}