
public class Main {
	
	public static void main(String[] args) {
		// create bug using constructor with no arguments
		Bug bug1 = new Bug();

		// create bug using constructor with arguments
		Bug bug2 = new Bug("Anacridium aegyptium", "Egyptian Locust", '!', 50, 50, 100);
		
		System.out.println(bug1.toString());
		System.out.println(bug1.toText());
		System.out.println(bug2.toString());
		System.out.println(bug2.toText());
		
	}
}
