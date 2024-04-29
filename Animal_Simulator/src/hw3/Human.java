package hw3;
import edu.du.dudraw.Draw;
import java.util.List;

public class Human extends Avatar{
	private List<GridPoint> pathToFollow;
	protected Human(GridPoint location) {
		super(location);
		this.pathToFollow=null;
	}
	public void setPathToFollow(List<GridPoint> path) {
		pathToFollow = path;
	}
	public void followPath(List<GridPoint> path) 
	{
		if (pathToFollow!=null &&!pathToFollow.isEmpty()) {
			GridPoint nextStep = pathToFollow.get(0);
			pathToFollow.remove(0);
			move(nextStep);
		}
	}
	public void move(GridPoint newLocation)
	{
		this.location= newLocation;
	}
	public void draw (Draw duDwin) {
//		duDwin.picture

	}
	public GridPoint getLocation() {
		return location;
	}
}

