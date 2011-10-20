package aiclass.swing.pointDisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class DisplayPoints extends JPanel implements Runnable{

	
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private static final int NUMBER_OF_POINTS = 50;
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.blue);
		Dimension size = getSize();
		Insets insets = getInsets();
		
		int w = size.width - insets.left - insets.right;
		int h = size.height - insets.top - insets.bottom;
		
		Random r = new Random();
		List<Point> points = new ArrayList<Point>();
		for(int i = 0; i < NUMBER_OF_POINTS; i++)
		{
			int x = Math.abs(r.nextInt()) % w;
			int y = Math.abs(r.nextInt()) % h;
			points.add(new Point(x,y));
		}
		
		for(int i = 0; i < NUMBER_OF_POINTS-1; i++)
		{
			g2d.drawLine((int)points.get(i).getX(), (int)points.get(i).getY(),
					(int)points.get(i+1).getX(),(int)points.get(i+1).getY());
		}
	}
	
	public static void main(String args[])
	{
		JFrame frame = new JFrame("Points");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DisplayPoints());
		frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		
	}
}
