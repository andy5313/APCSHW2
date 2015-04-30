import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {

    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 
      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 
      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (curr == null){
	    return t;
	}
	//else if curr.compareTo(t) < 0 { }
	//else if curr.compareTo(t) > 0 { }
	//else (they are equal) { }
	return null;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 
      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	return null;
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 
      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) 
	    return;
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

   
    public static void main( String[] args ) {

    }

}
