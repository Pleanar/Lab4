package places.unknownPlaces;

import enums.Position;
import places.Place;

public class Field extends Place {

    public Field(){
        super("неизвестное поле", Position.FIELD);
    }

    public Field(String name){
        super(name, Position.FIELD);
    }

    public Field(String name, Position position){
        super(name, position);
    }
}