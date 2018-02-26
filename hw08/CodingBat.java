// Honk Honk Radish ( Taaseen Ali, Kayli Matsuyoshi ) Team 01
// APCS2 pd1
// HW08 -- Warm It Up
// 2018-02-15r

public class CodingBat {

    // bunnyEars
    public static int bunnyEars(int bunnies) {
	if (bunnies > 0) {
	    return bunnyEars( bunnies - 1 ) + 2;
	}
	else {
	    return 0;
	}
    }

    // bunnyEars2
    public static int bunnyEars2(int bunnies) {
	if ( bunnies > 0 ) {
	    if ( bunnies % 2 == 0 ) {
		return 3 + bunnyEars2(bunnies - 1);
	    }
	    else {
		return 2 + bunnyEars2(bunnies - 1);
	    }
	}
	else {
	    return 0;
	}
    }

    // sumDigits
    public static int sumDigits(int n) {
	if ( n >= 10 ) {
	    return sumDigits( n / 10 ) + ( n % 10 );
	}
	else {
	    return n % 10;
	}
    }

    // factorial
    public static int factorial(int n) {
	if ( n == 1 ) {
	    return n;
	}
	else {
	    return n * factorial( n - 1 );
	}
    }

    // triangle 
    public static int triangle(int rows) {
	if ( rows > 1 ) {
	    return rows + triangle( rows - 1 );
	}
	else if ( rows == 1) {
	    return 1;
	}
	else {
	    return 0;
	}
    }

    // fibonacci
    public static int fibonacci(int n) {
	if ( n == 0 ) {
	    return 0;
	}
	else if ( n == 1 ) {
	    return 1;
	}
	else {
	    return fibonacci( n - 1 ) +  + fibonacci( n - 2 );	}
    }

    // MAIN METHOD
    public static void main( String args[] ) {

	System.out.println( "Testing bunnyEars..." );

	System.out.println( "No bunnies :<" );
        System.out.println( "Ears: " + bunnyEars(0) ); // 0
	System.out.println( "1 Bunny" );
	System.out.println( "Ears: " + bunnyEars(1) ); // 2
	System.out.println( "2 Bunnies" );
	System.out.println( "Ears: " + bunnyEars(2) ); // 4
	System.out.println( "9 Bunnies" );
	System.out.println( "Ears: " + bunnyEars(9) ); // 18
	
	System.out.println( "...................... " );
	
       	System.out.println( "Testing bunnyEars2... " );
        
	System.out.println( "No bunnies :<" );
	System.out.println( "Ears: " + bunnyEars2(0) ); // 0
	System.out.println( "1 Bunny" );
	System.out.println( bunnyEars2(1) ); // 2
	System.out.println( "2 Bunnies" );
	System.out.println( bunnyEars2(2) ); // 5
	System.out.println( "9 Bunnies" );
	System.out.println( bunnyEars2(9) ); // 22
	
	System.out.println( "...................... " );
	
	System.out.println( "Testing sumDigits... " );

	System.out.println( "Number: 0" );
	System.out.println( sumDigits(0) ); // 0
	System.out.println( "Number: 1" );
	System.out.println( sumDigits(1) ); // 1
	System.out.println( "Number: 159" );
	System.out.println( sumDigits(159) ); // 15
	System.out.println( "Number: 167253" );
	System.out.println( sumDigits(167253) ); // 24
	
	System.out.println( "...................... " );

	System.out.println( "Testing factorial... " );

	System.out.println( "...................... " );

	System.out.println( "Testing triangle... " );

	System.out.println( "...................... " );

	System.out.println( "Testing fibonacci... " );

	System.out.println( "...................... " );
	
    }
}
