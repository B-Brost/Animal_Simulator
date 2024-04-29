package hw3;

import java.util.List;

public class Puffin extends SwimsAndLand{

	private TerrainMap tm;
	String image;
	
	protected Puffin(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "puffinFlying.jpg";
	}

	@Override
	public void move() {
	    List<GridPoint> neighbors = location.getNeighbors(3);
	    
	    GridPoint bestNeighbor = neighbors.get(0); 
	    
	    int bestWet = 0;
	    int bestVeg = 50;
	    
	    for (GridPoint neighbor : neighbors) {
	    	int currentWet = tm.getWet(neighbor);
	    	int currentVeg = tm.getVeg(neighbor);
	    	
	    	if (currentWet > 25 || currentVeg > bestVeg ) {
	    		bestWet = currentWet;
	    		bestVeg = currentVeg;
	    		bestNeighbor = neighbor;
	    		}
	    	}
	    
	    location = bestNeighbor;
	    bestVeg = 50;
	    
	    if (tm.get(bestNeighbor).getWet() > 50) {
	    	inWater();
	    }
	    else {
	    	onLand();
	    }
	    
	    tm.get(bestNeighbor).eat();
	}

	@Override
	protected String image() {
		return this.image;
	}

	@Override
	public void onLand() {
		this.image = "puffinFlying.jpg";
		
	}

	@Override
	public void inWater() {
		this.image = "puffinSwimming.png";
		
	}

}
