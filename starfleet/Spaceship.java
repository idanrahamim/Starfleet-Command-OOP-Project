package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public interface Spaceship extends Comparable<Spaceship>{
	String getName();
	int getCommissionYear();
	float getMaximalSpeed();
	int getFirePower();
	Set<? extends CrewMember> getCrewMembers();
	int getAnnualMaintenanceCost();

	default int compareTo(Spaceship o) {
		if (this.getFirePower() > o.getFirePower()){
			return -1;
		}else if (this.getFirePower() < o.getFirePower()){
			return 1;
		}else {
			if (this.getCommissionYear() > o.getCommissionYear()){
				return -1;
			}else if (this.getCommissionYear() < o.getCommissionYear()){
				return 1;
			}else {
				if (this.getName().compareTo(o.getName()) > 0){
					return 1;
				}else {
					return -1;
				}
			}
		}
	}
}
