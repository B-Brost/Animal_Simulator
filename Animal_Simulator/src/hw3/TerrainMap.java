package hw3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.du.dudraw.Draw;


public class TerrainMap implements Drawable {
    private Map<GridPoint, TerrainTile> theTiles;

    // public static constants set in the constructor.
    public static int gridWidth;
    public static int gridHeight;

    // Constructor to read from file
    public TerrainMap(String filename) throws TerrainFileException, InvalidTerrainTypeException, MalformedTerrainFileException {
        BufferedReader read = null;
        String mapSizeLine = null;
        String[] gridValues = null;
        theTiles = new HashMap<>();
        try {
            read = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(-1);
        }
        try {
            mapSizeLine = read.readLine();
            gridValues = mapSizeLine.split(" ");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        if (gridValues.length == 2) {
            try {
                gridWidth = Integer.parseInt(gridValues[0]);
                gridHeight = Integer.parseInt(gridValues[1]);
            } catch (NumberFormatException e) {
                throw new MalformedTerrainFileException("File does not start with ints representing width and height");
            }
        } else {
        }
        String line;
        int row = 0;
        try {
            while ((line = read.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (int col = 0; col < tokens.length; col++) {
                    GridPoint gridPoint = new GridPoint(col, gridHeight - row);
                    String terrainType = tokens[col];
                    TerrainTile tile = TerrainTileFactory.newTerrainTile(terrainType, gridPoint);
                    theTiles.put(gridPoint, tile);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public void draw(Draw duDwin) {
        for (TerrainTile tile : theTiles.values()) {
            tile.draw(duDwin);
        }
    }

	public int getVeg(GridPoint loc) {
	    TerrainTile tile = theTiles.get(loc);
	    if (tile != null) {
	        return tile.getVeg();
	    }
		return 0;
	}
	
	public int getWet(GridPoint loc) {
	    TerrainTile tile = theTiles.get(loc);
	    if (tile != null) {
	        return tile.getWet();
	    }
		return 0;
	}
	
	public int getBump(GridPoint loc) {
	    TerrainTile tile = theTiles.get(loc);
	    if (tile != null) {
	        return tile.getBumpy();
	    }
		return 0;
	}

	public TerrainTile get(GridPoint loc) {
		return theTiles.get(loc);
	}
}






