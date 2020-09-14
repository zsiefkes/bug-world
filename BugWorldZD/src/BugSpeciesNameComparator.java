import java.util.Comparator;

public class BugSpeciesNameComparator implements Comparator<Bug> {
	// compares bugs first by species and then by name
	public int compare(Bug b1, Bug b2) {
		
		// compare by species first.
		if (b1.getSpecies().compareTo(b2.getSpecies()) == 0) {
			
			// if species are the same, compare by name
			if (b1.getName().compareTo(b2.getName()) == 0) {
				
				// name and species are lexicographically equal
				return 0;
				
			} else if (b1.getName().compareTo(b2.getName()) > 0) {
				// species are equal and name 1 lexicographically follows name 2
				return 1;
			
			} else {
				// species are equal and name 1 lexicographically precedes name 2
				return -1;
			}

		// continue comparison by species
		} else if (b1.getSpecies().compareTo(b2.getSpecies()) > 0) {
			// species 1 lexicographically follows species 2 
			return 1;
			
		} else {
			// species 1 lexicographically precedes species 2 
			return -1;
		}
	}
}
