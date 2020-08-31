import java.util.Comparator;

public class BugEnergyComparator implements Comparator<Bug> {
	
	// compare bug energy
	public int compare(Bug b1, Bug b2) {
		
		if (b1.getEnergy() == b2.getEnergy()) {
			return 0;
		} else if (b1.getEnergy() > b2.getEnergy()) {
			return 1;
		} else {
			return -1;
		}
	}
}
