package a5;


public class EmptyBST<T extends Comparable<T>> implements BST<T> {

	@Override
	public int size() {
		return 0;
	}

	@Override
	public BST<T> insert(T element) {
		return new NonEmptyBST<T>(element);
	}

	@Override
	public BST<T> remove(T element) {
		return this;
	}

	@Override
	public T findMin() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T findMax() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(T element) {
		return false;
	}

	@Override
	public int getHeight() {
		return -1;
	}

	@Override
	public void printInOrderTraversal() {
		return ;
	}

	@Override
	public void printPreOrderTraversal() {
		return;
	}

	@Override
	public void printPostOrderTraversal() {
		return;
	}

	@Override
	public void printBreadthFirstTraversal() {

	}

	@Override
	public BST<T> getLeft() {
		throw new UnsupportedOperationException();
	}

	@Override
	public BST<T> getRight() {
		throw new UnsupportedOperationException();
	}

	@Override
	public T getElement() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public void test() {
		return;
	}

	@Override
	public void printElement() {
		return;
	}
//
//	@Override
//	public boolean isBSTRecursive(BST bst, int intMax, int intMin) {
//		return true;
//	}
//
//	@Override
//	public boolean isBinarySearchTree(NonEmptyBST<T> bst) {
//		return false;
//	}
}
