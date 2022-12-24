package actors;

import places.Place;
import places.estate.Barge;
import places.socialPlaces.SocialPlace;

import java.util.ArrayList;

public class Government extends Human {

    private Barge nearBarge;

    Government(){
        super("правительство");
        this.nearBarge = new Barge();
    }


    Government(Place place){
        super("правительство", place);
        this.nearBarge = new Barge();
    }

    public Government(Place place, Barge barge){
        this(place);
        this.nearBarge = barge;
    }

    public void irritationAction(SocialPlace socialPlace) {
        ArrayList<Human> visitors = socialPlace.getVisitors();
        for (Human human : visitors){
            if (human.health < 100){
                if (human instanceof Loudthroat){
                    Loudthroat loudthroat = (Loudthroat) human;
                    loudthroat.setPlace(nearBarge);
                }
            }
        }
        System.out.println(this.name + " игнорирует");
    }

    public void takeComplaint(){
        System.out.println(this.name + "ничего не делает");
    }
}