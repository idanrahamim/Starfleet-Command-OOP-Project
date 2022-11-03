package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class mySpaceship implements Spaceship{

    private String name;
    private int commissionYear;
    private float maximalSpeed;
    private Set<? extends CrewMember> crewMembers;

    protected mySpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.commissionYear = commissionYear;
        this. maximalSpeed = maximalSpeed;
        this.crewMembers = crewMembers;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getCommissionYear(){
        return this.commissionYear;
    }

    @Override
    public float getMaximalSpeed(){
        return this.maximalSpeed;
    }

    public int getFirePower(){
        return 10;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public String toString(){
        return getClass().getSimpleName() +
                "\n\t" + "Name=" + getName() +
                "\n\t" + "CommissionYear=" + getCommissionYear() +
                "\n\t" + "MaximalSpeed=" + getMaximalSpeed() +
                "\n\t" + "FirePower=" + getFirePower() +
                "\n\t" + "CrewMembers=" + getCrewMembers().size() +
                "\n\t" + "AnnualMaintenanceCost=" + getAnnualMaintenanceCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mySpaceship that = (mySpaceship) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
