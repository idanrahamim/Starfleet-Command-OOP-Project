package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.*;

public class StealthCruiser extends myBattleSpaceship{

	private static int numsOfCruiserShips = 0;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		numsOfCruiserShips++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name, commissionYear, maximalSpeed, crewMembers, Collections.singletonList(new Weapon("Laser Cannons", 10, 100)));
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return 2500 + this.weaponsAnnualCost() + Math.round(1000 * getMaximalSpeed()) + (50 * numsOfCruiserShips) ;
	}
	
}
