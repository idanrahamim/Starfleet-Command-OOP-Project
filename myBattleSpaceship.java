package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myBattleSpaceship extends mySpaceship{
   private List<Weapon> weapons;

    public myBattleSpaceship(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name, commissionYear, maximalSpeed, crewMembers);
        this.weapons = weapons;
    }

    public List<Weapon> getWeapon(){
        return this.weapons;
    }

    public int getFirePower() {
        return super.getFirePower() + this.getWeapon().stream().map(Weapon::getFirePower).reduce(Integer::sum).get();
    }

    protected int weaponsAnnualCost(){
        return this.getWeapon().stream().map(Weapon::getAnnualMaintenanceCost).reduce(Integer::sum).get();
    }

    public String toString() {
        return super.toString() +
                "\n\t" + "WeaponArray=" + getWeapon();
    }


}
