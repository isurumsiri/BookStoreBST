package treeimplementation;

import java.util.Iterator;

/**
 *specifies the ADT of binary search tree.
 *child in here is referring to a child node
 *parent in here is referring to a parent node
 *positing in here is referring to a reference variable of an object of type binary tree node
 *value in here is referring to a value to be inserted into an object; 
 *replace() methods should be overloaded so as to insert values for each field depending on implementation
 * @author Isuru
 */
public interface BinarySearchTreeADT {
    /*Generic methods*/
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract Iterator iterator();
	public abstract Iterable positions();

	/*Accessor methods*/
	public abstract BSTNode root();
	public abstract BSTNode parent(BSTNode child);
	public abstract Iterable children(BSTNode parent);

	/*Query methods*/
	public abstract boolean isInternal(BSTNode position);
	public abstract boolean isExternal(BSTNode position);
	public abstract boolean isRoot(BSTNode position);

	/*Update metods*/
	public abstract BSTNode replace(BSTNode position, BSTNode value);
	public abstract BSTNode remove(BSTNode position);

	/*Binary Tree specific methods*/
	public abstract BSTNode left(BSTNode position);
	public abstract BSTNode right(BSTNode position);
	public abstract boolean hasLeft(BSTNode position);
	public abstract boolean hasRight(BSTNode position);

	/*Traversing methods*/
	public abstract void preOrder(BSTNode position);
	public abstract void postOrder(BSTNode position);
	public abstract void inOrder(BSTNode position);

}
