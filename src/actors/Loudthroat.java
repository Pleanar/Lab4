package actors;

import enums.Place;
import interfaces.IEmployee;
import interfaces.IBoss;
import interfaces.IName;
import interfaces.IPositionable;
import requisite.Stock;

import java.util.Objects;

public class Loudthroat implements IEmployee, IName, IPositionable {

    private  String name;
    private Place position;

    public Loudthroat(){
        name = "Раб";
        position = Place.UNKNOWN;
    }

    Loudthroat(String name){
        this.name = name;
        position = Place.UNKNOWN;
    }

    public Loudthroat(String name, Place position){
        this.name = name;
        this.position = position;
    }

    public String buyInstruction(IBoss boss, Stock stock){
        String result = boss.buyStock(stock);
        return result;
    }
    public String sellInstruction(IBoss boss, Stock stock){
        String result = boss.sellStock(stock);
        return result;
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
        return position.getPlace();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Loudthroat other = (Loudthroat) otherObject;

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