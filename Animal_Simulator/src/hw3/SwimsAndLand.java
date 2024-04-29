package hw3;

public abstract class SwimsAndLand extends Avatar {

	protected SwimsAndLand(TerrainMap tm, GridPoint location) {
		super(tm, location);
	}
	public abstract void move();
	public abstract void onLand();
	public abstract void inWater();

}
