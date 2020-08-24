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
	
	// field to store ids
	private ArrayList<Integer> idList = new ArrayList<Integer>(); 

	// overloaded constructor, takes no arguments and sets pre-defined attributes 
	public Bug() {		
		this.species = "Pholcus phalangioides";
		this.name = "Daddy Longlegs";
		this.symbol = 's';
		this.x = 0;
		this.y = 0;
		this.energy = 100;
		// generate unique id based on idList size
		this.id = this.idList.size() + 1;
		
	}
	
	// overloaded constructor function taking all attributes as arguments
	public Bug(String species, String name, char symbol, int x, int y, int energy, int id) {
		this.species = species;
		this.name = name;
		this.symbol = symbol;
		this.x = x;
		this.y = y;
		this.energy = energy;
		// generate unique id based on idList size
		this.id = this.idList.size() + 1;
	}

	// Getters and setters

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

	public void setId(int id) {
		this.id = id;
	}

	// toString and toText methods
	public String toString() {
		return "Bug " + name + " " + symbol + " is at " + x + ", " + y
				+ " and has " + energy + " energy remaining.";
	}
	
	public String toText() {
		return "Bug [species=" + species + ", name=" + name + ", symbol=" + symbol + ", x=" + x + ", y=" + y
				+ ", energy=" + energy + ", id=" + id + "]";
	}
	
}
