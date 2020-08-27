import java.util.ArrayList;

public class World {
	// height and width 
	private int width;
	private int height;
	
	// field for storing unspecified number of bugs
	ArrayList<Bug> bugs = new ArrayList<Bug>();
	
	// constructor taking width and height
	public World(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// check if anything is residing in a certain position and return a boolean indicating so.
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
		
		// return boolean
		return isOccupied;
	}
	
	// randomly generate a specified number of bugs
	public void genBugs(int numBugs) {
		
		for (int i = 0; i < numBugs; i++) {
			
			// randomly pick position. note that positions run from 0 to width - 1 and 0 to height - 1
			int x = (int)(Math.random()*width);
			int y = (int)(Math.random()*height);

			// check position is not already occupied and try again until one is found. or, give up after 20 tries
			int count = 0;
			while (isOccupied(x, y) || count > 20) {
				x = (int)(Math.random()*width);
				y = (int)(Math.random()*height);
				count++;
			}
			
			// randomly pick energy level from 10 through 100. do we have an energy max? probs not. that's probably bug-specific
			int energy = (int)(Math.random()*90 + 10);
			
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
		name = name + consonants.charAt((int)(Math.random()*consonants.length()));
		name = name.toUpperCase(); // capitalize first letter

		// add a vowel, then a consonant, then another vowel
		name = name + vowels.charAt((int)(Math.random()*vowels.length()));
		name = name + consonants.charAt((int)(Math.random()*consonants.length()));
		name = name + vowels.charAt((int)(Math.random()*vowels.length()));

		return name;
	}
	
	// print list of bugs
	public void printBugInfo() {
		for (Bug b : this.bugs) {
			System.out.println(b.toString());
		}
	}
	
	// print out text rendering of world including all bugs at their locations as represented by their 
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
				
				// flag whether this position is occupied - Michael checks using 
				boolean hasBug = false;
				
				// loop through all bugs to check if position matches 
				for (Bug b : this.bugs) {
					
					// check if bug is in this position. at most one bug will be as we are preventing multiple objects from occupying the same position
					if (b.getX() == x && b.getY() == y) {
						
						// set flag to true
						hasBug = true;
						
						// draw bug's symbol
						System.out.print(b.getSymbol());
						
						// break out of checking bugs loop
						break;
					}
				}
				
				// if no bug was printed, print an empty space
				if (!hasBug) {
					System.out.print(" ");
				}
				
				// Michael's code figured this by checking the value of i. I'm choosing to just break out of the loop once a bug has been drawn so. not an option using that method
//				if (i == this.bugs.size()) {					
//					System.out.print(" ");
//				}
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
	
	// randomly moves (or doesn't move) all the bugs in the world. bugs are not permitted to move outside the world.
	// invokes move method on Bug class to move bugs - does not manipulate bug position directly. 
	public void updateWorld() {
		// loop over all bugs
		for (Bug b : this.bugs) {
			// generate random number between 0 and 1 and call move method
			b.move(Math.random());
		}
	}

	// Getters and Setters. Note no setter for bugs arrayList but has addBug and removeBug methods instead
	
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
