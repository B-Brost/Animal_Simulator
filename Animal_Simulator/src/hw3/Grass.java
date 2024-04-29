package hw3;

import edu.du.dudraw.Draw;

public class Grass extends TerrainTile {
	
	int vegetation,wet,bumpy;

	public Grass(GridPoint location){
		super(location);
		this.vegetation = 100;
		this.wet=25;
		this.bumpy=0;
	}
	
	@Override
	public void setColor(Draw duDwin){
		int G = 250 - this.vegetation;
		duDwin.setPenColor(0, G, 0);
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