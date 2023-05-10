package Model.Infrastructure.Interfaces;

import java.util.List;

import Model.Entities.AbstractClasses.Entity;


public interface Infrastructure {
    public List<Entity> getAllEntities();

    public Entity createEntity(String data);

    public void addEntity(Entity entity);

    public Entity getEntityById(int id);

    public List<Entity> getEntitiesByName(String name);

    public void updateEntity(Entity entity);

    public void removeEntityById(int id);

    public void removeAllEntity();

    public boolean checkGame();

    public Entity tryGetAword();

    public void addEntityToPrizeTable(Entity entite);

    public void addEntityToGameList(Entity entity);

    public void removeEntityFromGameList(Entity entite);

    public String getGameEntityList();

    public boolean trySetEntityByIdForGame(int id);

    public boolean trySetEntityByIndexForGame(int index);

    public boolean tryRemoveEntityByIdFromGameList(int id);

    public void tryRemoveAllEntityFromGameList();
}