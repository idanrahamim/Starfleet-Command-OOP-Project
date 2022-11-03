package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends myBattleSpaceship {

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return 4000 + this.weaponsAnnualCost() + (this.getCrewMembers().size()*500) + Math.round(500* this.getMaximalSpeed());
	}
}
