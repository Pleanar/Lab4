package actors;

import enums.Place;
import interfaces.IEmployee;
import interfaces.IBoss;
import requisite.Stock;

public class Loudthroat extends Entity implements IEmployee {

    private  String name;
    private Place position;

    public Loudthroat(){
        name = "Раб";
        position = Place.UNKNOWN;
    }

    Loudthroat(String name){
        super(name);
        position = Place.UNKNOWN;
    }

    public Loudthroat(String name, Place position){
        super(name, position);
    }

    public String buyInstruction(IBoss boss, Stock stock){
        String result = boss.buyStock(stock);
        return result;
    }
    public String sellInstruction(IBoss boss, Stock stock){
        String result = boss.sellStock(stock);
        return result;
    }
}