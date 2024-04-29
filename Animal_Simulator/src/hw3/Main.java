package hw3;

public class Main {

	public static void main(String[] args) throws BadAvatarException {
		// Load in the map
		try {
			TerrainMap tm = new TerrainMap("map1.txt");
			SimWindow simWindow = new SimWindow(tm);
			// Make the display panel
			Avatar elk = AvatarFactory.newAvatar("elk", tm, new GridPoint(8, 7));
			Avatar jellyfish = AvatarFactory.newAvatar("jellyfish", tm, new GridPoint(25, 22));
			Avatar puffin = AvatarFactory.newAvatar("puffin", tm, new GridPoint(3, 8));
			Avatar alpaca = AvatarFactory.newAvatar("alpaca", tm, new GridPoint(15, 15));
			Human human = (Human) AvatarFactory.newAvatar("human", tm, new GridPoint(17, 17));
			GridPoint destination = new GridPoint(20, 20); // Set a destination for the human avatar
			human.setPathToFollow(destination);

			simWindow.addAvatar(elk);
			simWindow.addAvatar(jellyfish);
			simWindow.addAvatar(puffin);
			simWindow.addAvatar(alpaca);
			simWindow.addAvatar(human);
			simWindow.runSimulation();
		}
		catch(InvalidTerrainTypeException e) {
			System.out.println(e);
		}
		catch(MalformedTerrainFileException e) {
			System.out.println(e);
		}
		catch(TerrainFileException e) {
			System.out.println(e);
		}		
	}
}


