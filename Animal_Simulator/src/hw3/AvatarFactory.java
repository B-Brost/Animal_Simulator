package hw3;

public class AvatarFactory {
	public static Avatar newAvatar(String avatarName,TerrainMap terrainMap, GridPoint gridPoint)throws BadAvatarException
	{
		switch (avatarName) {
		case "elk":
			return new Elk(terrainMap,gridPoint);
		case "alpaca":
			return new Alpaca(terrainMap,gridPoint);
		case "jellyfish":
			return new Jellyfish(terrainMap,gridPoint);
		case "puffin":
			return new Puffin(terrainMap,gridPoint);
		case "human":
			return new Human(terrainMap,gridPoint);
		default:
			throw new BadAvatarException("Invalid Avatar.");
		}
	}
}

