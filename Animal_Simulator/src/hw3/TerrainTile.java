package hw3;

import edu.du.dudraw.Draw;

abstract class TerrainTile implements Drawable {
    private GridPoint location;
    protected int wet, vegetation, bumpy;

    protected TerrainTile(GridPoint location) {
        this.location = location;

    }

    public void draw(Draw duDwin) {
        setColor(duDwin);
        int width = SimWindow.windowWidth / TerrainMap.gridWidth;
        int height = SimWindow.windowHeight / TerrainMap.gridHeight;

        duDwin.filledRectangle(this.location.get_x() * width + width / 2, this.location.get_y() * height - height / 2, width / 2, height / 2);
    }

    public abstract void setColor(Draw duDwin);
	protected abstract int getVeg();
	protected abstract int getWet();
	protected abstract int getBumpy();
	protected abstract void eat();
}
