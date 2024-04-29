package hw3;

import edu.du.dudraw.Draw;

public class Road extends TerrainTile {
	int wet,vegetation,bumpy;
	public Road(GridPoint location){
		super(location);
		this.wet=0;
		this.bumpy=0;
		this.vegetation=0;
	}
	
	@Override
	public void setColor(Draw duDwin){
		duDwin.setPenColor(255, 255, 0);
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
	@Override
	protected void eat() {
		
	}
}



