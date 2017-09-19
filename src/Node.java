public class Node<E> {

	private Node next;
	private Node prev;
	private E el;

	public Node() {
		this.next = null;
		this.prev = null;
	}

	public Node(Node previous) {
		this.next = null;
		this.prev = previous;
	}

	public Node(Node previous, Node next) {
		this.next = next;
		this.prev = previous;
	}

	public Node(E e, Node previous, Node next) {
		this.next = next;
		this.prev = previous;
		this.el = e;
	}

	public Node(E e) {
		this.next = null;
		this.prev = null;
		this.el = e;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public E getEl() {
		return el;
	}

	public void setEl(E el) {
		this.el = el;
	}

	@Override
	public int hashCode(){
		return 0;
	}

	public boolean equals(Object obj) {
		return (this == obj);
	}

}
