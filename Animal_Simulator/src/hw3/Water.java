package hw3;

import edu.du.dudraw.Draw;

public class Water extends TerrainTile{
	int wet,vegetation,bumpy;
	public Water(GridPoint location){
		super(location);
		this.wet=100;
		this.bumpy=0;
		this.vegetation=0;
	}
	
	@Override
	public void setColor(Draw duDwin){
		int w = 255 - this.wet;
		duDwin.setPenColor(0, 100, w);
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
		wet-=1;
	}
}


