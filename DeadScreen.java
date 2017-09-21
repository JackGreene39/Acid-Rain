import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import java.awt.Font;

public class DeadScreen
{
	int score;
	private Color pressed;
	public DeadScreen(int s)
	{
		score = s;
		pressed = new Color(58,162,23);
	}
	
	public void draw(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 32));
		window.drawString("Final Score: "+score,250,100);
	}
	public void clear(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,800,600);
	}
	public void drawPlay(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(200,175,300,100); 
		window.setColor(pressed);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.drawString("Play Again", 260,235); 
	}
	public void pressPlay(Graphics window)
	{
		window.setColor(pressed);
		window.fillRect(203,178,294,94);
		window.setColor(Color.GREEN);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.drawString("Play Again", 260,235);
	}
	public void drawMain(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(200,325,300,100);
		window.setColor(pressed);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.drawString("Back to",280,360);
		window.drawString("Main Menu",260,410);
	}
	public void pressMain(Graphics window)
	{
		window.setColor(pressed);
		window.fillRect(203,328,294,94);
		window.setColor(Color.GREEN);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 36));
		window.drawString("Back to",280,360);
		window.drawString("Main Menu",270,410);
	}
}