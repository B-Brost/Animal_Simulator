package hw3;

/*
 * Class to represent an x and y grid location.
 */
import java.util.ArrayList;
import java.util.List;

public class GridPoint implements Comparable<GridPoint>
{
	//variables for grid point
	private int x;
	private int y;

	//constructor
	public GridPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	//getter method for x
	public int get_x()
	{
		return this.x;
	}

	//getter method for y
	public int get_y()
	{
		return this.y;
	}

	@Override
	public String toString()
	{
		return "(" + x + "," + y + ")";
	}

	@Override
	public boolean equals(Object obj)
	{
		//if they are the same object
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GridPoint)) 
		{
			return false;
		}

		GridPoint that = (GridPoint)obj;

		return this.x == that.x && this.y == that.y;
	}

	@Override
	public int hashCode()
	{
		return (x + "," + y).hashCode();
	}

	@Override
	public int compareTo(GridPoint that)
	{
		if (this.x < that.x) 
		{
			return -1;
		}
		if (this.x > that.x)
		{
			return 1;
		}
		if (this.y < that.y) 
		{
			return -1;
		}
		if (this.y > that.y) 
		{
			return 1;		
		}
		return 0;
	}
	public List<GridPoint> getNeighbors(int levels)
	{
		List<GridPoint> neighbors = new ArrayList<>();

		for (int x = -levels; x<=levels; x++)
		{
			for (int y = -levels;y<=levels; y++)
			{
				if (x==0 && y ==0)
				{
					continue;
				}
				int newX = this.x +x;
				int newY = this.y+y;
				if (newX >=0 && newX <TerrainMap.gridWidth && newY>=0&&newY<TerrainMap.gridHeight)
				{
					GridPoint neighbor = new GridPoint (newX,newY);
					neighbors.add(new GridPoint(newX,newY));
				}
			}
		}
		return neighbors;
	}
}



