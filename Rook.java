import java.util.*;
import java.awt.Color;

public class Rook extends Gamepiece	{
	
	private Color color;
	
      //Rook constructor takes a point location and Gamepiece color
	public Rook(Point p, Color c){
		super(p, "Rook", c);
		color = c;
	}
	
      //creates an ArrayList containing all possible moves for the selected Rook
	public ArrayList getValidMoves(Button[][] board, Point p){
		ArrayList<Point> validMoves = new ArrayList<Point>();
		int x = p.getX();
		int y = p.getY();
	   
         //adds current row in +X direction to validMoves
		for(int i = x+1; i <= 7 && (board[i][y].getGamepiece() == null || !board[i][y].getGamepiece().getColor().equals(color)); i++){
         Point p1 = new Point(i, y);
         validMoves.add(p1);
         if(board[i][y].getGamepiece() != null && board[i][y].getGamepiece().getColor() != color){
            i+=10;
         }
		}
      
         //adds current row in -X direction to validMoves
		for(int i = x-1; i >= 0 && (board[i][y].getGamepiece() == null || !board[i][y].getGamepiece().getColor().equals(color)); i--){
			Point p1 = new Point(i, y);
			validMoves.add(p1);
         if(board[i][y].getGamepiece() != null && board[i][y].getGamepiece().getColor() != color){
            i-=10;
         }
		}
      
         //adds current column in +Y direction to validMoves
		for(int i = y+1; i <= 7 && (board[x][i].getGamepiece() == null || !board[x][i].getGamepiece().getColor().equals(color)); i++){
			Point p1 = new Point(x, i);
			validMoves.add(p1);
         if(board[x][i].getGamepiece() != null && board[x][i].getGamepiece().getColor() != color){
            i+=10;
         }
		}
      
         //adds current column in -Y direction to validMoves
		for(int i = y-1; i >= 0 && (board[x][i].getGamepiece() == null || !board[x][i].getGamepiece().getColor().equals(color)); i--){
			Point p1 = new Point(x, i);
			validMoves.add(p1);
         if(board[x][i].getGamepiece() != null && board[x][i].getGamepiece().getColor() != color){
            i-=10;
         }
		}
		return validMoves;
	}
	
	
}