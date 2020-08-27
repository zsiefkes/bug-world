
public class Grasshopper extends Bug {
	// don't need to list instance attributes already listed in Bug!
	
	// constructor taking all attributes as arguments except species and symbol	
	public Grasshopper(String name, int x, int y, int energy) {
		// call superclass' constructor with provided arguments plus default species and symbol
		super("Grasshopper", name, '^', x, y, energy);
	}

	// constructor taking no arguments. sets default values as in super but also setting species and symbol specific to Grasshopper class
	public Grasshopper() {
		super();
		// use setter methods to set default values for grasshopper class
		setSpecies("Grasshopper");
		setSymbol('^');
		// why no "this" keyword here to invoke the setter function?
	}

	// um do we need the getters and setters? we don't, right?? nope!
}
