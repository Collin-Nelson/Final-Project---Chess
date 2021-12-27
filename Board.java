import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
	
public class Board extends JPanel implements ActionListener	{
   
   private Button[][] buttons = new Button[8][8];
   private Point startMovePos = null;
   private Point endMovePos = null;
   private boolean whiteTurn = true;
      
      //creates an 8 by 8 GridLayout, 2D array of Buttons, and all Gamepieces in their starting positions
   public Board(){
      setLayout(new GridLayout(8,8));
      for(int i = 0 ; i < 8; i++){
         for(int j = 0; j < 8; j++){
         
               //creates Buttons
            buttons[i][j] = new Button(i,j);
            
               //creates White Gamepieces
            if(i == 0 && j == 0 || i == 7 && j == 0){	
               buttons[i][j].setGamepiece(new Rook(new Point(i, j), Color.white));
            }
            if(i == 1 && j == 0 || i == 6 && j == 0){
               buttons[i][j].setGamepiece(new Knight(new Point(i, j), Color.white));
            }
            if(i == 2 && j == 0 || i == 5 && j == 0){
               buttons[i][j].setGamepiece(new Bishop(new Point(i, j), Color.white));
            }
            if(i == 3 && j == 0){
               buttons[i][j].setGamepiece(new Queen(new Point(i, j), Color.white));
            }
            if(i == 4 && j == 0){
               buttons[i][j].setGamepiece(new King(new Point(i, j), Color.white));
            }
            if(j == 1){
               buttons[i][j].setGamepiece(new Pawn(new Point(i, j), Color.white));
            }
            
               //creates Black Gamepieces
            if(i == 0 && j == 7 || i == 7 && j == 7){
               buttons[i][j].setGamepiece(new Rook(new Point(i, j), Color.black));
            }
            if(i == 1 && j == 7 || i == 6 && j == 7){
               buttons[i][j].setGamepiece(new Knight(new Point(i, j), Color.black));
            }
            if(i == 2 && j == 7 || i == 5 && j == 7){
               buttons[i][j].setGamepiece(new Bishop(new Point(i, j), Color.black));
            }
            if(i == 3 && j == 7){
               buttons[i][j].setGamepiece(new Queen(new Point(i, j), Color.black));
            }
            if(i == 4 && j == 7){
               buttons[i][j].setGamepiece(new King(new Point(i, j), Color.black));
            }
            if(j == 6){
               buttons[i][j].setGamepiece(new Pawn(new Point(i, j), Color.black));
            }
               
            add(buttons[i][j]);
            buttons[i][j].addActionListener(this);
         }
      }
         
         //adds Gamepiece Images to the Buttons according to what Gamepiece is at that Button
      for(int i = 0; i < 8; i++){
         for(int j = 0; j < 8; j++){
            if(j > 5){
               buttons[i][j].setIcon(new ImageIcon("black " + buttons[i][j].getGamepiece().getName()+".png"));
            }
            if(j < 2){
               buttons[i][j].setIcon(new ImageIcon("white " + buttons[i][j].getGamepiece().getName()+".png"));
            }
         }
      } 
   }		
	   
      //controls Gamepiece movement and manages Buttons clicks
   public void actionPerformed(ActionEvent e){    
      Button btn = (Button)e.getSource();      
      Gamepiece p = btn.getGamepiece();
      int x = btn.getPos().getX();  //sets x and y equal to the x and y coordinates of the last button pressed
      int y = btn.getPos().getY();
      endMovePos = new Point(x, y); //sets endMovePos equal to the last button pressed
      int ex = endMovePos.getX();   //sets ex and ey to abbreviate endMovePos.getX() and endMovePos.getY()
      int ey = endMovePos.getY();
      Gamepiece gpe = buttons[ex][ey].getGamepiece();
         
         //sets startMovePos as the clicked button location if no other button has been clicked
      if(startMovePos == null && p != null){
         startMovePos = new Point(x, y);
      }
         
         //deselects startMovePos if the startMovePos button is clicked for a second time
      else if(startMovePos != null && btn.getPos().equals(startMovePos)){
         startMovePos = null;
         p = null;
         endMovePos = null;
         btn = null;
      }
         
         //moves the gamepiece
      else if(startMovePos != null && (p == null || !gpe.getColor().equals(buttons[startMovePos.getX()][startMovePos.getY()].getGamepiece().getColor()))){
            
            //Abbrivaiates startMovePos's getX(), getY(), Gamepiece, and Gamepiece's color and creates an ArrayList of possible moves
         int sx = startMovePos.getX();
         int sy = startMovePos.getY();
         ArrayList<Point> moves = buttons[sx][sy].getGamepiece().getValidMoves(buttons, startMovePos);
         Gamepiece gps = buttons[sx][sy].getGamepiece();
         Color Cgps = gps.getColor();
            
            //ValidMoves implementation
         if(moves.contains(endMovePos) && (whiteTurn && Cgps == Color.white || !whiteTurn && Cgps == Color.black)){
         
               //displays congratulatory message and the winning color when a king is taken
            if(buttons[ex][ey].getGamepiece() != null && buttons[ex][ey].getGamepiece().getName().equals("King")){
                  
                  //White victory
               if(buttons[ex][ey].getGamepiece() != null && buttons[ex][ey].getGamepiece().getColor().equals(Color.black)){
                  String[] arguments = new String[] {null};
                  WhiteVictoryFrame wvf = new WhiteVictoryFrame(null);
                  wvf.main(arguments);
               }
               
                  //Black victory
               if(buttons[ex][ey].getGamepiece() != null && buttons[ex][ey].getGamepiece().getColor().equals(Color.white)){
                  String[] arguments = new String[] {null};
                  BlackVictoryFrame bvf = new BlackVictoryFrame(null);
                  bvf.main(arguments);
               }
            }            
            
               //Move Gamepiece and Icon
            btn.setGamepiece(gps);
            if(Cgps == Color.white){
               buttons[ex][ey].setIcon(new ImageIcon("white "+gps.getName()+".png"));
            }
            if(Cgps == Color.black){
               buttons[ex][ey].setIcon(new ImageIcon("black "+gps.getName()+".png"));
            }
            
            
            /********************************************************************/
         	/********TODO********TODO********TODO********TODO********TODO********/
            /********************************************************************/
               //CheckMate
               //each turn generate validMoves for both Kings, then create ArrayList of all validMoves for each color, then check if ArrayList.contains( all of King's ValidMoves )
               /*
               if it's a King
                  if King's valid moves are all contained by the validMoves of another Gamepiece && those Gamepieces can't be blocked
               
               */
               
            ArrayList<Point> allBlackMoves = new ArrayList<Point>();
            ArrayList<Point> whiteKingMoves = new ArrayList<Point>();
            
            
            for(int i = 0; i < 7; i++){
               for(int j = 0; j < 7; j++){
                  if(buttons[i][j].getGamepiece() != null && buttons[i][j].getGamepiece().getName().equals("King") && buttons[i][j].getGamepiece().getColor().equals(Color.white)){
                     ArrayList a = buttons[i][j].getGamepiece().getValidMoves(buttons, new Point(i, j));
                     for(int t = 0; t < a.size(); t++){
                        whiteKingMoves.add((Point)a.get(t));
                     }
                  }
               }
            }
            
            for(int i = 0; i < 7; i++){
               for(int j = 0; j < 7; j++){
                  if(buttons[i][j].getGamepiece() != null && buttons[i][j].getGamepiece().getColor().equals(Color.black)){
                     ArrayList a = buttons[i][j].getGamepiece().getValidMoves(buttons, new Point(i, j));
                     for(int t = 0; t < a.size(); t++){
                        allBlackMoves.add((Point)a.get(t));
                     }
                  }
               }
            }   
            
            boolean allContainsKing = true;
            
            for(int i = 0; i < whiteKingMoves.size(); i++){
               if(!allBlackMoves.contains(whiteKingMoves.get(i))){
                  allContainsKing = false;
               }
               System.out.println(allBlackMoves.get(i).toString());
            }
            
            System.out.println();
            
            if(allContainsKing){
               System.out.println("Checkmate!");
            }   
            
            
            /********END TODO********/
         	
            
            
            
            
            
            
            
                //displays a frame saying "Check!" if a King moves onto a validMove of any opposite color Gamepiece
            if(gps.getName().equals("King")){
               for(int i = 0; i <= 7; i++){
                  for(int j = 0; j <= 7; j++){
                     if(buttons[i][j].getGamepiece() != null && buttons[i][j].getGamepiece().getValidMoves(buttons, endMovePos).contains(gps.getPos()) && !buttons[i][j].getGamepiece().getColor().equals(gps.getColor())){
                        String[] arguments = new String[] {null};
                        CheckFrame cf = new CheckFrame("Check!");
                        cf.main(arguments);
                        i+=10;
                        j+=10;
                     }
                  }
               }
            }
              
               //displays a frame saying "Check!" if a Gamepiece has a king of the opposite color in it's validMoves after moving
            else{    
               for(int i = 0; i <= 7; i++){
                  for(int j = 0; j <= 7; j++){
                     if(buttons[i][j].getGamepiece() != null && buttons[i][j].getGamepiece().getName().equals("King")){
                        if(gps != null && gps.getValidMoves(buttons, endMovePos).contains(new Point(i, j)) && !buttons[i][j].getGamepiece().getColor().equals(gps.getColor())){
                           String[] arguments = new String[] {null};
                           CheckFrame cf = new CheckFrame("Check!");
                           cf.main(arguments);
                           i+=10;
                           j+=10;
                        }
                     }
                  }
               }
            }
            
               //switches the turn to the other Player
            whiteTurn = !whiteTurn;
               					
               //Deletes old Gamepiece and Icon
            buttons[sx][sy].setGamepiece(null);
            p = null;
            buttons[sx][sy].setIcon(null);
            startMovePos = null;
            endMovePos = null;
         }
      }
   }	
}