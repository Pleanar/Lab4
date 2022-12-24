package requisite;

import interfaces.IPossesable;

import java.util.Objects;

public class Stock extends Thing implements IPossesable {

    private Integer price;
    private String owner;

    public Stock(){
        this.setName("безымянная");
        this.setPrice(10);
        this.setOwner("кто-то");
    }

    public Stock(String name){
        this.name = name;
        this.setPrice(10);
        this.setOwner("кто-то");
    }

    public Stock(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.setOwner("кто-то");
    }

    public Stock(String name, Integer price, String owner) {
        this.name = name;
        this.price = price;
        this.owner = owner;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if (!super.equals(otherObject)) return false;

        Stock other = (Stock) otherObject;

        boolean result = this.price.equals(other.price) && this.owner.equals(other.owner);

        return result;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(super.hashCode(), owner, price);
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "price=" + price + "owner=" + owner + "]";
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }
}