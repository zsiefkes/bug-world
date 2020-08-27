public class Spider extends Bug {
	// set default species and symbol as private static variables for use in constructors
	private static String defaultSpecies = "Spider";
	private static char defaultSymbol = '#';
	
	// default constructor taking no arguments
	public Spider() {
		super();
		setSpecies(defaultSpecies);
		setSymbol(defaultSymbol);
	}

	// overloaded constructor taking name, x and y position and energy level.
	public Spider(String name, int x, int y, int energy) {
		super(defaultSpecies, name, defaultSymbol, x, y, energy);
	}
	
}
