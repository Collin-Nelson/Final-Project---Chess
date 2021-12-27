import java.util.*;
import java.awt.Color;

public class King extends Gamepiece	{

   private Color color;
	
      //King constructor takes a point location and Gamepiece color
   public King(Point p, Color c){
      super(p, "King", c);
      color = c;
   }
	
      //creates an ArrayList containing all possible moves for the selected King
   public ArrayList getValidMoves(Button[][] board, Point p){
      ArrayList<Point> validMoves = new ArrayList<Point>();
      
         //cycles through coordinates in relation to King from X+1 to X-1 and Y+1 to Y-1
      for(int i = -1; i <= 1; i++){
         for(int j = -1; j <= 1; j++){
         
               //creates all possible moves within a 1 tile radius based on previous loops
            Point p1 = new Point(p.getX()+i, p.getY()+j);
            
               //checks that each new point is on the game board and adds it
            if((p1.getX() <= 7 && p1.getX() >= 0) && (p1.getY() <= 7 && p1.getY() >= 0)) validMoves.add(p1);
         }
      }
      return validMoves;
   }	
}