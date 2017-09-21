import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Dimension;
import static java.lang.Character.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.*;

public class MainScreen extends Canvas implements MouseListener, Runnable
{
	private boolean clicked, play, paint;
	private int mouseX, mouseY, screen;
	MainScreenStuff main;
	DeadScreen dead;
	SettingsStuff set;

	public MainScreen(int s, int score,int diff,String song)
	{
		dead = new DeadScreen(score);
		main = new MainScreenStuff();
		set = new SettingsStuff();
		set.setDifficulty(diff);
		set.setSong(song);
		screen = s;
		clicked = false;
		play = true;
		paint = true;
		setBackground(Color.WHITE);
		setVisible(true);
		new Thread(this).start();
		addMouseListener(this);
	}
	public void setClick(boolean c){ clicked = c;}
	public boolean getClick(){ return clicked;}
	public void update(Graphics window){
	  paint(window);
   }
   public void setScreen(int s){screen = s;}
	public void paint(Graphics window) 
	{
		if(screen == 1)
		{
			main.drawPlay(window);
			main.drawSettings(window);
			if (clicked && play && isInBounds(200,100,300,100))
			{
				main.pressPlay(window);
				try{Thread.currentThread().sleep(125);
				}catch(Exception e){}
				dead.clear(window);
				main.drawControls(window);
				try{Thread.currentThread().sleep(5000);
				}catch(Exception e){}
		 		GraphicsGameRunner test = new GraphicsGameRunner(set.getDifficulty(),set.getSong());
		 		 play = false;
			}
			if (clicked && isInBounds(250,275,200,75))
			{
				main.pressSet(window);
				try{Thread.currentThread().sleep(125);
				}catch(Exception e){}
				main.clear(window);
				screen = 2;
				paint = true;
			}
		}
		if (screen == 2)
		{
			set.drawBox(window);
			set.drawDiff(window);
			set.back(window);
			set.drawSong(window);
			set.pressDiff(window);
			set.pressSong(window);
			if (clicked && isInBounds(213,101,104,80)) set.setDifficulty(1);
			if (clicked && isInBounds(322,101,104,80)) set.setDifficulty(2);
			if (clicked && isInBounds(431,101,104,80)) set.setDifficulty(3);
			if (clicked && isInBounds(213,225,324,50)) set.setSong("Shooting Stars");
			if (clicked && isInBounds(213,285,324,50)) set.setSong("Ocean Man");
			if (clicked && isInBounds(213,345,324,50)) set.setSong("All Star");
			if (clicked && isInBounds(213,405,324,50)) set.setSong("Photograph");
			if (clicked && isInBounds(20,10,50,50))
			{
				set.pressBack(window);
				try{Thread.currentThread().sleep(125);
				}catch(Exception e){}
				main.clear(window);
				screen = 1;
				paint = true;
			}
		}
		if (screen == 3)
		{
			dead.draw(window);
			dead.drawPlay(window);
			dead.drawMain(window);
			if (clicked && isInBounds(200,175,300,100))
			{
				dead.pressPlay(window);
				try{Thread.currentThread().sleep(125);
				}catch(Exception e){}
				GraphicsGameRunner test = new GraphicsGameRunner(set.getDifficulty(),set.getSong());
			}
			if (clicked && isInBounds(200,325,300,100))
			{
				dead.pressMain(window);
				try{Thread.currentThread().sleep(125);
				}catch(Exception e){}
				dead.clear(window);
				screen = 1;
			}
		}
		paint = false;
	}
	public boolean isInBounds(int x1, int y1, int x2, int y2)
	{
		return (mouseX >= x1 && mouseX<=x2+x1 && mouseY>=y1 && mouseY <=y2+y1);
	}
		
	public void mousePressed(MouseEvent e) {
       setClick(true);  mouseX = e.getX(); mouseY = e.getY(); paint = true;
    }
    public void mouseExited(MouseEvent e) {
      
    }
    public void mouseReleased(MouseEvent e) {
        setClick(false);
    }
     
    public void mouseEntered(MouseEvent e) {
  		
    }
    public void mouseClicked(MouseEvent e) {
       
    }
    public void run()
    {
   		try
   		{
    		while(true)
    		{
    			if (paint)
    			{
    				repaint();
    			}
    			
    		}
    	}catch(Exception e){}
    }
 
}