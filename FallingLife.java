import java.awt.Color;
import java.awt.Graphics;

public class FallingLife extends Rain
{
	public FallingLife(int x, int y, int sp)
	{
		super(x,y,sp);
	}
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		int[] xPoints = {getX(),getX()+4,getX()+10,getX()+16,getX()+20,getX()+20,getX()+10,getX()};
		int[] yPoints = {getY(),getY()-3,getY(),getY()-3,getY(),getY()+5,getY()+17,getY()+5};
		g.fillPolygon(xPoints,yPoints,8);
	}
	public void draw(Graphics g, Color col)
	{
		g.setColor(col);
		int[] xPoints = {getX(),getX()+4,getX()+10,getX()+16,getX()+20,getX()+20,getX()+10,getX()};
		int[] yPoints = {getY(),getY()-3,getY(),getY()-3,getY(),getY()+5,getY()+17,getY()+5};
		g.fillPolygon(xPoints,yPoints,8);
	}
	public void moveAndDraw(Graphics window)
	{
		Rain test = new FallingLife(getX(),getY(),getSpeed()-10);
		test.draw(window,Color.WHITE);
		setY(getY()+getSpeed());
		draw(window);
	}
}