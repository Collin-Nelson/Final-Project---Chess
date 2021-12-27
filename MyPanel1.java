import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel1 extends JPanel implements ActionListener, KeyListener{
	private JTextField field;
	private int x = 100;
	private int y = 100;
	private int speed = 15;
	public MyPanel1(){
		super();
		//setLayout(new GridLayout(3,2));
		
		JButton b1 = new JButton("Hello");
		add(b1);
		b1.addActionListener(this);
		
		add(new JLabel("This is text"));
		add(new JLabel("Press my button"));
		field = new JTextField();
		field.setText("Hello");
		add(field);
		Timer t = new Timer(50, this);
		t.start();
		setFocusable(true);
		requestFocus();
		addKeyListener(this);
		addMouseListener(new MyMouseClass());
	}
	
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x,y,200,50);
	}
		
	
	public void actionPerformed(ActionEvent e){
			x+=speed;
			repaint();
			if(x < 0 || (speed > 0 && x > getWidth()-200))
				speed = -speed;
	}	
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP)
			y-= 10;
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			y+= 10;
	}
	
	public void keyReleased(KeyEvent e){
		System.out.println("Key released.");
	}
	
	public void keyTyped(KeyEvent e){
		
	}
	
	private class MyMouseClass extends MouseAdapter {
	
	public void mousePressed(MouseEvent e){
		int newX = e.getX();
		int newY = e.getY();
		x = newX;
		y = newY;
	
	}
	}
	


}

