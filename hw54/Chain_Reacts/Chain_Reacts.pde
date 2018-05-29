// Chaud ( Fiona Cai, Kayli Matsuyoshi, Ben Platt )
// APCS2 pd1
// Lab04 -- All That Bouncin’
// 2018-05-24r

import java.util.ArrayList;

ArrayList<Ball> balls = new ArrayList<Ball>();
boolean mouse = false;

Ball growBall;

void setup() {
  background(0); 
  size( 600, 600 );
  for ( int i = 0; i < 24; i++ ) {
    balls.add( new Ball() );
  }
}

void draw() {
  background(0); 
  for ( int i = 0; i < 24; i++ ) {
    balls.get(i).move();
  }
  if ( mouse ) {
    if ( growBall.shrink == false ) {
      growBall.grow();
      if ( growBall.rad >= growBall.MAX_RADIUS ) {
        growBall.shrink = true;
      }
    }
    if ( growBall.shrink ) {
      growBall.shrink();
    }
    if ( growBall.rad <= 0 ) {
      mouse = false;
    }
    for ( int i = 0; i < 24; i++ ) {
      balls.get(i).stick();
    }
  }
}

void mouseClicked() { 
  growBall = new Ball( mouseX, mouseY ); 
  mouse = true;
}
