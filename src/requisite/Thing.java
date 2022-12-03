package requisite;

import interfaces.*;
import java.util.Objects;

abstract class Thing implements IName, IPossesable {
    protected String owner;
    protected String name;

    Thing (String name,String owner){
        this.name = name;
        this.owner = owner;
    }

    Thing (String name){
        this.name = name;
        owner = "никто";
    }

    Thing() {
        owner = "никто";
        name = "безымянная вещь";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Thing other = (Thing) otherObject;

        boolean result = this.name.equals(other.name) && this.owner.equals(other.owner);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, owner);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "owner=" + owner + "]";
    }
}