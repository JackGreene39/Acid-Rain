import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Rainfall
{
	ArrayList<Rain> rain;
	int amount, maxSpeed;
	
	public Rainfall()
	{
		rain = new ArrayList<Rain>();
		amount = 1; maxSpeed = 20;
	}
	public int getMax(){ return maxSpeed;}
	public int getAmount(){ return amount;}
	public ArrayList<Rain> getRainArray(){ return rain;}
	public void setMax(int max){ maxSpeed = max;}
	public void setAmount(int am){ amount = am;}
	
	public void makeRainArray()
	{
		for (int x = 0; x< amount; x++)
		{
			int sp = (int)(Math.random()*(maxSpeed/2) + (maxSpeed/2));
			int xCord = (int)(Math.random()*775);
			rain.add(x,new Rain(xCord,30,sp));
		}
	}
	public void addRain(Player p)
	{
		int chance = (int)(Math.random()*10);
		int chance2 = (int)(Math.random()*25);
		setAmount(getAmount()+1);
		int sp = (int)(Math.random()*(maxSpeed/2) + (maxSpeed/2));
		int xCord = (int)(Math.random()*775);
		if (chance == 7)
			xCord = p.getX();
		if (chance2 == 19 && p.getLives() <3)
			rain.add(new FallingLife(xCord,50,sp));
		else
			rain.add(new Rain(xCord,50,sp));
	}
	public void removeRain(Rain item)
	{
		rain.remove(item);
	}
	public void makeItRain(Graphics g, Player p)
	{
		for (int x = 0; x < rain.size(); x++)
		{
			rain.get(x).moveAndDraw(g);
			if (rain.get(x).reachesEnd())
			{
				removeRain(rain.get(x));
				addRain(p);
				p.fillScore(g);
				p.setScore(p.getScore()+1);
			}
			if (rain.get(x).gotEEM(p))
			{
				if (rain.get(x).getClass().equals(FallingLife.class))
				{
					p.addLife();
					Music Yeah = new Music("Yeah.wav");
				}
				else{
				p.subLife();
				if (p.getLives()!=0) {Music ow = new Music("ow.wav");}}
				rain.get(x).draw(g,Color.WHITE);
				removeRain(rain.get(x));
				addRain(p);
			}
		}
	}
}