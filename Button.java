   import javax.swing.*;
   import java.awt.event.*;
   import java.awt.Color;
   import java.util.*;

   public class Button extends JButton{
   
      private Point pos;
      private Gamepiece gamepiece;
     
         //sets all Buttons white, then changes every other one to be red in checkerboard pattern
         //also sets position of Button
      public Button(int i, int j){
			setBackground(Color.white);
         if(i%2 == 0 && j%2 == 0) setBackground(Color.red);
			if(i%2 == 1 && j%2 == 1) setBackground(Color.red);
         pos = new Point(i,j);
      }
		
         //gets the position of the Button
		public Point getPos(){
			return pos;
		}
   	
         //sets the Gamepiece on that Button  
      public void setGamepiece(Gamepiece g){
         gamepiece = g;
      }
      
         //gets the Gamepiece on that Button
      public Gamepiece getGamepiece(){
         return gamepiece;
      }
   }