package estate;

import enums.Place;

public class Home extends Immovables{

    private String name;

    public Home(String name, String owner, Place position) {
        super(name, owner, position);
    }

}