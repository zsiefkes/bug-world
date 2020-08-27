
public class Ant extends Bug {
	private static String defaultSpecies = "Ant";
	private static char defaultSymbol = '%';
	
	public Ant() {
		super();
		// set species and symbol... invoking these methods with this keyword. not necessary to use this keyword as we have seen but presumably it will still work?
		this.setSpecies(defaultSpecies);
		this.setSymbol(defaultSymbol);
	}
	
	// overloaded constructor. 
	public Ant(String name, int x, int y, int energy) {
		super(defaultSpecies, name, defaultSymbol, x, y, energy);
	}
	
}
