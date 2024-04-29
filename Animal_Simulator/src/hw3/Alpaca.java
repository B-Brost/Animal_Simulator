package hw3;

import java.util.List;

public class Alpaca extends Avatar {
	
	private TerrainMap tm;
	String image;

	protected Alpaca(TerrainMap tm, GridPoint location) {
		super(tm, location);
		this.tm = tm;
		this.image = "Alpaca.png";
	}

	@Override
	public void move() {
	    List<GridPoint> neighbors = location.getNeighbors(3);
	    
	    
	    GridPoint bestNeighbor = neighbors.get(0); 
	    int bestVeg = 0;
	  
	    for (GridPoint neighbor : neighbors) {
	    	int currentVeg = tm.getVeg(neighbor);
	    	
	    	if (currentVeg > bestVeg) {
	    		bestVeg = currentVeg;
	    		bestNeighbor = neighbor;
	    		}
	    	}
	    
	    location = bestNeighbor;
	    tm.get(bestNeighbor).eat();
	}

	@Override
	protected String image() {
		return this.image;
	}

}
