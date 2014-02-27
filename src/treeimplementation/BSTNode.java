
package treeimplementation;

/**
 *
 * @author Isuru
 */
public class BSTNode extends Book{
    /**
     * three self referencing object references to parent, left child and right child.
     */
    BSTNode parent, leftChild, rightChild;
    
    public BSTNode(){}
    
    public BSTNode(String bookTitle, String authorFName, String authorSurname, int ISBN){
        super(bookTitle,authorFName,authorSurname,ISBN);
    }
}
