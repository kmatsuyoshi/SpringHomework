//Gardeners (Qian Zhou and Kayli Matsuyoshi)
//APCS2 pd01
//HW44 --  Prune Your Tree
//2018-05-02

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
  public void preOrderTrav( TreeNode currNode )
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
  public void inOrderTrav( TreeNode currNode )
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
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }

  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    //methinks as recursion is repeatedly mentioned, but no helper method given, looping maight be ze answer for search

    
    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
	if (_root==null)return null;
	TreeNode cloud = _root;
	while (cloud!=null){
	    if (cloud.getValue()==target)return cloud;
	    if (target<cloud.getValue()){
		cloud = cloud.getLeft();
	    }
	    else cloud = cloud.getRight();
	}
	return null;
	
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    {
	if (_root ==null){return -1;};
	return height(_root,0);
    }

    //helper ...I think is needed
    public int height(TreeNode n, int h){
	if (n==null){return 0;}
	if(n.getLeft()==n.getRight()){//null, since BST can't have same vals
	    return h;}
	h++;
	return Math.max(height(n.getLeft(),h), height(n.getRight(),h));
    }

    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeaves(_root);
    }

    //can think of no way of traversing w/o helper, nor some mathematical method of solving based on traversals
    public int numLeaves(TreeNode n){
	if (n==null){
	    return 0;}
	else if(n.getLeft()==n.getRight()){//null, since BST can't have same vals
	    return 1;}
	else return numLeaves(n.getLeft())+numLeaves(n.getRight());
	
	
    }

    /*****************************************************
     * void remove(int)
     * 
     *****************************************************/

    public void remove(int target){
	//make sure
	if (_root ==null){return;}
	if (_root.getValue() == target&&
	    _root.getLeft()==_root.getRight()){_root = null;return;}

	//can't use search since cannot remove it without its parent node
	TreeNode cloud = _root;
	TreeNode trail=null;
	boolean cloudDir=false; //to identify which direction is cloud going for sake of removing it, true = left, false = right
	//value just to get over variable initialization problem
	while (cloud.getValue()!=target&&cloud!=null){
	    if (target<cloud.getValue()){
		trail = cloud;
		cloud=cloud.getLeft();
		cloudDir = true;
	    }
	    else{
		trail = cloud;
		cloud = cloud.getRight();
		cloudDir = false;
	    }
	}
	//actual removing
	if (cloud==null){
	    return;
	}
	
	else if (cloud.getLeft()==cloud.getRight()){//childless
	    if (cloudDir) {trail.setLeft(null);return;}
	    else{trail.setRight(null);return;}
	}

	//one children
	else if(cloud.getRight() ==null){
	    if(cloudDir) {trail.setLeft(cloud.getLeft());return;}
	    else{trail.setRight(cloud.getLeft());return;}
	}
	else if(cloud.getLeft() ==null){
	    if(cloudDir) {trail.setLeft(cloud.getRight());return;}
	    else{trail.setRight(cloud.getRight());return;}
	}
	
	else{
	    if (cloud.getRight().getRight()==null){
		cloud.setRight(cloud.getRight().getLeft());
		return;
	    }
	    TreeNode newCloud = cloud.getRight();//getting to the next value, find min of right
	    //loops until one node away from leaf
	    while (newCloud.getLeft()!=null&&newCloud.getLeft().getLeft()!=null){
		newCloud=newCloud.getLeft();
	    }
	    //change value of present node

	    cloud.setValue(newCloud.getLeft().getValue());

	    //remove promoted node
	    newCloud.setLeft(newCloud.getLeft().getRight());
	}
	
	
	    

	    
    }
    
  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 50 );   arbol.insert( 25 );
    arbol.insert( 75 );   arbol.insert( 14 );
    arbol.insert( 30 );   arbol.insert( 60 );
    arbol.insert( 80 );   arbol.insert( 55 );
    arbol.insert( 70 );   arbol.insert( 57 );
       arbol.insert( 29 );
    arbol.insert( 33 );   arbol.insert( 26 );
    arbol.insert( 28 );   arbol.insert( 27 );
    arbol.insert( 9 );

    arbol.inOrderTrav();
    System.out.println("");
    arbol.remove(50);
    arbol.inOrderTrav();
    System.out.println("");
    arbol.remove(25);
      arbol.inOrderTrav();
    

    
    
	
  }

}//end class
