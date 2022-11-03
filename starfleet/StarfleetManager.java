package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.*;
import java.util.stream.Collectors;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<Spaceship> s = new ArrayList<Spaceship>(fleet);
		Collections.sort(s);
		return s.stream().map(Spaceship::toString).collect(Collectors.toList());
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> h = new HashMap<>();
		for (Spaceship i : fleet){
			String s = i.getClass().getSimpleName();
			if (h.containsKey(s)){
				h.put(s, h.get(s)+1);
			}else {
				h.put(s, 1);
			}
		}
		return h;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		return fleet.stream().map(Spaceship::getAnnualMaintenanceCost).reduce((x,y)-> x+y).get();
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		return fleet.stream().filter(x-> x instanceof myBattleSpaceship)
				.map(x-> (myBattleSpaceship) x).map(myBattleSpaceship::getWeapon).flatMap(Collection::stream).map(Weapon::getName)
				.collect(Collectors.toSet());
	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		return (int) fleet.stream().map(x-> (mySpaceship) x).map(mySpaceship::getCrewMembers)
				.mapToLong(Collection::size).sum();

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		return (float) fleet.stream().map(x-> (mySpaceship) x).map(mySpaceship::getCrewMembers)
				.flatMap(Collection::stream).filter(x-> x instanceof Officer)
				.map(x-> (Officer) x).mapToDouble(Officer::getAge).average().getAsDouble();
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer, Spaceship> m = new HashMap<>();
		for (Spaceship i : fleet){
			i.getCrewMembers().stream().filter(x-> x instanceof Officer)
					.map(x-> (Officer) x).max(Comparator.comparing(Officer::getRank)).ifPresent(x -> m.put(x, i));
		}
		return m;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank, Integer> m = new HashMap<>();
		List<OfficerRank> s = fleet.stream().map(x-> (mySpaceship) x).map(mySpaceship::getCrewMembers)
				.flatMap(Collection::stream).filter(x-> x instanceof Officer).map(x-> (Officer) x).map(Officer::getRank)
				.collect(Collectors.toList());
		for (OfficerRank i : s){
			if (m.get(i) != null){
				m.put(i, m.get(i)+1);
			}else{
				m.put(i,1);
			}
		}
		List<Map.Entry<OfficerRank, Integer>> res = new ArrayList<>(m.entrySet());
		res.sort((x,y)->{
			if (x.getValue() != y.getValue()){
				return Integer.compare(x.getValue(),y.getValue());
			}else {
				return x.getKey().compareTo(y.getKey());
			}
		});
		return res;
	}

}
