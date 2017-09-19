import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {

	private int size = 0;
	private Node<E> header;
	private Node<E> tail;
	private Node<E> currentItem;

//LinkedList- add/get/set/remove с индексом и без, contains, linkBefore, linkAfter

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(Object o) {
		for(int i = 0; i < size(); i++) {
			if(get(i).equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
		Node<E> node = new Node<E>(e);

		if(header == null) {
			currentItem = node;
			header = node;
			tail = node;

		} else {
			if(size() == 1) {
				header.setNext(node);
				tail = node;
				tail.setPrev(header);
			} else {
				tail.setNext(node);
				node.setPrev(tail);
				tail = node;
			}
		}
		size++;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		for(int i = 0; i < size(); i++) {
			if(get(i).equals(o)) {
				remove(i);
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		header = null;
		tail = null;
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public E get(int index) {
		if(isEmpty()) {
			return null;
		}
		Node<E> node = null;
		if(index >= 0 && index <= size() / 2) {
			node = header;
			for(int i = 0; i < index; i++) {
				node = node.getNext();
			}
		} else if(index > size() / 2 && index < size()) {
			node = tail;
			for(int i = size() - 1; i > index; i--) {
				node = node.getPrev();
			}
		} else {
			return null;
		}
		return node.getEl();
	}

	@Override
	public E set(int index, E e) {
		if(isEmpty()) {
			return null;
		}
		Node<E> node = null;
		if(index >= 0 && index <= size() / 2) {
			node = header;
			for(int i = 0; i < index; i++) {
				node = node.getNext();
				node.setEl(e);
			}
		} else if(index > size() / 2 && index < size()) {
			node = tail;
			for(int i = size() - 1; i > index; i--) {
				node = node.getPrev();
				node.setEl(e);
			}
		} else {
			return null;
		}
		return node.getEl();
	}

	@Override
	public void add(int index, E e) {
		Node<E> node = new Node<E>(e);
		if(index == 0) {
			header.setPrev(node);
			node.setNext(header);
			header = node;
		}
		if(index == size() - 1) {
			node.setPrev(tail);
			tail.setNext(node);
			tail = node;
		}
		if((index > 0) && (index < size() - 1)) {
			Node<E> tmpnode = null;
			if(index >= 0 && index <= size() / 2) {
				for(int i = 0; i < index; i++) {
					tmpnode = tmpnode.getNext();
					tmpnode.setPrev(node);
					node.setNext(tmpnode);
					tmpnode.getPrev().setNext(node);
					node.setPrev(tmpnode.getPrev());
				}
			} else if(index > size() / 2 && index < size()) {
				for(int i = size() - 1; i > index; i--) {
					tmpnode = tmpnode.getPrev();
					tmpnode.setPrev(node);
					node.setNext(tmpnode);
					tmpnode.getPrev().setNext(node);
					node.setPrev(tmpnode.getPrev());
				}
			}
		}
	}

	@Override
	public E remove(int index) {
		if(isEmpty()) {
			return null;
		}
		Node<E> node = null;
		if(size() == 1) {
			header = null;
			tail = null;
			return null;
		}
		if(index >= 0 && index <= size() / 2) {
			node = header;
			for(int i = 0; i <= index; i++) {
				node = node.getNext();
				if(index == 0) {
					node.setPrev(null);
					header = node;
				} else {
					node.getNext().setPrev(node.getPrev());
					node.getPrev().setNext(node.getNext());
					break;
				}
			}
		} else if(index > size() / 2 && index < size()) {
			node = tail;
			for(int i = size() - 1; i >= index; i--) {
				node = node.getPrev();
				if(index == size() - 1) {
					node.getPrev().setNext(null);
					tail = node;
				} else {
					node.getNext().setPrev(node.getPrev());
					node.getPrev().setNext(node.getNext());
					break;
				}
			}
		} else {
			return null;
		}
		size--;
		return node.getEl();
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
	}

	public Node<E> linkBefore() {
		return currentItem.getPrev();
	}

	public Node<E> linkAfter() {
		return currentItem.getPrev();
	}
}
