package requisite;

import interfaces.*;
import java.util.Objects;

public abstract class Thing implements IName {
    protected String name;

    public Thing(String name){
        this.name = name;
    }

    public Thing() {
        name = "безымянная вещь";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Thing other = (Thing) otherObject;

        boolean result = this.name.equals(other.name);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "]";
    }
}