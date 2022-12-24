package actors;

import enums.Action;
import interfaces.IEmployee;
import interfaces.IBoss;
import places.Place;
import places.socialPlaces.SocialPlace;
import requisite.Stock;

import java.util.ArrayList;
import java.util.Objects;

public class Loudthroat extends Human implements IEmployee {

    public Loudthroat(){
        super("Раб");
    }

    public Loudthroat(String name){
        super(name);
    }

    public Loudthroat(Place place){
        super("Раб", place);
    }

    public Loudthroat(String name, Place place){
        super(name, place);
    }

    @Override
    public void irritationAction(SocialPlace socialPlace) {
        ArrayList<Human> visitors = socialPlace.getVisitors();
        weapon = acquireWeapon();
        for (Human human: visitors){
            if ((human instanceof Citizen) && (human.nerves <= 50)){
                this.damage(human, weapon);
            }
        }
    }

    public String scream(Action action, Stock stock){
        if (this.place instanceof SocialPlace){
            SocialPlace socialPlace = (SocialPlace) this.place;
            socialPlace.changeNoise(10);
            socialPlace.irritate();
        }
        return this.name + ": " + action.getAction() + " " + stock.getName() + " за " + stock.getPrice();
    }

    public String buyInstruction(IBoss boss, Stock stock){
        String result = scream(Action.CAN_BUY,stock) + "\n" + boss.buyStock(stock) + "\n";
        return result;
    }
    public String sellInstruction(IBoss boss, Stock stock){
        String result = scream(Action.CAN_SELL, stock) + "\n" + boss.sellStock(stock) + "\n";
        return result;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Loudthroat other = (Loudthroat) otherObject;

        boolean result = this.name.equals(other.name) && this.place.equals(other.place);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, place);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "place=" + place.toString() + "]";
    }
}