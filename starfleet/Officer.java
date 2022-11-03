package il.ac.tau.cs.sw1.ex8.starfleet;

public class Officer extends CrewWoman {

	private OfficerRank rank;

	public Officer(String name, int age, int yearsInService, OfficerRank rank) {
		super(age, yearsInService, name);
		this.rank = rank;
	}

	public OfficerRank getRank(){
		return this.rank;
	}

	public String toString(){
		return super.toString() +
				"\n\t" + "Rank=" + getRank();

	}
	
}
