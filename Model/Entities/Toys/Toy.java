package Model.Entities.Toys;

import Model.Entities.AbstractClasses.Entity;
import Model.Entities.Interfaces.WeigthForGame;

public class Toy extends Entity implements WeigthForGame{
    protected int weight = 0;

    public Toy(String name){
        super(name);
    }

    public Toy(Toy toy){
        this(toy.getName());
        super.id = toy.getId();
        this.weight = toy.getWeight();
        super.count = toy.getCount();
    }

    public boolean setWeight(int weight){
        if(weight >= 0 && weight <= 100){
            this.weight = weight;
            return true;
        }
        else return false;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString() {
        return super.toString() + Integer.toString(weight);
    }

    @Override
    public String getData() {
        return super.getData() + "Вес вероятности выпадения в %: " + Integer.toString(weight) + "\n";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Toy toy = new Toy(this.name);
        toy.setId(this.id);
        toy.setWeight(this.weight);
        toy.setCount(this.count);
        return (Object)toy;
    }
}