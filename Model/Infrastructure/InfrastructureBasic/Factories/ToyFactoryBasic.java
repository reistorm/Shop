package Model.Infrastructure.InfrastructureBasic.Factories;

import Model.Entities.AbstractClasses.Entity;
import Model.Entities.Toys.Toy;
import Model.Infrastructure.Interfaces.EntityFactory;

public class ToyFactoryBasic implements EntityFactory<Toy>{

    @Override
    public Toy createEntity(String data) {
        String [] toyData = data.split(":");
        if(toyData.length == 3){
            Toy toy = new Toy(toyData[0]);
            toy.setCount(Integer.valueOf(toyData[1]));
            toy.setWeight(Integer.valueOf(toyData[2]));
            return toy;
        }
        else{
            Toy toy = new Toy(toyData[1]);
            toy.setId(Integer.valueOf(toyData[0]));
            toy.setCount(Integer.valueOf(toyData[2]));
            toy.setWeight(Integer.valueOf(toyData[3]));
            return toy;
        }

    }
    
}