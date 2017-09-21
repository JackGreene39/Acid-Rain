import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

public class AcidRain extends Canvas implements KeyListener, Runnable, MouseListener
{
	Rainfall rainfall;
	Player player;
	Music song;
	DeadScreen dead;
	private int[] scores;
	private boolean[] keys;
	private boolean add, clicked, paint, songbol;
	private int difficulty, mouseX, mouseY, screen;
	private String music;
	public AcidRain(int diff, String mus)
	{
		difficulty = diff;
		music = mus;
		song = new Music(music+".wav");
		player = new Player();
		clicked = false;
		paint = true;
		screen = 2;
		scores = new int[8];
		if (diff == 1)
		{
			scores[0] = 5; scores[1] = 15; scores[2] = 30; scores[3] = 50; scores[4] = 150; scores[5] = 300; scores[6] = 600; scores [7] = 1000;
		}
		if (diff == 2)
		{
			scores[0] = 3; scores[1] = 7; scores[2] = 15; scores[3] = 30; scores[4] = 75; scores[5] = 150; scores[6] = 300; scores [7] = 600;
		}
		if (diff == 3)
		{
			scores[0] = 1; scores[1] = 5; scores[2] = 10; scores[3] = 25; scores[4] = 50; scores[5] = 100; scores[6] = 200; scores [7] = 400;
		}
		add = true;
		rainfall = new Rainfall();
		rainfall.makeRainArray();
		
	//	dead = new DeadScreen(player);
		keys = new boolean[2];
		setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);
		addMouseListener(this);
	}
	public void update(Graphics window){
	   paint(window);
   }
   public int getDiff(){ return difficulty;}
   public String getSong(){ return music;}
	public void paint(Graphics window)
	{
		player.drawLives(window);
		window.drawString("Score: " + player.getScore(), 30,20);
		rainfall.makeItRain(window,player);
		player.draw(window);
		for (int x = 0; x < scores.length; x++)
		{
			if (player.getScore() == scores[x] && add)
			{
				rainfall.addRain(player); rainfall.setMax(rainfall.getMax()+5); player.setSpeed(player.getSpeed()+2);
				add = false;
				break;
			}
		}
		boolean temp = true;
		for (int y = 0; y <scores.length; y++)
		{
			if (player.getScore() == scores[y])
				temp = false;
		}
		if (temp) add = true;
		if (keys[0] == true)
		{
			player.runLeft(window);
		}
		if (keys[1] == true)
		{
			player.runRight(window);
		}
		if (keys[0] == false && keys[1] == false)
		{
			player.standStill(window);
		}
		if (!player.getAlive()) 
		{
			GraphicsScreenRunner test = new GraphicsScreenRunner(3, player.getScore(),difficulty,music);
		}
		
	}
	
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=true; break;
			case 'D' : keys[1]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'A' : keys[0]=false; break;
			case 'D' : keys[1]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
	public boolean isInBounds(int x1, int y1, int x2, int y2)
	{
		return (mouseX >= x1 && mouseX<=x2+x1 && mouseY>=y1 && mouseY <=y2+y1);
	}
		
	public void mousePressed(MouseEvent e) {
       clicked = true;  mouseX = e.getX(); mouseY = e.getY(); paint = true;
    }
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {
        clicked = false;
    }
     
    public void mouseEntered(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
	public void run()
   {
   	try
   	{
   			while(player.getAlive())
   			{
   		   Thread.currentThread().sleep(75);
            repaint();
         	}
         song.stop();
         Music scream = new Music("Wilhelm.wav");
         //scream.stopClip();
      }catch(Exception e)
      {
      }
  	}	
}