import java.util.ArrayList;

public class Bug {
	// instance attributes
	private String species;
	private String name;
	private char symbol;
	private int x; // horizontal position
	private int y; // vertical position
	private int energy;
	private int id; // unique id
	private World world; // world the bug belongs to, if any.
	
	// static field to store ids. don't forget it has to be static!!!
	private static ArrayList<Integer> idList = new ArrayList<Integer>(); 

	// overloaded constructor, takes no arguments and sets pre-defined attributes 
	public Bug() {		
		this.species = "Coccinella septempunctata";
		this.name = "Frankie";
		this.symbol = '*';
		this.x = 0;
		this.y = 0;
		this.energy = 100;
		this.world = null;
		// generate unique id based on idList size
		this.id = idList.size() + 1;
		// add id to idList
		idList.add(id);
	}
	
	// overloaded constructor function taking all attributes except id as arguments. also does not initiate with a world.
	public Bug(String species, String name, char symbol, int x, int y, int energy) {
		this.species = species;
		this.name = name;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.energy = energy;
		this.world = null;
		// generate unique id based on idList size
		this.id = idList.size() + 1;
		// add id to idList
		idList.add(id);
	}

	// change the bug's position, 1 coordinate at a time, either North, East, South or West
	// takes double between 0 and 1 as direction and determines movement using quadrants
	public void move(double direction) {
		
		// store initial position
		int initX = this.x;
		int initY = this.y;
		
		// declare variables to store new position. initialize new coordinates as initial coordinates.
		int newX = initX;
		int newY = initY;
		
		// argument direction should be between 0 and 1. if not, no movement happens
		if (direction < 0.25) {
			
			// move north
			newY = initY - 1;

		} else if (direction < 0.5) {
			
			// move east
			newX = initX + 1;
		
		} else if (direction < 0.75) {
		
			// move south
			newY = initY + 1;
		
		} else if (direction < 1) {
			
			// move west
			newX = initX - 1;
			
			
		}
		
		// if the bug belongs to a world,
		if (this.world != null) {
			
			// first check it did not move out of the world's borders. obtain world width and height
			int width = this.world.getWidth();
			int height = this.world.getHeight();
			
			// send it to the opposite side if it does! this world is a sphere!
			// note that the coordinates begin at 0 and end at width -1 and height - 1
			
			// check x coordinate
			if (newX < 0) {
				newX = width - 1;
			} else if (newX > width - 1) {
				newX = 0;
			}
			
			// check y coordinate
			if (newY < 0) {
				newY = height - 1;
			} else if (newY > height - 1) {
				newY = 0;
			}
			
			// next, check it did not move to a spot already occupied by another bug.
			if (world.isOccupied(newX, newY)) {
				
				// if it is, move it back to its original position
				newX = initX;
				newY = initY;
			}
			
		}
		
		// set new position
		this.x = newX;
		this.y = newY;
	}
	
	// Getters and setters (no setId method)

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getId() {
		return id;
	}
	
	public World getWorld() {
		return world;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}

	// toString and toText methods
	public String toString() {
		return name + " the " + species + " (" + symbol + ") is at (" + x + ", " + y
				+ ") and has " + energy + " energy remaining.";
	}
	
	public String toText() {
		return "Bug\n species: " + species + "\n name: " + name + "\n symbol: " + symbol + "\n x: " + x + "\n y: " + y
				+ "\n energy: " + energy + "\n id: " + id + "";
	}
	
}
