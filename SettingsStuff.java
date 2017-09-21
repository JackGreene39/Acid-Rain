import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import java.awt.Font;

public class SettingsStuff
{
	private int diff;
	private String song;
	private Color pressed;
	public SettingsStuff()
	{
		diff = 1;
		song = "Shooting Stars";
		pressed = new Color(58,162,23);
	}
	public int getDifficulty(){ return diff;}
	public String getSong(){ return song;}
	public void setDifficulty(int d){ diff = d;}
	public void setSong(String s){ song = s;}
	
	public void drawBox(Graphics window)
	{
		window.setColor(pressed);
		window.fillRect(200,75,350,400);
		window.setColor(Color.GREEN);
		window.fillRect(203,78,344,115);
		window.fillRect(203,198,344,273);
		window.setColor(pressed);
		window.fillRect(206,81,338,109);
		window.fillRect(206,201,338,267);
		window.setColor(Color.GREEN);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 18));
		window.drawString("Choose a difficulty",300,95);
		window.drawString("Choose a song",310,220);
	}
	public void drawDiff(Graphics window)
	{
	 	window.setColor(Color.GREEN);
	 	window.fillRect(213,101,104,80);
	 	window.fillRect(322,101,104,80);
	 	window.fillRect(431,101,104,80);
	 	window.setColor(pressed);
	 	window.setFont(new Font("Britannic Bold",Font.PLAIN, 30));
	 	window.drawString("Easy",235,147);
	 	window.drawString("Medium",323,147);
	 	window.drawString("Hard",450,147);
	}
	public void drawSong(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillRect(213,225,324,50);
		window.fillRect(213,285,324,50);
		window.fillRect(213,345,324,50);
		window.fillRect(213,405,324,50);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 22));
		window.setColor(pressed);
		window.drawString("Shooting Stars // Bag Raiders",225,255);
		window.drawString("Ocean Man // Ween", 280,315);
		window.drawString("All Star // Smash Mouth", 255, 375);
		window.drawString("Photograph // Nickelback", 253, 435);
	}
	public void pressSong(Graphics window)
	{
		window.setColor(pressed);
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 22));
		if (song.equals("Shooting Stars"))
		{
			window.fillRect(216,228,318,44);
			window.setColor(Color.GREEN);
			window.drawString("Shooting Stars // Bag Raiders",225,255);
		}
		if (song.equals("Ocean Man"))
		{
			window.fillRect(216,288,318,44);
			window.setColor(Color.GREEN);
			window.drawString("Ocean Man // Ween", 280,315);
		}
		if (song.equals("All Star"))
		{
			window.fillRect(216,348,318,44);
			window.setColor(Color.GREEN);
			window.drawString("All Star // Smash Mouth", 255, 375);
		}
		if (song.equals("Photograph"))
		{
			window.fillRect(216,408,318,44);
			window.setColor(Color.GREEN);
			window.drawString("Photograph // Nickelback", 253, 435);
		}
	}
	public void pressDiff(Graphics window)
	{
		window.setFont(new Font("Britannic Bold",Font.PLAIN, 30));
		if (diff == 1)
		{
			window.setColor(pressed);
			window.fillRect(216,104,98,74);
			window.setColor(Color.GREEN);
			window.drawString("Easy",235,147);
		}
		if (diff == 2)
		{
			window.setColor(pressed);
			window.fillRect(325,104,98,74);
			window.setColor(Color.GREEN);
			window.drawString("Medium",323,147);
		}
		if (diff == 3)
		{
			window.setColor(pressed);
			window.fillRect(434,104,98,74);
			window.setColor(Color.GREEN);
			window.drawString("Hard",450,147);
		}
	}
	public void back(Graphics window)
	{
		window.setColor(Color.GREEN);
		window.fillOval(20,10,50,50);
		window.setColor(pressed);
		int[] xPoints = {25,45,45,65,65,45,45};
		int[] yPoints = {35,15,28,28,42,42,55};
		window.fillPolygon(xPoints,yPoints,7);
	}
	public void pressBack(Graphics window)
	{
		window.setColor(pressed);
		window.fillOval(20,10,50,50);
		window.setColor(Color.GREEN);
		int[] xPoints = {25,45,45,65,65,45,45};
		int[] yPoints = {35,15,28,28,42,42,55};
		window.fillPolygon(xPoints,yPoints,7);
	}
}