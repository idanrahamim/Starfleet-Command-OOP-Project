package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myBattleSpaceship{

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return 3500 + this.weaponsAnnualCost() + (500*this.getCrewMembers().size()) + Math.round(1200* this.getMaximalSpeed());
	}
}
