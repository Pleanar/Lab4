package actors;

import enums.Place;
import interfaces.IName;
import interfaces.IPositionable;
import java.util.Objects;

public class Entity implements IName, IPositionable {

    protected Place position;
    protected String name;


    Entity() {
        position = Place.UNKNOWN;
        name = "неизвестно кто";
    }

    Entity(String name){
        this.name = name;
        position = Place.UNKNOWN;
    }

    Entity(String name, Place position){
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Place position) {
        this.position = position;
    }

    public String getPosition() {
        return this.name + " находится в " + position.getPlace();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Entity other = (Entity) otherObject;

        boolean result = this.name.equals(other.name) && this.position.equals(other.position);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, position);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "position=" + position.getPlace() + "]";
    }
}