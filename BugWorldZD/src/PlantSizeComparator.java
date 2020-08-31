import java.util.Comparator;

public class PlantSizeComparator implements Comparator<Plant> {
	
	// static method for comparing plant sizes. compare method fulfills Comparator interface requirements
	public int compare(Plant p1, Plant p2) {
		
		// compare plant sizes
		if (p1.getSize() == p2.getSize()) {
			return 0;
			
		} else if (p1.getSize() > p2.getSize()) {
			return 1;
			
		} else {
			return -1;
			
		}
	}
}
