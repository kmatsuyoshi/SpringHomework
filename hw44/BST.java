// Kayli Matsuyoshi
// APCS2 pd1
// HW44 - ??
// 2018-05-02w

/*****************************************************
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

    //instance variables / attributes of a BST:
    TreeNode _root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( )
    {
	_root = null;
    }


    /*****************************************************
     * void insert( int )
     * Adds a new data element to tree.
     *****************************************************/
    public void insert( int newVal )
    {
	TreeNode newNode = new TreeNode( newVal );

	if ( _root == null ) {
	    _root = newNode;
	    return;
	}
	insert( _root, newNode );
    }
    //recursive helper for insert(int)
    public void insert( TreeNode stRoot, TreeNode newNode )
    {
	if ( newNode.getValue() < stRoot.getValue() ) {
	    //if no left child, make newNode the left child
	    if ( stRoot.getLeft() == null )
		stRoot.setLeft( newNode );
	    else //recurse down left subtree
		insert( stRoot.getLeft(), newNode );
	    return;
	}
	else { // new val >= curr, so look down right subtree
	    //if no right child, make newNode the right child
	    if ( stRoot.getRight() == null )
		stRoot.setRight( newNode );
	    else //recurse down right subtree
		insert( stRoot.getRight(), newNode );
	    return;
	}
    }//end insert()




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out
    // the nodes visited, in order

    //process root, recurse left, recurse right
    public void preOrderTrav()
    {
	preOrderTrav( _root );
    }
    private void preOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	System.out.print( currNode.getValue() + " " );
	preOrderTrav( currNode.getLeft() );
	preOrderTrav( currNode.getRight() );
    }

    //recurse left, process root, recurse right
    public void inOrderTrav()
    {
	inOrderTrav( _root );
    }
    private void inOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	inOrderTrav( currNode.getLeft() );
	System.out.print( currNode.getValue() + " " );
	inOrderTrav( currNode.getRight() );
    }

    //recurse left, recurse right, process root
    public void postOrderTrav()
    {
	postOrderTrav( _root );
    }
    private void postOrderTrav( TreeNode currNode )
    {
	if ( currNode == null ) //stepped beyond leaf
	    return;
	postOrderTrav( currNode.getLeft() );
	postOrderTrav( currNode.getRight() );
	System.out.print( currNode.getValue() + " "  );
    }

    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    public TreeNode search( int target )
    {
	if ( _root.getValue() == target ) {
	    return _root;
	}
	return search( _root, target );
    }

    private TreeNode search( TreeNode node, int target )
    {
	if ( node == null) {
	    return null;
	}
	else if ( target < node.getValue() ) {
	    return search( node.getLeft(), target );
	}
	else if ( target > node.getValue() ) {
	    return search( node.getRight(), target );
	}
	else {
	    return node;
	}
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height() {
	int counter = 0;
	return height( counter, _root ) -1;
    }
    
    private int height( int counter, TreeNode node )
    {
	if ( node == null ) {//stepped beyond leaf
	    return counter;
	}
	else {
	    return Math.max( height( counter+1, node.getLeft() ), height( counter+1, node.getRight() ) );
	}
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	int counter = 0;
	return height( counter, _root );
    }
    public int numLeaves( int counter, TreeNode node)
    {
	if ( node == null ) { //stepped beyond leaf
	    counter++ ;
	}
        numLeaves( counter, node.getLeft() );
	numLeaves( counter, node.getRight() );
	return counter;
    }

    /*****************************************************
     * int remove( int )
     * removes a node in the tree
     *****************************************************/
    public TreeNode remove( int target )
    {
	if ( _root.getValue() == target ) {
	    // case 1
	    // set min of right or max of left as root
	    
	    return _root;
	}
	return remove( _root, target );
    }

    private TreeNode remove( TreeNode node, int target )
    {
	
    }

    //main method for testing
    public static void main( String[] args )
    {
	BST arbol = new BST();

	//PROTIP: sketch state of tree after each insertion
	//        ...BEFORE executing these.
	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );
	

	System.out.println( "\n-----------------------------");
	System.out.println( "pre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "in-order traversal:" );
	arbol.inOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "post-order traversal:" );
	arbol.postOrderTrav();

	System.out.println( "\n-----------------------------");
	System.out.println( "search:" );
	System.out.println( arbol.search(3) ); // pointer
	System.out.println( arbol.search(7) ); // null

	System.out.println( "\n-----------------------------");
	System.out.println( "height:" );
	System.out.println( arbol.height() ); // 2

	System.out.println( "\n-----------------------------");
	System.out.println( "numLeaves:" );
	System.out.println( arbol.numLeaves() ); // 3

	System.out.println( "\n-----------------------------");
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  <<< YOUR NEW TEST CALLS HERE >>>
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class
