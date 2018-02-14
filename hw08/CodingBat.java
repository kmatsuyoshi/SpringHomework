// Honk Honk Radish ( Taaseen Ali, Kayli Matsuyoshi ) Team 01
// APCS2 pd1
// HW08 -- Warm It Up
// 2018-02-15r

public class CodingBat {

    // bunnyEars
    public int bunnyEars(int bunnies) {
	if (bunnies > 0) {
	    return bunnyEars( bunnies - 1 ) + 2;
	}
	else {
	    return 0;
	}
    }

    // bunnyEars2
    public int bunnyEars2(int bunnies) {
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
    public int sumDigits(int n) {
	if ( n >= 10 ) {
	    return sumDigits( n / 10 ) + ( n % 10 );
	}
	else {
	    return n % 10;
	}
    }

    // factorial
    public int factorial(int n) {
	if ( n == 1 ) {
	    return n;
	}
	else {
	    return n * factorial( n - 1 );
	}
    }

    // triangle 
    public int triangle(int rows) {
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
    public int fibonacci(int n) {
	if ( n == 0 ) {
	    return 0;
	}
	else if ( n == 1 ) {
	    return 1;
	}
	else {
	    return fibonacci( n - 1 ) +  + fibonacci( n - 2 );
	}
    }
    
}
