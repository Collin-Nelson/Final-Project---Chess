import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackVictoryFrame extends JFrame {
   
      //Frame constructor for the Black victory display
	public BlackVictoryFrame(String title){
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
      JLabel label1 = new JLabel("Congradulations! Black wins!!");
      add(label1);
	}
	
      //main for the Black victory display
	public static void main(String[] args){
		JFrame frame = new BlackVictoryFrame("Congradulations! Black wins!!");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}