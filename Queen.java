import java.util.*;
import java.awt.Color;

public class Queen extends Gamepiece	{
	
   private Color color;
   
   //Queen constructor takes a point location and Gamepiece color
	public Queen(Point p, Color c){
		super(p, "Queen", c);
      color = c;
	}
	
      //creates an ArrayList containing all possible moves for the selected Queen
	public ArrayList getValidMoves(Button[][] board, Point p){
		ArrayList<Point> validMoves = new ArrayList<Point>();
      int x = p.getX();
      int y = p.getY();
      
         //adds row in +X direction to validMoves
      for(int i = x+1; i <= 7 && (board[i][y].getGamepiece() == null || !board[i][y].getGamepiece().getColor().equals(color)); i++){
			Point p1 = new Point(i, y);
         validMoves.add(p1);
         if(board[i][y].getGamepiece() != null && board[i][y].getGamepiece().getColor() != color){
            i+=10;
         }
		}
      
         //adds row in the -X direction to validMoves
		for(int i = x-1; i >= 0 && (board[i][y].getGamepiece() == null || !board[i][y].getGamepiece().getColor().equals(color)); i--){
			Point p1 = new Point(i, y);
			validMoves.add(p1);
         if(board[i][y].getGamepiece() != null && board[i][y].getGamepiece().getColor() != color){
            i-=10;
         }
		}
      
           //adds column in the +Y direction to validMoves
		for(int i = y+1; i <= 7 && (board[x][i].getGamepiece() == null || !board[x][i].getGamepiece().getColor().equals(color)); i++){
			Point p1 = new Point(x, i);
			validMoves.add(p1);
         if(board[x][i].getGamepiece() != null && board[x][i].getGamepiece().getColor() != color){
            i+=10;
         }
		}
      
         //adds column in the -Y direction to validMoves
		for(int i = y-1; i >= 0 && (board[x][i].getGamepiece() == null || !board[x][i].getGamepiece().getColor().equals(color)); i--){
			Point p1 = new Point(x, i);
			validMoves.add(p1);
         if(board[x][i].getGamepiece() != null && board[x][i].getGamepiece().getColor() != color){
            i-=10;
         }
		}
      
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