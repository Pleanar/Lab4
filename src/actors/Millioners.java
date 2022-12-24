package actors;

import enums.Action;
import enums.Instruction;
import places.Place;
import places.estate.Barge;
import places.estate.Immovables;
import interfaces.IBoss;
import interfaces.IIntensinable;
import places.socialPlaces.SocialPlace;
import requisite.Stock;
import java.util.ArrayList;
import java.util.Objects;

public class Millioners extends Human implements IBoss, IIntensinable {
    private ArrayList<Stock> stocks = new ArrayList<>(0);
    private ArrayList<Immovables> immovables = new ArrayList<>(0);

    private ArrayList<String> destinationList = new ArrayList<>(0);
    private int cash = 10000000;


    public Millioners(String name){
        super(name);
    }

    public Millioners(String name, Place place){
        super(name, place);
    }

    public void irritationAction(SocialPlace socialPlace) {
    }

    public Millioners(String name, Place place, int cash) {
        this.name = name;
        this.place = place;
        try {
            if (cash < 0){
                throw new NotEnoughCashExeption("Деньги не могут быть отрицательного значения! Установлен минимум - 10000000");
            }
            if (cash > this.cash){
                this.cash = cash;
            } else {
                throw new NotEnoughCashExeption("Денег недостаточно - " + this.getName() + " не миллионер. Установлен минимум - 10000000");
            }
        } catch (NotEnoughCashExeption e){
            this.cash = 10000000;
        }
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
            list = list + "собственность - " + immovable.getName() + " находится в " + immovable.getPosition() + " ";

            if (immovable.getClass().equals(Barge.class)){
                Barge barge = (Barge) immovable;
                list = list + barge.getEmployees() + " ";
            }

            list = list + "\n";
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
        String result = this.getName() + ": дает инструкцию " + instruction.getInstruction() + " акцию - " + stock.getName()
                + " работникам " + barge.getName() + "\n";
        result += barge.applyInstructions(this, instruction, stock);
        return result;
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
        return this.name + ": " + "не " + Action.CAN_BUY.getAction() + " акцию - " +stock.getName() + " ";
    }

    public String sellStock(Stock stock){
        if (haveStock(stock)) {
            cash += stock.getPrice();
            stocks.remove(stock);
            stock.setOwner("кто-то");
            return this.name + ": " + Action.SELL.getAction() + "акцию - " + stock.getName() + " " + stock.getOwner();
        }
        return this.name + ": " + "акцию - " + stock.getName() + " не " + Action.SELL.getAction();
    }
    public boolean evaluateStock(Stock stock){
        Stock AverageStock = new Stock();
        return stock.getPrice() <= AverageStock.getPrice();
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject)) return false;

        Millioners other = (Millioners) otherObject;

        boolean result = (this.cash == other.cash) && this.stocks.equals(other.stocks)
                && this.destinationList.equals(other.destinationList) && this.immovables.equals(other.immovables);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), stocks, immovables, cash, destinationList);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "place=" + place.toString() + "cash="
                + cash + "immovables=" + this.getImmovables() + "stocks="
                + this.getStocks() + "destinationList=" + this.getDestinationList() + "]";
    }

    private class NotEnoughCashExeption extends Exception{

        public NotEnoughCashExeption(String message){
            System.out.println(message);
        }
    }
}