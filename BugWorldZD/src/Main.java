import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// field to store bugs
	ArrayList<Bug> bugs = new ArrayList<Bug>();
	
	// constructor
	public Main() {
		// run task 1 method
		this.createTwoBugs();
		
		// prompt user to create a bug
		this.userInputAttributes();
		
		// print out list of bugs
		this.printBugs();
		
	}
	
	public void userInputAttributes() {
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
		
		// create new bug
		Bug bug = new Bug(species, name, symbol, x, y, energy);
		
		// add bug to store
		this.bugs.add(bug);
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

	
	public static void main(String[] args) {
		// create instance of Main class (run constructor)
		new Main();
		
	}
}
