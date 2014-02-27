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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BSTNode replace(BSTNode position, BSTNode value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BSTNode remove(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BSTNode left(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BSTNode right(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasLeft(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasRight(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preOrder(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postOrder(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inOrder(BSTNode position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
