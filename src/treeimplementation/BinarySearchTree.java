/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treeimplementation;

import java.util.Iterator;

/**
 *BinarySearchTreee class implements all abstract methods of the BinarySearchTreeADT
 * @author Isuru
 */
public class BinarySearchTree implements BinarySearchTreeADT{
    
    /**
     *tree specific fields 
     */
     BSTNode rootN; //defining a reference to the root
     int size = 0; //initializing size to zero

    @Override
    public boolean isEmpty() {
        return (rootN == null || size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    //beyond the scope
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //beyond the scope
    @Override
    public Iterable positions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BSTNode root() {
        if(rootN == null)
            return null;
        else
            return rootN;
    }

    @Override
    public BSTNode parent(BSTNode child) {
        if(child.parent == null)
            return null;
        else 
            return child.parent;
    }

    @Override
    public Iterable children(BSTNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(BSTNode position) {
         return hasLeft(position)||hasRight(position);//if position node has at least on child, returns true
    }

    @Override
    public boolean isExternal(BSTNode position) {
         return !hasLeft(position) && !hasRight(position);//if position node doesn't have both left and right children, returns true
    }

    @Override
    public boolean isRoot(BSTNode position) {
        return position == rootN;
    }

    @Override
    public BSTNode replace(BSTNode position, BSTNode value) {
        BSTNode tmp = position;
        position = value;
        return tmp;
    }

    /**
     * remove a node at given position.
     * position of the intended node should find using a search method.
     * definition and implementation is required.
     * returns the deleted node.
     * @param position
     * @return 
     */
    @Override
    public BSTNode remove(BSTNode position) {
        BSTNode tmp = position;
        if(tmp == rootN)//if position is root
        {
            rootN = null;//make roots' reference point to null
            size--;
        }
        else if(isExternal(tmp))//check whether the tmp is an external ethod;condition beomes true if tmp is an external node
        {
            BSTNode parent = parent(tmp);//get the parent of the tmp
            if(parent.leftChild == tmp)//if tmp is the left child of the parent
                parent.leftChild = null;//remove the left child of tmps' parent
            else//if tmp is the right child of tmps' parent
                parent.rightChild = null;//remove the right child of tmps' parent
            size--;
        }
        else if(tmp.rightChild == null)//if position has only left child
        {
            BSTNode parent = tmp.parent;
            if(parent.leftChild == tmp)//if tmp is the left child of its parent
            {
                parent.leftChild = tmp.leftChild;//assign left child of tmp to tmps' parent as its left child
                (tmp.leftChild).parent = tmp.parent;//assing tmps' left child to tmps' parents as its left child
            }
            else//if tmp is the right child of its parent
            {
                parent.rightChild = tmp.leftChild;//assign left child of tmp asto its parents' right child
                (tmp.leftChild).parent = tmp.parent;//assign tmps' parent as tmps' left childs parent
            }
            size--;
        }
        else if(tmp.leftChild == null)//if position has only right child
        {
            BSTNode parent = tmp.parent;
            if(parent.leftChild == tmp)//if tmp is the left child of its parent
            {
                parent.leftChild = tmp.rightChild;//assign tmps' right child as its parents left child
                (tmp.rightChild).parent = tmp.parent;//assign tmps' parent as tmps right childs parent 
            }
            else//if tmp is the right child of its parent
            {
                parent.rightChild = tmp.rightChild;//assign tmps' right child as its parents right child
                (tmp.rightChild).parent = tmp.parent;//assign tmps' parent as its right childs' parent
            }
            size--;
        }
        else if(hasLeft(tmp) && hasRight(tmp)){//if tmp/position has both left and right children
            /**
             * has two options of selecting one candidate key/node.
             * right most external node of left sub tree OR left most external node of right sub tree
             * here I'll select the candidate key as right most node of left sub tree
             */
            BSTNode parent = tmp.parent;//get the parent node of tmp
            BSTNode current = tmp.leftChild;//point current reference to first node/root of left sub tree of tmp
            while(current.rightChild != null)//condition false if current is the right most node
            {
                current = current.rightChild;//replace currents' value with its' right child
            }
            if(hasLeft(current)){//true if current has a left child
                (current.parent).rightChild = current.leftChild;//assign currents' left child as right child of currents' parent
            }
            if(parent.leftChild == tmp){//if tmp is the left child of its' parent
                parent.leftChild = current;//assign currrent as the left child of the tmps' parent
            }
            else{//if tmp is the right child  of its' parent
                parent.rightChild = current;//assign current as the right child of the tmps' parent
            }
            current.leftChild = tmp.leftChild;//assign tmps' left child to currents' left child
            current.rightChild = tmp.rightChild;//assign tmps' right child to currents' right child
            size--;
        }
        tmp.parent = null;//make tmps' parent reference null
        tmp.leftChild = null;//make tmps' left child reference null
        tmp.rightChild = null;//make tmps' right child reference null
        return tmp;
    }

    @Override
    public BSTNode left(BSTNode position) {
        if(hasLeft(position)){
            return position.leftChild;
        }
        else{
            return null;
        }
    }

    @Override
    public BSTNode right(BSTNode position) {
        if (hasRight(position)) {
            return position.rightChild;
        } else {
            return null;
        }
    }

    @Override
    public boolean hasLeft(BSTNode position) {
        if(position.leftChild!=null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean hasRight(BSTNode position) {
        if (position.rightChild!=null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void preOrder(BSTNode position) {
        position.printBook();
        if(hasLeft(position))
        {
            preOrder(position.leftChild);
        }
        if(hasRight(position))
        {
            preOrder(position.rightChild);
        }
    }

    @Override
    public void postOrder(BSTNode position) {
        if(hasLeft(position))
            postOrder(position.leftChild);
        if(hasRight(position))
            postOrder(position.rightChild);
        else
            position.printBook();
    }

    @Override
    public void inOrder(BSTNode position) {
        if(hasLeft(position))
            inOrder(position.leftChild);
        position.printBook(); 
        if(hasRight(position))
            inOrder(position.rightChild);
    }
    
}
