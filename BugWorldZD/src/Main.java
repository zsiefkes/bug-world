import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
		
	// field to store bugs
	ArrayList<Bug> bugs = new ArrayList<Bug>();
	
	// constructor
	public Main() {
		// run task 1 method
//		this.createTwoBugs();
		
		// prompt user to create a bug and add result to store
//		this.bugs.add(this.userInputAttributes());
		
		// move a random bug
//		int bugInt = (int)(Math.random()*this.bugs.size());
//		this.moveRandom(this.bugs.get(bugInt));
		
		// attempt to create a um. grasshopper and add to list of bugs
		Grasshopper gh = new Grasshopper();
		this.bugs.add(gh);
		
		// check whether the methods in Bug exist in Grasshopper too. yes! fantastic
		System.out.println(gh.toString());
		System.out.println(gh.toText());

		// move the grasshopper
		this.moveRandom(gh);
		
		// create a spider using empty constructor 
		Spider sp = new Spider();
		this.bugs.add(sp);
		
		// set spider's name using setter method
		sp.setName("Bob");
		
		// create an ant using constructor with args
		Ant ant = new Ant("Sarah", 10, 20, 300);
		this.bugs.add(ant);
		
		// print out list of bugs
		this.printBugs();
	}
	
	public Bug userInputAttributes() {
		// open scanner on System.in. note that we do not close this
		Scanner scan = new Scanner(System.in);
		
		// prompt user to enter species. 
		System.out.println("Enter species:");
		
		// scanner will wait for user entry before proceeding. 
		String species = scan.nextLine();
		
		// ask for name
		System.out.println("Enter name:");
		String name = scan.nextLine();
		
		// ask for character to represent bug. use charAt(0)
		System.out.println("Enter symbol:");
		char symbol = scan.nextLine().charAt(0);
		
		// ask for horizontal and vertical position. if user does not enter an integer, program will crash
		System.out.println("Horizontal position (enter an integer):");
		int x = scan.nextInt();
		System.out.println("Vertical position (enter an integer):");
		int y = scan.nextInt();
		
		// energy
		System.out.println("Energy level (enter an integer):");
		int energy = scan.nextInt();
		
		// skip to end of line as scanner will not automatically do this when using nextInt()
		scan.nextLine();
		
		// create new bug and return the bug
		return new Bug(species, name, symbol, x, y, energy);
	}
	
	// move a bug in a random direction 100 times to complete task 5
	public void moveRandom(Bug bug) {
		
		// number of times to move the bug
		int numMoves = 100;
		
		// print message
		System.out.printf("Moving bug %s randomly %d times.%n", bug.getName(), numMoves);
		
		// repeat numMoves times
		for (int i=0; i < numMoves; i++) {
			
			// move random direction 
			bug.move(Math.random());
			
			// print new x, y position and direction moved
			System.out.printf("New position: %d %d%n", bug.getX(), bug.getY());
		}
	}
	
	// method to complete task 1 and test bug toString methods.
	public void createTwoBugs() {
		// create bug using constructor with no arguments
		Bug bug1 = new Bug();
		
		// create bug using constructor with arguments
		Bug bug2 = new Bug("Anacridium aegyptium", "Egyptian Locust", '!', 50, 50, 100);
		
		System.out.println(bug1.toString());
		System.out.println(bug1.toText());
		System.out.println(bug2.toString());
		System.out.println(bug2.toText());
		
		// add bugs to bug store
		this.bugs.add(bug1);
		this.bugs.add(bug2);
	}
	
	// loop over bugs in store and print out their details
	public void printBugs() {
		for (Bug b : this.bugs) {
			System.out.println(b.toString());
		}
	}

	// entry point for bug world program. 
	public static void main(String[] args) {
		// create instance of Main class (run constructor)
		// new Main();
		// create new world, specifying width and height
		World world = new World(50, 10);
		
		// populate world with 10 bugs and 10 plants
		world.genBugs(10);
		world.genPlants(10);
		
		// print bug and plant info
		world.printBugInfo();
		world.printPlantInfo();
		
		// which is the biggest plant? check the comparator works first
		Plant p1 = world.plants.get(0);
		Plant p2 = world.plants.get(1);
		System.out.printf("Plant %d compared to plant %d returns %d", p1.getId(), p2.getId(), new PlantSizeComparator().compare(p1, p2));
		
		// sort plant list from smallest to biggest
//		PlantSizeComparator plantSizeFilter = new PlantSizeComparator();
//		Collections.sort(world.plants, plantSizeFilter);
		Collections.sort(world.plants, new PlantSizeComparator());

		// reprint plant list
		world.printPlantInfo();
		
		// sort bug list based on energy level
		Collections.sort(world.bugs, new BugEnergyComparator());
		// reprint bug list
		world.printBugInfo();
		
		// sort bug list by species first then by name
		Collections.sort(world.bugs, new BugSpeciesNameComparator());
		// reprint bug list
		world.printBugInfo();

		// sort bug list by id using compareTo method on Bug class which now implements Comparable<Bug>
		world.bugs.sort(null);
		// reprint bug list
		world.printBugInfo();
		
		// draw that world!
//		world.drawWorld();
		
		// animate world
//		world.animateWorld(10);
	}
}
