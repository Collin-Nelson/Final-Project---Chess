import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckFrame extends JFrame {

      //Frame constructor for the White victory display
	public CheckFrame(String title){
		super(title);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
      JLabel label1 = new JLabel("Check!");
      add(label1);
	}
	   
      //main for the White victory display
	public static void main(String[] args){
		JFrame frame = new CheckFrame("Check!");
		//frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

