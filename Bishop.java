import java.util.*;
import java.awt.Color;

public class Bishop extends Gamepiece	{
	
   private Color color;
   
      //Bishop constructor takes a point location and Gamepiece color
   public Bishop(Point p, Color c){
      super(p, "Bishop", c);
      color = c;
   }
	
      //creates an ArrayList containing all possible moves for the selected Bishop
   public ArrayList getValidMoves(Button[][] board, Point p){
      ArrayList<Point> validMoves = new ArrayList<Point>();
      int x = p.getX();
      int y = p.getY();
      
         //adds all points until first Gamepiece in the (+X, +Y) direction
      for(int i = 1; x+i <= 7 && y+i <= 7 && (board[x+i][y+i].getGamepiece() == null || !board[x+i][y+i].getGamepiece().getColor().equals(color)); i++){	//adds diagonal in (+,+) direction to validMoves
         Point p1 = new Point(x+i, y+i);
         validMoves.add(p1);
         if(board[x+i][y+i].getGamepiece() != null && board[x+i][y+i].getGamepiece().getColor() != color){
            i+=10;
         }		
      }
      
         //adds all points until first Gamepiece in the (-X, -Y) direction
      for(int i = 1; x-i >= 0 && y-i >= 0 && (board[x-i][y-i].getGamepiece() == null || !board[x-i][y-i].getGamepiece().getColor().equals(color)); i++){	//adds diagonal in (-,-) direction to validMoves
         Point p1 = new Point(x-i, y-i);
         validMoves.add(p1);
         if(board[x-i][y-i].getGamepiece() != null && board[x-i][y-i].getGamepiece().getColor() != color){
            i+=10;
         }			
      }
      
         //adds all points until first Gamepiece in the (+X, -Y) direction
      for(int i = 1; x+i <= 7 && y-i >= 0 && (board[x+i][y-i].getGamepiece() == null || !board[x+i][y-i].getGamepiece().getColor().equals(color)); i++){	//adds diagonal in (+,-) direction to validMoves
         Point p1 = new Point(x+i, y-i);
         validMoves.add(p1);
         if(board[x+i][y-i].getGamepiece() != null && board[x+i][y-i].getGamepiece().getColor() != color){
            i+=10;
         }	
      }
      
      //adds all points until first Gamepiece in the (-X, +Y) direction
      for(int i = 1; x-i >= 0 && y+i <= 7 && (board[x-i][y+i].getGamepiece() == null || !board[x-i][y+i].getGamepiece().getColor().equals(color)); i++){	//adds diagonal in (-,+) direction to validMoves
         Point p1 = new Point(x-i, y+i);
         validMoves.add(p1);	
         if(board[x-i][y+i].getGamepiece() != null && board[x-i][y+i].getGamepiece().getColor() != color){
            i+=10;
         }		
      }
      return validMoves;
   }	
}