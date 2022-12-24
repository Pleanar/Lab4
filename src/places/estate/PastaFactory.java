package places.estate;

import enums.Position;

public class PastaFactory extends Immovables {


    public PastaFactory(String name, String owner, Position position){
        super(name, owner, position);
    }

    public PastaFactory() {
        super();
        this.setName("безымянная макаронная фабрика");
    }
}