import java.util.ArrayList;
import java.util.Collections;

public class BST<T extends Comparable<T>> {
	private T datum;
	private BST<T> left;
	private BST<T> right;

	// CONSTRUCTOR
	public BST(T datum) {
		this.datum = datum;
		left = null;
		right = null;
	}

	public boolean isEmpty() {
		return (datum == null);
	}

	// ACCESSOR
	public T getDatum() {
		return datum; // returns the datum of a node
	}

	public BST<T> getLeft() {
		return left; // returns the left subtree
	}

	public BST<T> getRight() {
		return right; // returns the right subtree
	}

	// MUTATOR
	public void setLeft(BST<T> tree) {
		left = tree;
	}

	public void setRight(BST<T> tree) {
		right = tree;
	}

	// INSERT A NEW NODE
	public void insert(T datum) {
		if (this.getDatum() == null) {
			return;
		} else if (datum.compareTo(this.getDatum()) > 0) {
			if (this.getRight() == null) {
				this.setRight(new BST(datum));
			} else {
				this.getRight().insert(datum);
			}
		} else if (datum.compareTo(this.getDatum()) < 0) {
			if (this.getLeft() == null) {
				this.setLeft(new BST(datum));
			} else {
				this.getLeft().insert(datum);
			}
		}
	}

	// GET THE DEPTH OF A TREE
	public int depth() {
		if (isEmpty())
			return 0;
		else {
			return (1 + (Math.max(left == null ? 0 : left.depth(), right == null ? 0 : right.depth())));
		}
	}

	// TOSTRING, PRINT
	public String toString() {
		String s = "" + datum + ", ";
		if (left != null)
			s = left.toString() + s;
		if (right != null)
			s = s + right.toString();
		return s;
	}
	public void printInOrder() {
		if (left != null)
			left.printInOrder();
		System.out.print("(" + datum + ") ");
		if (right != null)
			right.printInOrder();
	}
	public void printPreOrder() {
		System.out.print("(" + datum + ") ");
		if (left != null)
			left.printPreOrder();
		if (right != null)
			right.printPreOrder();
	}

	// CHECK IF THE TREE CONTAINS THE DATUM
	public boolean contains(T datum) {
		if (this.getDatum().compareTo(datum) == 0) {
			return true;
		}
		else if (right == null && left == null) {
			return this.getDatum().compareTo(datum) == 0 ? true : false;
		}
		else if (this.getDatum().compareTo(datum) > 0 && left != null) {
			return left.contains(datum);
		}
		else if (this.getDatum().compareTo(datum) < 0 && right != null) {
			return right.contains(datum);
		}
		else {
			return false;
		}
	}

	// GET THE NUMBER OF NODES
	public int countNodes() {
		if (isEmpty()) {
			return 0;
		} else {
			if (left == null && right != null) {
				return (1 + (right.countNodes()));
			} else if (right == null && left != null) {
				return (1 + (left.countNodes()));
			} else if (right != null && left != null) {
				return (1 + left.countNodes() + right.countNodes());
			} else {
				return 1;
			}
		}
	}
}
