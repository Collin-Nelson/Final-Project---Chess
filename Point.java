
public class Point	{
	
   private int x;
   private int y;
	
      //creates a new Point
   public Point(int mx, int my){
      x = mx;
      y = my;
   }
	
      //returns the X coordinate of the Point
   public int getX(){
      return x;
   }
	
      //returns the Y coordinate of the Point
   public int getY(){
      return y;
   }
	
      //sets a new X value for the Point
   public void setX(int mx){
      x = mx;
   }
	
      //sets a new Y value for the Point
   public void setY(int my){
      y = my;
   }
	
      //returns the Point as a String
   public String toString(){
      return "("+x+","+y+")";
   }
	
      //boolean equals method for Point
   public boolean equals(Object o){
      Point p = (Point) o;
      return p.getX() == x && p.getY() == y;
   }	
}