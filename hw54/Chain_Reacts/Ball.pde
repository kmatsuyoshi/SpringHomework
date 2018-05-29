// Chaud ( Fiona Cai, Kayli Matsuyoshi, Ben Platt )
// APCS2 pd1
// Lab04 -- All That Bouncin’
// 2018-05-24r

class Ball {

  final static int MOVING = 0;
  final static int GROWING = 1;
  final static int SHRINKING = 2;
  final static int DEAD = 3;

  final float CHANGE_FACTOR = 1;
  final float MAX_RADIUS = 100;
  
  boolean shrink = false;
  
  float rad;
  float xCor;
  float yCor;
  color ballColor;
  float xSpeed;
  float ySpeed;

  Ball() {
    xCor = random( 35, 565 );  
    yCor = random( 35, 565 );
    xSpeed = random( 1, 10 );
    ySpeed = random( 1, 10 );
    ballColor = color( random( 0, 255), random( 0, 255), random( 0, 255 ));
  }

  Ball( int inputX, int inputY) {
    xCor = inputX;  
    yCor = inputY;
    xSpeed = random( 1, 20 );
    ySpeed = random( 1, 20 );
    ballColor = color( random( 0, 255), random( 0, 255), random( 0, 255 ));
  }

  void move() {
    xCor += xSpeed;
    yCor += ySpeed;
    if ( xCor > 600 || xCor < 0 ) {
      xSpeed *= -1;
    }
    if ( yCor > 600 || yCor < 0 ) {
      ySpeed *= -1;
    }
    rad = 40;
    ellipse( xCor, yCor, rad, rad );
    fill( ballColor );
  }

  void grow() {
    rad += CHANGE_FACTOR;
    ellipse( xCor, yCor, rad, rad );
    fill( ballColor );
  }

  void shrink() {
    rad -= CHANGE_FACTOR;
    ellipse( xCor, yCor, rad, rad );
    fill( ballColor );
  }

  void stick() {
    if ( xCor == growBall.xCor + growBall.rad || xCor == growBall.xCor - growBall.rad || yCor == growBall.yCor + growBall.rad || yCor == growBall.yCor - growBall.rad ) {
      if ( !shrink ) {
        grow();
        if ( rad >= MAX_RADIUS ) {
          shrink = true;
        }
      }
      if ( shrink ) {
        shrink();
      }
    }
  }
}
