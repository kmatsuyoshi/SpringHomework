// Kayli Matsuyoshi
// APCS2 pd1
// HW23 - 
// 2018-03-23f

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    public LLNode nextNode;
    public String cargo;

    // constructors
    public LLNode() {
	cargo = null;
	nextNode = null;
    }

    public LLNode( String cargoString ) {
	this();
	cargo = cargoString;
    }

    public LLNode( String cargoString, LLNode next ) {
	this();
	cargo = cargoString;
	nextNode = next;
    }

    //--------------  ACCESSORS  --------------

    public String getCargo()
    {
	return cargo;
    }

    public LLNode getNext()
    {
	return nextNode;
    }
    
    //--------------  MUTATORS  --------------

    public String setCargo( String newCargo )
    {
	String oldCargo = cargo;
	cargo = newCargo;
	return oldCargo;
    }

    public LLNode setNext( LLNode newNode )
    {
	LLNode oldNode = nextNode;
        nextNode = newNode;
	return oldNode;
    }

    //--------------  TOSTRING  --------------
    // override inherited toString
    public String toString()
    {
	String returnString = "";
	returnString += "[ " + cargo + " ][ * ]--> ";
	return returnString;
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...

	LLNode zoo = new LLNode();
	LLNode wee = new LLNode();
	LLNode mama = new LLNode();
	System.out.println(zoo.setCargo( "kylie" ));
	System.out.println(zoo.setCargo( "kayli" ));
	System.out.println(wee.setCargo( "jade" ));
	System.out.println(mama.setCargo( "matsuyoshi" ));
	System.out.println(mama.getCargo());
	System.out.println(zoo.setNext( wee ));
	System.out.println(wee.setNext( mama ));
	System.out.println(zoo.toString());
	System.out.println(wee.toString());
	
    }//end main

}//end class LLNode
