package actors;

import enums.Action;
import enums.Instruction;
import enums.Place;
import estate.Barge;
import estate.Immovables;
import interfaces.IBoss;
import interfaces.IIntensinable;
import interfaces.IName;
import interfaces.IPositionable;
import requisite.Stock;
import java.util.ArrayList;
import java.util.Objects;

public class Millioners implements IName, IPositionable, IBoss, IIntensinable {

    protected Place position;

    protected String name;
    private ArrayList<Stock> stocks = new ArrayList<>(0);
    private ArrayList<Immovables> immovables = new ArrayList<>(0);

    private ArrayList<String> destinationList = new ArrayList<>(0);
    private int cash = 10000000;


    public Millioners(String name){
        this.name = name;
        position = Place.UNKNOWN;
    }

    public Millioners(String name, Place position){
        this.name = name;
        this.position = position;
    }

    public Millioners(String name, Place position, int cash){
        if (cash > this.cash){
            this.cash = cash;
        }
        this.name = name;
        this.position = position;
    }

    public void addDestination(String location){
        destinationList.add(location);
    }
    public String getNextDestination() {
        return destinationList.get(0);
    }
    public String getDestinationList() {
        String list = this.getName() + " хочет пойти: " + getNextDestination();
        for (int i = 1; i < destinationList.size(); i++){
            list = list + ", " + destinationList.get(i);
        }
        return list;
    }

    public String getImmovables() {
        String list = this.getName() + " имеет ";
        for (int i = 0; i < immovables.size(); i++){
            Immovables immovable = immovables.get(i);
            list = list + "собственность - " + immovable.getName() + " находится в " + immovable.getPosition();

            if (immovable.getClass().equals(new Barge().getClass())){
                Barge barge = (Barge) immovable;
                list = list + barge.getEmployees();
            }
        }
        return list;
    }

    public void addImmovables(Immovables... newImmovables){
        if (newImmovables != null) {
            for (Immovables immovable : newImmovables) {
                immovables.add(immovable);
            }
        }
    }

    public String getStocks() {
        String list = "";
        for (int i = 0; i < stocks.size(); i++){
            Stock stock = stocks.get(i);
            list = list + "акция -" + stock.getName() + "стоимостью в" + stock.getPrice();
        }
        return list;
    }

    public String giveInstruction(Barge barge, Instruction instruction, Stock stock) {
        return barge.applyInstructions(this, instruction, stock);
    }

    public boolean haveStock(Stock stock) {
        boolean result = stocks.contains(stock);
        return result;
    }
    public String buyStock(Stock stock){
        if (evaluateStock(stock) && (cash - stock.getPrice() > 0)){
            stocks.add(stock);
            cash -= stock.getPrice();
            stock.setOwner(this.name);
            return this.name + ": " + Action.BUY.getAction() + " " + stock.getName() + " по " + stock.getPrice() + " ";
        }
        return this.name + ": " + "не " + Action.CANBUY.getAction() + "акцию - " +stock.getName() + " ";
    }

    public String sellStock(Stock stock){
        if (haveStock(stock)) {
            cash += stock.getPrice();
            stocks.remove(stock);
            stock.setOwner("кто-то");
            return this.name + ": " + Action.SELL.getAction() + "акцию - " + stock.getName() + " " + stock.getOwner();
        }
        return this.name + ": " + "акцию - " + stock.getName() + "не " + Action.SELL.getAction();
    }

    public String checkStock(Stock stock){
        if (evaluateStock(stock)){
            return this.name + ":" + Action.GET_PRICE.getAction() + " и " + Action.CANBUY.getAction() + " акцию - " + stock.getName();
        }
        else return this.name + ":" + Action.GET_PRICE.getAction() + " и не " + Action.CANBUY.getAction() + " акцию - " + stock.getName();
    }
    public boolean evaluateStock(Stock stock){
        Stock AverageStock = new Stock();
        return stock.getPrice() <= AverageStock.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(Place position) {
        this.position = position;
    }

    public String getPosition() {
        return position.getPlace();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) return true;

        if (otherObject == null) return false;

        if (!this.getClass().equals(otherObject.getClass())) return false;

        Millioners other = (Millioners) otherObject;

        boolean result = this.name.equals(other.name) && this.position.equals(other.position) && (this.cash == other.cash)
                && this.stocks.equals(other.stocks) && this.destinationList.equals(other.destinationList) && this.immovables.equals(other.immovables);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, position, stocks, immovables, cash, destinationList);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "position=" + position.getPlace() + "cash="
                + cash + "immovables=" + this.getImmovables() + "stocks="
                + this.getStocks() + "destinationList=" + this.getDestinationList() + "]";
    }
}