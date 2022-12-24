package actors;

import places.Place;
import places.socialPlaces.SocialPlace;
import java.util.ArrayList;

public class Citizen extends Human {

    public Citizen(String name, Place place){
        super(name, place);
    }

    public Citizen(Place place){
        super(place);
    }

    @Override
    public void irritationAction(SocialPlace socialPlace) {
        this.nerves -= 25;
        if (nerves <= 75){
            ArrayList<Human> visitors = socialPlace.getVisitors();

            if (nerves <= 50){
                weapon = acquireWeapon();
                for (Human human : visitors){
                    if (human instanceof Loudthroat){
                        Loudthroat loudthroat = (Loudthroat) human;
                        this.damage(loudthroat, weapon);
                    }
                }
            } else {
            for (Human human : visitors){
                if (human instanceof Government){
                    Government government = (Government) human;
                    government.takeComplaint();
                }
            }
            }
        } else {
            System.out.println(this.getName() + " терпит");
        }
    }
}