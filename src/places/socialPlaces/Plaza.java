package places.socialPlaces;

import enums.Position;

public class Plaza extends SocialPlace {
    public Plaza(String name, Position position){
        super(name, position);
    }

    public Plaza(){
        super();
        this.setName("неизвестная площадь");
    }
}