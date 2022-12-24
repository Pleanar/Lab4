package requisite.weapons;

import requisite.Thing;

import java.util.Objects;

abstract public class Weapon extends Thing {

    private double multiplier;

    public Weapon(){
        this("безымянное оружие",1);
    }

    public Weapon(String name, double multiplier){
        this.name = name;
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject)) return false;

        Weapon other = (Weapon) otherObject;

        boolean result = (this.multiplier == other.multiplier);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), multiplier);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "multiplier=" + multiplier + "]";
    }

}