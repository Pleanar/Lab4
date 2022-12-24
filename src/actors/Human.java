package actors;

import enums.Position;
import interfaces.IName;
import places.Place;
import places.estate.Home;
import places.socialPlaces.SocialPlace;
import requisite.weapons.Fists;
import requisite.weapons.Stick;
import requisite.weapons.Stone;
import requisite.weapons.Weapon;
import java.util.Objects;
import static java.lang.Math.round;

public abstract class Human implements IName {

    protected Place place;

    protected String name;

    protected int nerves = 100;

    protected int health = 100;

    protected Weapon weapon;

    public Human(){
        this("кто-то", new Home("дом кого-то", "кто-то", Position.UNKNOWN));
    }

    public Human(String name){
        this(name, new Home("дом " + name, name, Position.UNKNOWN));
    }

    public Human(Place place){
        this("кто-то", place);
    }

    public Human(String name, Place place){
        this.name = name;
        this.place = place;
        if (place instanceof SocialPlace){
            SocialPlace socialPlace = (SocialPlace) place;
            socialPlace.addVisitor(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Place getPlace(){
        return this.place;
    }

    public String getStrPlace() {
        return place.getName() + ", которая находится "+ place.getPosition();
    }

    public abstract void irritationAction(SocialPlace socialPlace);

    public Weapon acquireWeapon(){
        double luck = 100*Math.random();
        if (luck >= 67){
            return new Stone();
        }

        if (luck <= 33){
            return new Fists();
        }

        return new Stick();
        }

    public void damage(Human human, Weapon weapon){
        human.takeDamage(weapon);
    }

    public void takeDamage(Weapon weapon){
        this.health -= round(10 * weapon.getMultiplier());
        if (this.health <= 0) {
            throw new DeathError();
        }
    }

    public void setNerves(int nerves){
        this.nerves = nerves;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Human other = (Human) otherObject;

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

    protected class DeathError extends RuntimeException{
        public DeathError(){
            System.out.println("Кто-то умер! Сказка развалилась.");
        }
    }
}