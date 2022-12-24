package places.socialPlaces;

import actors.Human;
import actors.Loudthroat;
import enums.Position;
import places.Place;
import java.util.ArrayList;
import java.util.Objects;

public abstract class SocialPlace extends Place {
    protected int noise;
    protected ArrayList<Human> visitors;

    public SocialPlace(String name, Position position){
        this.name = name;
        this.position = position;
        this.noise = 0;
        this.visitors = new ArrayList<Human>(0);
    }

    public SocialPlace(){
        this("неизвестное публичное место",Position.UNKNOWN);
    }

    public void irritate(){
        for (Human human : visitors){
            if (!human.getPlace().equals(this)){
                this.removeVisitor(human);
            }
        }
        if (noise > 100){

            int countLoud = 0;

            for (Human human : visitors){
                human.irritationAction(this);
                if (human instanceof Loudthroat){
                    countLoud += 1;
                }
            }

            if (countLoud == 0){
                this.changeNoise(-noise);
                for (Human human : visitors){
                    human.setNerves(100);
                }
            }
        }
    }

    public void changeNoise(int noise){
        this.noise += noise;
    }

    public ArrayList<Human> getVisitors() {
        return this.visitors;
    }

    public void addVisitor(Human human){
        this.visitors.add(human);
    }

    public void removeVisitor(Human human){
        this.visitors.remove(human);
    }

    public String getStrVisitors(){
        String list = "находятся: ";

        for (Human human : visitors){
            list += human.getName();
        }

        return list;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject)) return false;

        SocialPlace other = (SocialPlace) otherObject;

        boolean result = (this.noise == other.noise) && (this.visitors.equals(other.visitors));

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), noise);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name  + "position=" + position.getPlace() + "noise=" + noise + "visitors=" + this.getStrVisitors() + "]";
    }
}