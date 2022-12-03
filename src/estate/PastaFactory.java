package estate;

import enums.Place;

public class PastaFactory extends Immovables {


    public PastaFactory(String name, String owner, Place position){
        super(name, owner, position);
    }

    public PastaFactory() {
        super();
        this.setName("безымянная макаронная фабрика");
    }
}