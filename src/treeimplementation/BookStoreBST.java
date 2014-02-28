/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package treeimplementation;

import java.util.LinkedList;

/**
 *
 * @author Isuru
 */
public class BookStoreBST extends BinarySearchTree{
    
    static LinkedList<BSTNode> keywordContainer = new LinkedList<>();// a static member to store nodes with keyword matchs
    static String keywordSearch;// a static member to store target keyword
    
    public void insert(String bookTitle, String authorFName, String authorSurname,int ISBN){
        BSTNode newBook = new BSTNode(bookTitle,authorFName,authorSurname,ISBN);//create new BSTNode with parameterized constructor
        if(rootN == null){//if tree is empty
            rootN = newBook;//assign new book as the root
            size++;
        }
        else{
            BSTNode current = rootN;
            while(current != null){//find a position to insert new book
                if(newBook.bookTitle.compareTo(current.bookTitle) < 0){//if value of current node is < new node
                    current = current.leftChild;//get right child of current node
                }
                else//new book is less than current node
                    current = current.rightChild;//gett left child of current node
            }
            if(newBook.bookTitle.compareTo(current.bookTitle) < 0)
                (current.parent).leftChild = newBook;
            else
                (current.parent).rightChild = newBook;
            size++;
        }
    }
    
    public BSTNode deleteByName(String title){
        BSTNode deletedNode = searchByName(title);//get a refernce to the target
        deletedNode = remove(deletedNode);//remove the target from the tree
        return deletedNode;//returning a refernce to the node
    }
    
    public BSTNode deleteByISBN(int ISBN){
        BSTNode deletedNode = searchByISBN(ISBN);//get a reference to the target
        deletedNode = remove(deletedNode);//remove the tareget from the tree
        return deletedNode;//returning a reference to the node
    }
    
    public BSTNode searchByName(String title){
        BSTNode current = rootN;//create temporary reference to tree
        if(current.bookTitle.toLowerCase().equals(title.toLowerCase())){//true of root elements' book title = search key/title
            return current;//return a reference to current node
        }
        else{
            while(!current.bookTitle.toLowerCase().equals(title.toLowerCase())&& current.bookTitle != null){//true while current nodes' book title isn't = to search key/title AND current book title isn't null
                if(current.bookTitle.toLowerCase().compareTo(title.toLowerCase())>0){//if current is greater than search key/title
                    current = current.leftChild;//get left child
                }
                else{//if current is less than search key/title
                    current = current.rightChild;//get right child
                }            
            }
            return current;//return a reference to current node
        }
    }
    
    public BSTNode searchByISBN(int ISBN){
        BSTNode current = rootN;//create temporary reference to tree
        if(current.ISBN == ISBN){//true of root elements' isbn = isbn
            return current;//return a reference to current node
        }
        else{
            while(current.ISBN != ISBN && current.ISBN != 0){//true while current nodes' isbn isn't = to isbn AND current isbn isn't 0
                if(current.ISBN > ISBN){//if current is greater than search key/isbn
                    current = current.leftChild;//get left child
                }
                else{//if current is less than search key/isbn
                    current = current.rightChild;//get right child
                }            
            }
            return current;//return a reference to current node
        }
    }
    
    public LinkedList<BSTNode> searchKeyword(String keyword){
        keywordSearch = keyword;
        if(isEmpty()){
            return null;
            /*BSTNode bstn = new BSTNode("test","test","test",1);
            keywordContainer.add(bstn);
            return keywordContainer;*/
        }
        else{
            searchHelper(rootN);
            return keywordContainer;
        }
    }
    
    protected void searchHelper(BSTNode current){//a method similar to inorder travversal
        if(hasLeft(current))
            searchHelper(current.leftChild);//recursive call
        if(current.bookTitle.contains(keywordSearch)){//visit operation
            keywordContainer.add(current);//recursive call
        }
        if(hasRight(current))
            searchHelper(current.rightChild);//recursive call
    }
    
    public LinkedList<BSTNode> displayTree(){//should in an intermediate package
        if(isEmpty()){
            return null;
        }
        else{
            displayTreeHelper(rootN);
            return keywordContainer;
        }
    }
    
    protected void displayTreeHelper(BSTNode current){
        if(hasLeft(current))
            displayTreeHelper(current.leftChild);
        keywordContainer.add(current);
        if(hasRight(current))
            displayTreeHelper(current.rightChild);
    }
    
    public void readXML(){
    
    }
    
    public void writeXML(){
    
    }
}
