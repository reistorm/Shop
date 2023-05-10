package Database.Txt.TxtDbApi;

import java.util.List;

import Model.Entities.Toys.Toy;
import Model.Infrastructure.InfrastructureBasic.Factories.ToyFactoryBasic;
import Model.Infrastructure.Interfaces.EntityFactory;

public class test {
    public static void main(String[] args) {
        String path = "Database/Txt/TxtDb/Database.txt";
        EntityFactory<Toy> factory = new ToyFactoryBasic();
        TxtDbRequest<Toy> db = new TxtDbRequest<Toy>(path, factory);
        // db.CreateTable();
        // Toy toy001 = factory.createEntity("Игрушка1");
        // Toy toy002 = factory.createEntity("Игрушка2");
        // Toy toy003 = factory.createEntity("Игрушка3");
        // toy001.setCount(100);
        // toy001.setWeight(50);
        // toy002.setCount(100);
        // toy002.setWeight(50);
        // toy003.setCount(100);
        // toy003.setWeight(50);
        // db.addEntity(toy001);
        // db.addEntity(toy002);
        // db.addEntity(toy003);
        // System.out.println(db.getAllEntity().toString());
        // List<Toy> toys = db.getAllEntity();
        // for (Toy toy : toys) {
        //     toy.toString();
        // }
        // System.out.println(db.getEntitiesByName("ytn").toString()); 
        Toy toy = db.getEntityById(2);
        if (toy != null) System.out.println(toy.toString());
        // toy.setName("Самолет");
        // db.updateEntity(toy);
        // System.out.println(db.getAllEntities().toString());
        // db.removeAllEntity();

    }
}