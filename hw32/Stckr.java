// Kayli Matsuyoshi
// APCS2 pd1
// HW32 -- Leon Leonwood Stack
// 2018-04-12r

/*****************************************************
 * class Stckr
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{    
    public static void main( String[] args )
    {
	//Stack cakes = new ALStack(3);
	Stack cakes = new LLStack();
	cakes.push( "bottom tier" );
	cakes.push( "middle tier" );
	System.out.println(cakes.peek()); // middle tier
	cakes.push( "top tier" );
	System.out.println(cakes.pop()); // top tier
	System.out.println(cakes.pop()); // middle tier
	System.out.println(cakes.isEmpty()); // false
	System.out.println(cakes.pop()); // bottom tier
	System.out.println(cakes.isEmpty()); // true
    }

}//end class

