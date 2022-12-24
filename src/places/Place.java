package places;

import enums.Position;
import interfaces.IName;
import interfaces.IPositionable;
import java.util.Objects;

public abstract class Place implements IName, IPositionable {

    protected Position position;
    protected String name;

    public Place(String name, Position position){
        this.name = name;
        this.position = position;
    }

    public Place() {
        position = Position.UNKNOWN;
        name = "безымянное место";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPosition(Position position){
        this.position = position;
    }
    public String getPosition() {
        return position.getPlace();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Place other = (Place) otherObject;

        boolean result = this.position.equals(other.position) && this.name.equals(other.name);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(position, name);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name  + "position=" + position.getPlace() + "]";
    }
}