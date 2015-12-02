import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class firstemperiment extends PApplet {

  float
  rm;
  float bm;
  boolean blue;
  boolean ascending;
  int upperBound = 300;
  int lowerBound = -100;
  int w;
  int h;
public void setup() {
  
  w = displayWidth;
  h = displayHeight;
  size(w,h);
  frameRate(24);
  
  spiralScratch(250, 250);
  //for(int i = 0; i < 1000; i++){
  //  draw();
  //}
  rm = 199;
  bm = 0;
  blue = true;
  ascending = true;
}

public void spiralScratch(float xpos, float ypos) {
  float x1, x2, y1, y2;
  float step = 5 + (random(4) - 4);
  strokeWeight(1);
  
   stroke(random(50)+rm, random(30), random(50)+bm, 70);
   print(rm);
   if(blue&&ascending){
      bm=bm+.2f; 
      print("b up");
   } else if(blue&&!ascending){
      bm=bm-.2f; 
      print("b down");
   }
   else if(!blue&&ascending){
      rm= rm + .2f;
      print("red up");
   } else if(!blue&&!ascending){
      rm=rm-.2f;
      print("red down");
   }
   if(bm>upperBound){
     ascending = false;
     blue = false;
     bm = upperBound;  
 }
   if(rm<lowerBound){
     ascending = true;
     blue = false;
     print("true");
     rm = 0;
   }    if(rm>upperBound){
     print("nn");
     ascending = false;
     blue = true;
     rm = upperBound;
   }
      if(bm<lowerBound){
     ascending = true;
     blue = true;
     bm = 0;
   }  
  float radius = 5;
  float rad = radians(90);
  x1 = xpos;
  y1 = ypos;
  for (int x = 0; x < (360 * 4); x+= step) {
    radius += (1 + (random(4) - 2));
    
    rad = radians(x + step);
    x2 = xpos + (radius * cos(rad))  + (random(4) - 2);
    y2 = ypos + (radius * sin(rad))  + (random(4) - 2);
    // draw line to it
   line(x1, y1, x2, y2);
   x1 = x2; y1 = y2;
  } 
}

public void draw() {
  // clearBackground();
  spiralScratch(random(w), random(h));
}
  public void settings() {  size(displayWidth, displayHeight);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "firstemperiment" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
