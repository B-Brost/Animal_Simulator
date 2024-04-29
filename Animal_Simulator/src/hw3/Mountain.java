package hw3;
import java.util.Random;

import edu.du.dudraw.Draw;

public class Mountain extends TerrainTile 
{

	Random random = new Random();
	int vegetation,bumpy,wet;
	
	public Mountain(GridPoint location)
	{
		super(location);
		this.vegetation = random.nextInt(51);
		this.bumpy=100;
		this.wet=0;
	}
	
	@Override
	public void setColor(Draw duDwin)
	{
		int G = this.vegetation + 50;
		duDwin.setPenColor(100, G, 100);
	}
	public int getVeg()
	{
		return this.vegetation;
	}
	public int getBumpy()
	{
		return this.bumpy;
	}
	public int getWet()
	{
		return this.wet;
	}
	public void eat()
	{
		this.vegetation-=10;
	}
}