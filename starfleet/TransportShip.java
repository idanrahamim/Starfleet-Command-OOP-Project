package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public class TransportShip extends mySpaceship{

	private int cargoCapacity;
	private int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name, commissionYear, maximalSpeed, crewMembers);
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}

	public int getCargoCapacity(){
		return cargoCapacity;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return 3000 + (5*cargoCapacity) + (3*passengerCapacity);
	}

	@Override
	public String toString(){
		return super.toString() +
				"\n\t" + "CargoCapacity=" + cargoCapacity +
				"\n\t" + "PassengerCapacity=" + passengerCapacity;
	}

}
