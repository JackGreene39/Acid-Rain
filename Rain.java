import java.awt.Color;
import java.awt.Graphics;

public class Rain
{
	private int xCord, yCord;
	private int speed;
	
	public Rain(int x, int y, int sp)
	{
		xCord = x; yCord = y; speed = sp;
	}
	public int getX(){ return xCord;}
	public int getY(){ return yCord;}
	public int getSpeed(){ return speed;}
	public void setX(int x){ xCord = x;}
	public void setY(int y){ yCord = y;}
	public void setSpeed(int sp){speed = sp;}
	
	public void draw(Graphics g)
	{
		Color initial = new Color(87,151,45);
		g.setColor(initial);
		int[] xPoints = {xCord+10,xCord+3,xCord+17};
		int[] yPoints = {yCord,yCord+10,yCord+10};
		g.fillPolygon(xPoints,yPoints,3);
		g.fillOval(xCord,yCord+7,20,20);
		Color dots = new Color(121,200,68);
		g.setColor(dots);
		g.fillOval(xCord+11,yCord+21,3,3);
		g.fillOval(xCord+6,yCord+19,3,3);
		g.fillOval(xCord+16,yCord+20,3,3);
		g.fillOval(xCord+1,yCord+20,3,3);
		g.fillOval(xCord+9,yCord+14,3,3);
		g.fillOval(xCord+5,yCord+9,3,3);
		g.fillOval(xCord+13,yCord+7,3,3);
		g.fillOval(xCord+8,yCord+3,3,3);
	}
	public void draw(Graphics g, Color col)
	{
		g.setColor(col);
		int[] xPoints = {xCord+10,xCord+3,xCord+17};
		int[] yPoints = {yCord,yCord+10,yCord+10};
		g.fillPolygon(xPoints,yPoints,3);
		g.fillOval(xCord,yCord+7,20,20);
	}
	public void moveAndDraw(Graphics window)
	{
		Rain test = new Rain(getX(),getY(),getSpeed());
		test.draw(window,Color.WHITE);
		setY(getY()+getSpeed());
		draw(window);
	}
	public boolean reachesEnd()
	{
		return (getY() >=620);
	}
	public boolean gotEEM(Player p)
	{
		return (getY()>=500 && getY()<= 550 && (p.gotMe(getX()) || p.gotMe(getX()+20)));
	}
}