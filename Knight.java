import java.util.*;
import java.awt.Color;

public class Knight extends Gamepiece	{
	
      //Knight constructor takes a point location and Gamepiece color
   public Knight(Point p, Color c){
      super(p, "Knight", c);
   }
	
      //creates an ArrayList containing all possible moves for the selected Knight
   public ArrayList getValidMoves(Button[][] board, Point p){
      ArrayList<Point> validMoves = new ArrayList<Point>();
      int x = p.getX();
      int y = p.getY();
      
   	   //creates a Point for all 8 possible destinations
      Point p1 = new Point(x+2, y+1);
      Point p2 = new Point(x+1, y+2);
      Point p3 = new Point(x+2, y-1);
      Point p4 = new Point(x+1, y-2);
      Point p5 = new Point(x-2, y+1);
      Point p6 = new Point(x-1, y+2);
      Point p7 = new Point(x-2, y-1);
      Point p8 = new Point(x-1, y-2);
   	
   	   //checks that all points are on the board and adds them to validMoves
      if((p1.getX() <= 7 && p1.getX() >= 0) && (p1.getY() <= 7 && p1.getY() >= 0)) validMoves.add(p1);
      if((p2.getX() <= 7 && p2.getX() >= 0) && (p2.getY() <= 7 && p2.getY() >= 0)) validMoves.add(p2);
      if((p3.getX() <= 7 && p3.getX() >= 0) && (p3.getY() <= 7 && p3.getY() >= 0)) validMoves.add(p3);
      if((p4.getX() <= 7 && p4.getX() >= 0) && (p4.getY() <= 7 && p4.getY() >= 0)) validMoves.add(p4);
      if((p5.getX() <= 7 && p5.getX() >= 0) && (p5.getY() <= 7 && p5.getY() >= 0)) validMoves.add(p5);
      if((p6.getX() <= 7 && p6.getX() >= 0) && (p6.getY() <= 7 && p6.getY() >= 0)) validMoves.add(p6);
      if((p7.getX() <= 7 && p7.getX() >= 0) && (p7.getY() <= 7 && p7.getY() >= 0)) validMoves.add(p7);
      if((p8.getX() <= 7 && p8.getX() >= 0) && (p8.getY() <= 7 && p8.getY() >= 0)) validMoves.add(p8);
   	
      return validMoves;
   }
}