import java.util.*;
import java.awt.Color;

public abstract class Gamepiece	{
	
   private Point pos;
   private Color color;
   private String name;
	
      //sets the starting position of the Gamepiece
   public Gamepiece(Point point, String n, Color c){	
      pos = point;
      name = n;
      color = c;
   }
	
      //returns the Point Gamepiece is at
   public Point getPos(){		
      return pos;
   }
	
      //sets the Point the Gamepiece is at	
   public void setPos(Point p){		
      pos = p;
   }
	
      //returns an ArrayList of all valid moves for a given gamepiece
   public abstract ArrayList getValidMoves(Button[][] board, Point p);

      //returns the color of the gamepiece	
   public Color getColor(){
      return color;
   }
	
      //returns the name (piece type) of the Gamepiece
   public String getName(){
      return name;
   }
}