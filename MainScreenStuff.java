import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import java.awt.Font;

public class MainScreenStuff
{
	private Color pressed;
	public MainScreenStuff()
	{
		pressed = new Color(58,162,23);
	}
	public void drawControls(Graphics window)
	{
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.setColor(Color.GREEN);
		window.drawString("Controls: ",250,150);
		window.drawString("A = Left", 250,200);
		window.drawString("D = Right", 250,250);
		window.drawString("Avoid the ACID RAIN",200,300);
	}
	public void drawPlay(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(200,100,300,100); 
		window.setColor(pressed);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.drawString("Play Game", 260,160); 
	}
	public void drawSettings(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(250,275,200,75);
		window.setColor(pressed);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 28));
		window.drawString("Settings", 300,315);
	}
	public void pressPlay(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(200,100,300,100);
		window.setColor(pressed);
		window.fillRect(203,103,294,94);
		window.setColor(Color.GREEN);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.drawString("Play Game", 260,160);
	}
	public void pressSet(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(250,275,200,75);
		window.setColor(pressed);
		window.fillRect(253,278,194,69);
		window.setColor(Color.GREEN);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 28));
		window.drawString("Settings", 300,315);
	}
	public void clear(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,800,605);
	}
}