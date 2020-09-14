import java.util.ArrayList;

public class World {
	// height and width
	private int width;
	private int height;

	// fields for storing unspecified number of bugs and plants 
	ArrayList<Bug> bugs = new ArrayList<Bug>();
	ArrayList<Plant> plants = new ArrayList<Plant>();
	
	// constructor taking width and height
	public World(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// check if anything is residing in a certain position and return a boolean
	// indicating so.
	public boolean isOccupied(int x, int y) {
		
		// boolean to return
		boolean isOccupied = false;

		// loop through all bugs
		for (Bug b : this.bugs) {
			// check if bug's position matches input arguments
			if (b.getX() == x && b.getY() == y) {
				// set boolean to true and break out of loop
				isOccupied = true;
				break;
			}
		}
		
		// loop through all plants
		for (Plant p : this.plants) {
			// check if bug's position matches input arguments
			if (p.getX() == x && p.getY() == y) {
				// set boolean to true and break out of loop
				isOccupied = true;
				break;
			}
		}

		// return boolean
		return isOccupied;
	}
	
	// randomly generate a specified number of plants
	public void genPlants(int numPlants) {
		
		for (int i = 0; i < numPlants; i++) {
			
			// randomly pick a size between 0 and 9
			int size = (int)(Math.random() * 9);
			
			// randomly pick coordinates within world boundaries
			int x = (int)(Math.random() * this.width);
			int y = (int)(Math.random() * this.height);

			// check position is not already occupied and try again until one is found. or, give up after 20 tries
			int count = 0;
			while (isOccupied(x, y) || count > 20) {
				x = (int) (Math.random() * width);
				y = (int) (Math.random() * height);
				count++;
			}
			
			// set default plant symbol for now
			char symbol = '+';
			
			// create plant
			Plant plant = new Plant(size, symbol, x, y);
			
			// set world on plant to this world
			plant.setWorld(this);
			
			// add plant to list of plants
			this.plants.add(plant);
		}
	}

	// randomly generate a specified number of bugs
	public void genBugs(int numBugs) {

		for (int i = 0; i < numBugs; i++) {

			// randomly pick position. note that positions run from 0 to width - 1 and 0 to
			// height - 1
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);

			// check position is not already occupied and try again until one is found. or,
			// give up after 20 tries
			int count = 0;
			while (isOccupied(x, y) || count > 20) {
				x = (int) (Math.random() * width);
				y = (int) (Math.random() * height);
				count++;
			}

			// randomly pick energy level from 10 through 100. do we have an energy max?
			// probs not. that's probably bug-specific
			int energy = (int) (Math.random() * 90 + 10);

			// randomly pick short two-letter name
			String name = this.genRandomName();

			// randomly decide which subclass of bug, create bug and add to store
			double rand = Math.random();
			System.out.printf("Random number: %.2f%n", rand);

			Bug bug = null;
			if (rand < 0.334) {
				bug = new Grasshopper(name, x, y, energy);
			} else if (rand < 0.667) {
				bug = new Spider(name, x, y, energy);
			} else if (rand < 1) {
				bug = new Ant(name, x, y, energy);
			}

			// add bug to this world's list of bugs, and to bug's world attribute
			this.bugs.add(bug);
			bug.setWorld(this);
		}
	}

	// random short name generator
	public String genRandomName() {
		// consonants and vowels. treating y as a consonant
		String consonants = "bcdfghjklmnpqrstvwxyz";
		String vowels = "aeiou";

		// initialize name string and add a consonant
		String name = "";
		name = name + consonants.charAt((int) (Math.random() * consonants.length()));
		name = name.toUpperCase(); // capitalize first letter

		// add a vowel, then a consonant, then another vowel
		name = name + vowels.charAt((int) (Math.random() * vowels.length()));
		name = name + consonants.charAt((int) (Math.random() * consonants.length()));
		name = name + vowels.charAt((int) (Math.random() * vowels.length()));

		return name;
	}

	// print list of bugs
	public void printBugInfo() {
		for (Bug b : this.bugs) {
			System.out.println(b.toString());
//			System.out.println(b.toText());
		}
	}

	// print list of plants
	public void printPlantInfo() {
		for (Plant p : this.plants) {
			System.out.println(p.toString());
		}
	}

	// print out text rendering of world including all bugs at their locations as
	// represented by their
	public void drawWorld() {

		// draw top border
		System.out.print('|');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.println('|');

		// draw each row. using y as counter to match coordinate position
		for (int y = 0; y < height; y++) {

			// draw left border
			System.out.print('|');

			// iterate through the columns
			for (int x = 0; x < width; x++) {

				// flag whether this position is occupied
				boolean hasObject = false;

				// this would be much faster / not involve having to loop through all the bugs and plants and check their coordinates if all the world objects (need to use an interface here?) were stored in a 2d array containing all of the positions.
				
				// loop through all bugs to check if position matches
				for (Bug b : this.bugs) {
					
					// check if bug is in this position. at most one bug will be as we are
					// preventing multiple objects from occupying the same position
					if (b.getX() == x && b.getY() == y) {
						
						// set flag to true
						hasObject = true;
						
						// draw bug's symbol
						System.out.print(b.getSymbol());
						
						// break out of checking bugs loop
						break;
					}
				}

				// if a bug is not in this position,
				if (!hasObject) {
					
					// loop through all plants to check if position matches
					for (Plant p : this.plants) {
						
						// check if bug is in this position. at most one bug will be as we are
						// preventing multiple objects from occupying the same position
						if (p.getX() == x && p.getY() == y) {
							
							// set flag to true
							hasObject = true;
							
							// draw plant's symbol
							System.out.print(p.getSymbol());
							
							// break out of checking bugs loop
							break;
						}
					}
				}

				// if no object is in this position, print an empty space
				if (!hasObject) {
					System.out.print(" ");
				}

			}

			// draw right border and move onto the next line
			System.out.printf("|%n");
		}

		// draw bottom border
		System.out.print('|');
		for (int i = 0; i < width; i++) {
			System.out.print('-');
		}
		System.out.println('|');

	}

	public void updateWorld() {
		// randomly moves (or doesn't move) all the bugs in the world. if a bug tries to move to a spot occupied by another bug, the move method will put it back in its original position and no move will occur.
		// invokes move method on Bug class to move bugs - does not manipulate bug position directly.

		// loop over all bugs
		for (Bug b : this.bugs) {

			// generate random number between 0 and 1 and call move method
			b.move(Math.random());

		}
	}
	
	// run animation of world, updating and redrawing a specified number of times update world with a thread sleep in between 
	public void animateWorld(int numUpdates) {
		for (int i=0; i<numUpdates; i++) {
			this.updateWorld();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.drawWorld();
		}
	}

	// Getters and Setters. Note no setter for bugs arrayList but has addBug and
	// removeBug methods instead

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public void addBug(Bug bug) {
		// check incoming bug's position is not already occupied before adding to world
		if (!isOccupied(bug.getX(), bug.getY())) {
			this.bugs.add(bug);
		}
	}

	public void removeBug(Bug bug) {
		this.bugs.remove(bug);
	}
}
