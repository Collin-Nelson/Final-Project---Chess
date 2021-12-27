import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame1 extends JFrame {
   
      //Frame constructor for the gameboard
	public MyFrame1(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(9850, 1000);
		add(new Board());
	}
	
      //main for game, creates the frame and displays it
	public static void main(String [] args){
		JFrame frame = new MyFrame1("Chess");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}