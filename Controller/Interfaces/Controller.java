package Controller.Interfaces;

import java.util.List;

import Model.Entities.AbstractClasses.Entity;

public interface Controller {
    public List <Entity> getAllEntities();

    public void addEntity(String data);

    public Entity getEntityById(int Id);

    public List <Entity> getEntitiesByName(String name);

    public void updateEntity(String data);

    public void removeEntityById(int id);

    public void removeAllEntity();

    public boolean checkGame();

    public Entity runGame();

    public void addEntityToGameList(Entity entity);

    public String getGameEntityList();

    public boolean trySetEntityByIdForGame(int id);

    public boolean trySetEntityByIndexForGame(int index);

    public boolean tryRemoveEntityByIdFromGameList(int id);

    public void tryRemoveAllEntityFromGameList();
}