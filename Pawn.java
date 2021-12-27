import java.util.*;
import java.awt.Color;

public class Pawn	extends Gamepiece{
	
   Color color;
	
      //Pawn constructor takes a point location and Gamepiece color
   public Pawn(Point p, Color c){
      super(p, "Pawn", c);
      color = c;
   }
	
      //creates an ArrayList containing all possible moves for the selected Pawn
   public ArrayList getValidMoves(Button[][] board, Point p){
      ArrayList<Point> validMoves = new ArrayList<Point>();
      int x = p.getX();
      int y = p.getY();
      
         //Creates all possible moves for white pawn
      if(board[x][y].getGamepiece().getColor() == Color.white){	
         Point p1 = new Point(x, y+1);
         Point p2 = new Point(x, y+2);
         Point po1 = new Point(x+1, y+1);
         Point po2 = new Point(x-1, y+1);
      	
            //checks if moving forward one is valid and adds to validMoves
         if(y < 7 && board[x][y+1].getGamepiece() == null) validMoves.add(p1);
         
            //checks if moving forward two is valid and adds to validMoves
         if(y == 1 && board[x][y+1].getGamepiece() == null && board[x][y+2].getGamepiece() == null) validMoves.add(p2);
         
      	   //checks if diagonals are valid and adds only if on board and capturing opposite color Gamepiece
         if(x == 0){
            if(board[x+1][y+1].getGamepiece() != null){
               validMoves.add(po1);
            }
         }
         else if(x == 7){
            if(board[x-1][y+1].getGamepiece() != null){
               validMoves.add(po2);
            }
         }
         
/********TODO********TODO********TODO********TODO********/         
//had exception when white Pawn mad it all the way across Board  
       
         else if(x != 0 && x != 7){
            if(board[x+1][y+1].getGamepiece() != null){
               validMoves.add(po1);
            }
            if(board[x-1][y+1].getGamepiece() != null){
               validMoves.add(po2);
            }
         }
      }
      
         //Creates all possible moves for black pawn
      if(board[x][y].getGamepiece().getColor() == Color.black){
         Point p1 = new Point(x, y-1);
         Point p2 = new Point(x, y-2);
         Point po1 = new Point(x+1, y-1);
         Point po2 = new Point(x-1, y-1);
      	
            //checks if moving forward one is valid and adds to validMoves
         if(y > 0 && board[x][y-1].getGamepiece() == null) validMoves.add(p1);
         
            //checks if moving forward two is valid and adds to validMoves
         if(y == 6 && board[x][y-1].getGamepiece() == null && board[x][y-2].getGamepiece() == null) validMoves.add(p2);
         
      	   //checks if diagonals are valid and adds only if on board and capturing opposite color Gamepiece
         if(x == 0){
            if(board[x+1][y-1].getGamepiece() != null){
               validMoves.add(po1);
            }
         }
         else if(x == 7){
            if(board[x-1][y-1].getGamepiece() != null){
               validMoves.add(po2);
            }
         }
         else if(x != 0 && x != 7){
            if(board[x+1][y-1].getGamepiece() != null){
               validMoves.add(po1);
            }
            if(board[x-1][y-1].getGamepiece() != null){
               validMoves.add(po2);
            }
         }
      }
      return validMoves;
   }
}