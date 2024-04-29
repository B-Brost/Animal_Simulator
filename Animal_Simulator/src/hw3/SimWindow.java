package hw3;

import java.util.ArrayList;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class SimWindow implements DrawListener {

	// Some static constants that everyone can use
	//   the represent the window size
	public final static int windowWidth = 1050;
	public final static int windowHeight = 700;

	private TerrainMap tm;
	private Draw duDwin;
	private ArrayList<Avatar> avatarList = new ArrayList<>();

	public SimWindow(TerrainMap tm) {
		// Setup the DuDraw window
		duDwin = new Draw("COMP2381 Animal Simulation"); // The OO version of DUDraw
		duDwin.setCanvasSize(SimWindow.windowWidth, SimWindow.windowHeight);
		duDwin.enableDoubleBuffering(); // Too slow otherwise -- need to use .show() later

		// Set the scale of the window
		// Right now it is set to match the pixels
		duDwin.setXscale(0, SimWindow.windowWidth);
		duDwin.setYscale(0, SimWindow.windowHeight);

		this.tm = tm;

		// Add this line to set this class as the listener for mouse events
		duDwin.addListener(this);
	}

	public void addAvatar(Avatar a) {
		avatarList.add(a);
	}

	public void update() {
		// TODO: Clear the entire window to white and draw the TerrainMap
		duDwin.clear();
		tm.draw(duDwin);
		for (Avatar avatar : avatarList) {
			avatar.draw(duDwin);
			avatar.move();
		}
		duDwin.show();  // used in double buffering
	}

	public void runSimulation() {
		update(); // Initial positing

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			update();
		}
	}

	@Override
	public void mousePressed(double x, double y) {
		// Convert the mouse click coordinates to grid coordinates
		int gridX = (int) (x / (SimWindow.windowWidth / TerrainMap.gridWidth));
		int gridY = (int) (y / (SimWindow.windowHeight / TerrainMap.gridHeight));

		// Set the path for the human avatar to follow
		for (Avatar avatar : avatarList) {
			if (avatar instanceof Human) {
				((Human) avatar).setPathToFollow(new GridPoint(gridX, gridY));
			}
		}
	}

	// You also need to override these methods, but you can leave them empty if you don't need them
	@Override
	public void mouseDragged(double x, double y) {
		// Handle mouse dragged events
	}

	@Override
	public void mouseReleased(double x, double y) {
		// Handle mouse released events
	}

	@Override
	public void keyPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(char arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}
}
