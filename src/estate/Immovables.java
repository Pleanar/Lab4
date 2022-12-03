package estate;

import enums.Place;
import interfaces.*;
import java.util.Objects;

public abstract class Immovables implements IName, IPossesable, IPositionable {

    private Place position;
    private String owner;
    private String name;

    Immovables(String name, String owner, Place position){
        this.name = name;
        this.owner = owner;
        this.position = position;
    }

    public Immovables() {
        position = Place.UNKNOWN;
        owner = "никто";
        name = "безымянная недвижимость";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner(){
        return this.owner;
    }

    public void setPosition(Place position) {
        this.position = position;
    }

    public String getPosition(){
        return this.position.getPlace();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Immovables other = (Immovables) otherObject;

        boolean result = this.position.equals(other.position) && this.owner.equals(other.owner) && this.name.equals(other.name);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(position, name, owner);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "owner=" + owner + "position=" + position.getPlace() + "]";
    }
}