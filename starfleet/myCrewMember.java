package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Objects;

public abstract class myCrewMember implements CrewMember{

    private String  name;
    private int age;
    private int yearInService;

    protected myCrewMember(int age, int yearsInService, String name){
        this.age = age;
        this.name = name;
        this.yearInService = yearsInService;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    public int getYearsInService(){
        return this.yearInService;
    }

    public String toString(){
        return getClass().getSimpleName() +
                "\n\t" + "Name=" + getName() +
                "\n\t" + "Age=" + getAge() +
                "\n\t" + "yearInService=" + getYearsInService();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myCrewMember that = (myCrewMember) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
