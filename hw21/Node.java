// Kayli Matsuyoshi
// APCS2 pd1
// HW21 - 
// 2018-03-20t

/*****************************************************
 * class Node -- 
 * Specifies actions a node must be able to perform.
 *****************************************************/

public class Node {

    // INSTANCE VARIABLES
    
    private Node nextNode;
    private String cargo;

    // LOADED CONSTRUCTOR

    public Node( String cargoVal ) {
	cargo = cargoVal;
    }

    public Node( String cargoVal, Node other ) {
	cargo = cargoVal;
	nextNode = other;
    }

} // end of class Node
