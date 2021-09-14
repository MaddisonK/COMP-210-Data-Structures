package a5;
import java.util.LinkedList;
import java.util.Queue;

public class NonEmptyBST<T extends Comparable<T>> implements BST<T> {
	private T _element;
	private BST<T> _left;
	private BST<T> _right;
	private int size;

	public NonEmptyBST(T element) {

		_left = new EmptyBST<T>();
		_right = new EmptyBST<T>();
		_element = element;
		size = 1;
	}


	// TODO: size
	@Override
	public int size() {
		int value = 1;
		if (isEmpty()) {
			return 0;
		} else {
			value += _left.size();
			value += _right.size();
		}
		return value;
	}

	// TODO: findMin
	@Override
	public T findMin() {
		T value;
		if (_left.isEmpty()) {
			return _element;
		} else {
			value = _left.findMin();
		}
		return value;
	}

	// TODO: findMax
	@Override
	public T findMax() {
		T value;
		if (_right.isEmpty()) {
			return _element;
		} else {
			value = _right.findMax();
		}
		return value;
	}

	// TODO: contains
	@Override
	public boolean contains(T element) {
		if (element.compareTo(_element) == 0) {
			return true;
		}
		boolean value;
		if (element.compareTo(_element) < 0) {
			value = _left.contains(element);
		} else {
			value = _right.contains(element);
		}
		if (!value) {
			return false;
		} else {
			return true;
		}
	}

	// TODO: insert
	@Override
	public BST<T> insert(T element) {
		if (element.compareTo(_element) < 0) {
			_left = _left.insert(element);

		} else {
			_right = _right.insert(element);
		}
		size++;
		return this;
	}

	// TODO: remove
	@Override
	public BST<T> remove(T element) {
		if (isEmpty()) {
			return this;
		}
		if (size() == 1) {
			return new EmptyBST<>();
		}
		if (element.compareTo(_element) == 0) {
			 if (_right.isEmpty() & _left.isEmpty()) {
				 return _right;
			 } else if (_left.isEmpty()) {
			 	return _right;
			 } else if (_right.isEmpty()) {
				 return _left;
			 } else {
			 	T rightMin = _right.findMin();
			 	this._element = rightMin;
				this._right.remove(rightMin);
			 }
		} else {
			_left = _left.remove(element);
			_right = _right.remove(element);
		}
		return this;
	}

	// TODO: printInOrderTraversal
	@Override
	public void printInOrderTraversal() {
		if (isEmpty()) {
			return;
		} else {
			_left.printInOrderTraversal();
			System.out.print(_element + " ");
			_right.printInOrderTraversal();
		}
	}

	// TODO: printPreOrderTraversal
	@Override
	public void printPreOrderTraversal() {
		if (isEmpty()) {
			return;
		} else {
			System.out.print(_element + " ");
			_left.printPreOrderTraversal();
			_right.printPreOrderTraversal();
		}
	}

	// TODO: printPostOrderTraversal
	@Override
	public void printPostOrderTraversal() {
		if (isEmpty()) {
			return;
		} else {
			_left.printPostOrderTraversal();
			_right.printPostOrderTraversal();
			System.out.print(_element + " ");
		}
	}

	// TODO: printBreadthFirstTraversal
	@Override
	public void printBreadthFirstTraversal() {
		Queue<BST> q = new LinkedList<BST>();
		q.add(this);
		while (!q.isEmpty()) {
			BST current = q.remove();
			System.out.print(current.getElement() + " ");
			if (!current.getLeft().isEmpty()) {
				q.add(current.getLeft());
			}
			if (!current.getRight().isEmpty()) {
				q.add(current.getRight());
			}
		}
	}

	@Override
	public int getHeight() {
		return Math.max(_left.getHeight(), _right.getHeight())+1;
	}

	@Override
	public BST<T> getLeft() {
		return _left;
	}

	@Override
	public BST<T> getRight() {
		return _right;
	}

	@Override
	public T getElement() {
		return _element;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	public void printElement() {
		System.out.println(_element);
		return;
	}

	public void test() {
		NonEmptyBST<T> current = this;
		current.printElement();
	}
//	public boolean isBinarySearchTree( NonEmptyBST<T> bst) {
//		return isBSTRecursive(bst, Integer.MAX_VALUE, Integer.MIN_VALUE);
//	}
//
//	public boolean isBSTRecursive(BST<T> bst, T intMax, T intMin) {
//		boolean value = false;
//		if (isEmpty()) {
//			return true;
//		}
//		if ((_left.getElement().compareTo(intMax) < 0) & (_right.getElement().compareTo(intMin) > 0)) {
//			value = isBSTRecursive(_left, _element, _element);
//			if (value != true) {
//				return false;
//			} else {
//				value = isBSTRecursive(_right, _element, _element);
//			}
//		}
//		return value;
//	}

}
