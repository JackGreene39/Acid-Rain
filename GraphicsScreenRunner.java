import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GraphicsScreenRunner extends JFrame
{
		private static final int WIDTH = 800;
		private static final int HEIGHT = 605;

	public GraphicsScreenRunner(int screen2, int s, int diff, String song)
	{
		super("MainScreen");
		setSize(WIDTH,HEIGHT);

		MainScreen screen = new MainScreen(screen2,s,diff,song);
		((Component)screen).setFocusable(true);
		getContentPane().add(screen);
		
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[])
	{
		GraphicsScreenRunner run = new GraphicsScreenRunner(1,0,1,"Shooting Stars");
	}
}