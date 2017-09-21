import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;

public class Player
{
	private int xCord, yCord, skin, score, lives, speed;
	private boolean alive;
	
	public Player()
	{
		xCord = 375; yCord = 500; skin = 0; score = 0; alive = true; lives = 3; speed = 10;
	}
	public int getX(){ return xCord;}
	public int getY(){ return yCord;}
	public int getSkin() {return skin;}
	public int getScore(){ return score;}
	public int getLives(){ return lives;}
	public int getSpeed(){ return speed;}
	public boolean getAlive(){ return (getLives() > 0);}
	public void setX(int x){ xCord = x; if (xCord > 805) xCord = 1; if (xCord <0) xCord = 800;}
	public void setY(int y){ yCord = y;}
	public void setSkin(int sk){ skin = sk;}
	public void setScore(int sc){ score = sc;}
	public void setAlive(boolean al){ alive = al;}
	public void subLife(){ lives--;}
	public void addLife() {lives++;}
	public void setSpeed(int sp){ speed = sp;}
	
	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(xCord+5,yCord,20,20);
		if (getSkin() == 0)
		{
			drawThickLine(g,xCord+15,yCord+20,xCord+15,yCord+50);
			drawThickLine(g,xCord+15,yCord+50,xCord,yCord+75);
			drawThickLine(g,xCord+15,yCord+50,xCord+30,yCord+75);
			drawThickLine(g,xCord+15,yCord+30,xCord,yCord+55);
			drawThickLine(g,xCord+15,yCord+30,xCord+30,yCord+55);
		}
		if (getSkin() == 1)
		{
			drawThickLine(g,xCord+15,yCord+20,xCord+15,yCord+45);
			drawThickLine(g,xCord+15,yCord+45,xCord+10,yCord+60);
			drawThickLine(g,xCord+10,yCord+60,xCord,yCord+67);
			drawThickLine(g,xCord+15,yCord+45,xCord+30,yCord+40);
			drawThickLine(g,xCord+30,yCord+40,xCord+25,yCord+63);
			drawThickLine(g,xCord+15,yCord+25,xCord+20,yCord+35);
			drawThickLine(g,xCord+20,yCord+35,xCord+30,yCord+22);
			drawThickLine(g,xCord+15,yCord+25,xCord+5,yCord+28);
			drawThickLine(g,xCord+5,yCord+28,xCord+8,yCord+37);
		}
		if (getSkin() ==2)
		{
			drawThickLine(g,xCord+15,yCord+20,xCord+15,yCord+45);
			drawThickLine(g,xCord+15,yCord+45,xCord+8,yCord+52);
			drawThickLine(g,xCord+8,yCord+52,xCord-3,yCord+56);
			drawThickLine(g,xCord+15,yCord+45,xCord+27,yCord+50);
			drawThickLine(g,xCord+27,yCord+50,xCord+17,yCord+65);
			drawThickLine(g,xCord+15,yCord+25,xCord+22,yCord+31);
			drawThickLine(g,xCord+22,yCord+31,xCord+32,yCord+23);
			drawThickLine(g,xCord+15,yCord+25,xCord+5,yCord+28);
			drawThickLine(g,xCord+5,yCord+28,xCord,yCord+37);
		}
		if (getSkin() == -1)
		{
			drawThickLine(g,xCord+15,yCord+20,xCord+15,yCord+45);
			drawThickLine(g,xCord+15,yCord+45,xCord+20,yCord+60);
			drawThickLine(g,xCord+20,yCord+60,xCord+30,yCord+67);
			drawThickLine(g,xCord+15,yCord+45,xCord,yCord+40);
			drawThickLine(g,xCord,yCord+40,xCord+5,yCord+63);
			drawThickLine(g,xCord+15,yCord+25,xCord+10,yCord+35);
			drawThickLine(g,xCord+10,yCord+35,xCord,yCord+22);
			drawThickLine(g,xCord+15,yCord+25,xCord+25,yCord+28);
			drawThickLine(g,xCord+25,yCord+28,xCord+22,yCord+37);
		}
		if (getSkin() == -2)
		{
			drawThickLine(g,xCord+15,yCord+20,xCord+15,yCord+45);
			drawThickLine(g,xCord+15,yCord+45,xCord+22,yCord+52);
			drawThickLine(g,xCord+22,yCord+52,xCord+33,yCord+56);
			drawThickLine(g,xCord+15,yCord+45,xCord+3,yCord+50);
			drawThickLine(g,xCord+3,yCord+50,xCord+13,yCord+65);
			drawThickLine(g,xCord+15,yCord+25,xCord+8,yCord+31);
			drawThickLine(g,xCord+8,yCord+31,xCord-2,yCord+23);
			drawThickLine(g,xCord+15,yCord+25,xCord+25,yCord+28);
			drawThickLine(g,xCord+25,yCord+28,xCord+30,yCord+37);
		}
		
		
	}
	public void standStill(Graphics g)
	{
		drawWhite(g);
		setSkin(0);
		draw(g);
	}
	public void runRight(Graphics g)
	{
		drawWhite(g);
		setSkin(getSkin()+1);
		if (getSkin() == 3) setSkin(1);
		setX(xCord+getSpeed());
		draw(g);
	}
	public void runLeft(Graphics g)
	{
		drawWhite(g);
		setSkin(getSkin()-1);
		if (getSkin() == -3) setSkin(-1);
		setX(xCord-getSpeed());
		draw(g);
	}
	public void drawWhite(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(getX()-4,yCord,getX()+33,yCord+76);
		
	}
	public void drawThickLine(Graphics g, int x1, int y1, int x2, int y2)
	{
		for (int x = -1; x <= 1; x++)
		{
			g.drawLine(x1+x,y1,x2+x,y2);
		}
	}
	public void drawLives(Graphics g)
	{
		g.setColor(Color.RED);
		for (int x = 0; x <70; x+=20)
		{
			if((getLives() == 2 || getLives() == 1) && x ==60) g.setColor(Color.GRAY);
			if (getLives() == 1 && x == 30) g.setColor(Color.GRAY);
			int[] xPoints = {690+x,694+x,700+x,706+x,710+x,710+x,700+x,690+x};
			int[] yPoints = {13,10,13,10,13,18,30,18};
			g.fillPolygon(xPoints,yPoints,8);
			x+=10;
		}
	}
	public void fillScore(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(30,10,60,15);
	}
	public boolean gotMe(int x)
	{
		return (x>= getX() && x < getX()+33);
	}
}