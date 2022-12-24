package places.unknownPlaces;

import enums.Position;
import places.Place;

public class Street extends Place {
    public Street(){
        super("неизвестная улица", Position.UNKNOWN);
    }

    public Street(String name){
        super(name, Position.UNKNOWN);
    }

    public Street(String name,Position position){
        super(name, position);
    }
}