import java.util.ArrayList;

public class Plant {

	// instance attributes
	private int size; // integer value between 0 and 9.
	private char symbol; // for now the symbol is the integer representing the size
	private int x; // coordinates within world
	private int y;
	private World world; // world plant belongs to, if any
	private int id; // let's have unique identifiers, too.

	// static field to store ids
	private static ArrayList<Integer> idList = new ArrayList<Integer>();
	
	// constructor
	public Plant(int size, char symbol, int x, int y) {
		this.size = size;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		// set world to null by default
		this.world = null;
		// create unique id based on idList size, beginning at id = 1 (not 0).
		this.id = idList.size() + 1;
		// add id to idList
		idList.add(id);
	}

	// find the biggest plant
//	public Plant biggestPlant(ArrayList<Plant> plants) {
//		
//		
//	}
	
	// getters and setters

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Plant [size=" + size + ", symbol=" + symbol + ", x=" + x + ", y=" + y + ", world=" + world + ", id="
				+ id + "]";
	}

}
