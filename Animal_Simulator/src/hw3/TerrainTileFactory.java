package hw3;

public class TerrainTileFactory {

	public static TerrainTile newTerrainTile(String tileStr, GridPoint gridPoint) throws InvalidTerrainTypeException {
		switch (tileStr) {
		case "w":
			return new Water(gridPoint);
		case "g":
			return new Grass(gridPoint);
		case "r":
			return new Road(gridPoint);
		case "m":
			return new Mountain(gridPoint);
		default:
			throw new InvalidTerrainTypeException("Invalid terrain type.");
		}
	}

}
