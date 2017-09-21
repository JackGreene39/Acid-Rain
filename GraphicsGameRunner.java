import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class GraphicsGameRunner extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 605;

	public GraphicsGameRunner(int diff, String song)
	{
		super("AcidRain");
		setSize(WIDTH,HEIGHT);

		AcidRain game = new AcidRain(diff,song);
		((Component)game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}