package places.estate;

import enums.Position;
import interfaces.*;
import places.Place;
import java.util.Objects;

public abstract class Immovables extends Place implements IPossesable {
    protected String owner;

    Immovables(String name, String owner, Position position){
        this.name = name;
        this.owner = owner;
        this.position = position;
    }

    public Immovables() {
        position = Position.UNKNOWN;
        owner = "никто";
        name = "безымянная недвижимость";
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner(){
        return this.owner;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject)) return false;

        Immovables other = (Immovables) otherObject;

        boolean result = this.owner.equals(other.owner);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), owner);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "position=" + position.getPlace() + "owner=" + owner + "]";
    }
}