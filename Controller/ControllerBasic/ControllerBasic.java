package Controller.ControllerBasic;

import java.util.List;

import Controller.Interfaces.Controller;
import Model.Entities.AbstractClasses.Entity;
import Model.Infrastructure.Interfaces.Infrastructure;

public class ControllerBasic implements Controller{
    Infrastructure infrastructure;

    public ControllerBasic(Infrastructure infrastructure){
        this.infrastructure = infrastructure;
    }

    @Override
    public List <Entity> getAllEntities() {
        return this.infrastructure.getAllEntities();
    }

    @Override
    public void addEntity(String data) {
        Entity entity = infrastructure.createEntity(data);
        infrastructure.addEntity(entity);
    }

    @Override
    public Entity getEntityById(int id) {
        return infrastructure.getEntityById(id);
    }

    @Override
    public List<Entity> getEntitiesByName(String name) {
        return infrastructure.getEntitiesByName(name);
    }

    @Override
    public void updateEntity(String data) {
        Entity entity = infrastructure.createEntity(data);
        infrastructure.updateEntity(entity);
    }

    @Override
    public void removeEntityById(int id) {
        infrastructure.removeEntityById(id);
    }

    @Override
    public void removeAllEntity() {
        infrastructure.removeAllEntity();
    }

    @Override
    public boolean checkGame() {
        return infrastructure.checkGame();
    }

    @Override
    public Entity runGame() {
        Entity entite = infrastructure.tryGetAword();
        if (entite == null) return null;
        else{
            infrastructure.addEntityToPrizeTable(entite);
            entite.setCount(entite.getCount() - 1);
            if(entite.getCount() == 0){
                infrastructure.removeEntityFromGameList(entite);
            }
            infrastructure.updateEntity(entite);
            return entite;
        }
    }

    @Override
    public void addEntityToGameList(Entity entity) {
        infrastructure.addEntityToGameList(entity);
    }

    @Override
    public String getGameEntityList() {
        String data = infrastructure.getGameEntityList();
        data = data.isEmpty() ? "Список пуст": data;
        return data;
    }

    @Override
    public boolean trySetEntityByIdForGame(int id) {
        return infrastructure.trySetEntityByIdForGame(id);
    }

    public boolean trySetEntityByIndexForGame(int index){
        return infrastructure.trySetEntityByIndexForGame(index);
    }

    public boolean tryRemoveEntityByIdFromGameList(int id){
        return infrastructure.tryRemoveEntityByIdFromGameList(id);
    }

    public void tryRemoveAllEntityFromGameList(){
        infrastructure.tryRemoveAllEntityFromGameList();
    }
    
}
