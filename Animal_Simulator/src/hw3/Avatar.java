package hw3;

import edu.du.dudraw.Draw;
public abstract class Avatar 
{
	protected GridPoint location;
	private TerrainMap tm;
	protected Avatar (TerrainMap tm,GridPoint location)
	{
		this.location=location;
		this.tm=tm;
	}

	
	public void draw(Draw duDwin) {
		int width = SimWindow.windowWidth/TerrainMap.gridWidth;
		int height=SimWindow.windowHeight/TerrainMap.gridHeight;
		String image = image();
		duDwin.picture(location.get_x()*width+width/2, location.get_y()*height-height/2, image,width,height);
	}
	public abstract void move();
	protected abstract String image();

}


