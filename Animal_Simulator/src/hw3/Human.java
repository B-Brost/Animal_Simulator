package hw3;

import java.util.List;

public class Human extends Avatar {
	
	private TerrainMap tm;
	private List<GridPoint> pathToFollow;
	private String image;
	private PathFinder pathFinder;

	protected Human(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.pathToFollow = null;
		this.image = "Human.png";
		this.pathFinder = new PathFinder(tm);
	}

	public void setPathToFollow(GridPoint destination) {
		this.pathToFollow = pathFinder.findPath(this.location, destination);
	}

	@Override
	public void move() {
		if (pathToFollow != null && !pathToFollow.isEmpty()) {
			GridPoint nextStep = pathToFollow.get(0);
			pathToFollow.remove(0);
			location = nextStep;
		}
	}

	@Override
	protected String image() {
		return this.image;
	}
}

