package Model.Infrastructure.InfrastructureBasic;

import java.util.List;

import Database.Interfaces.DbRequest;
import Model.Entities.AbstractClasses.Entity;
import Model.Entities.Interfaces.Game;
import Model.Infrastructure.Interfaces.EntityFactory;
import Model.Infrastructure.Interfaces.Infrastructure;

public class InfrastructureBasic implements Infrastructure{
    
    DbRequest db;
    EntityFactory factory;
    Game game;

    public InfrastructureBasic(DbRequest db, EntityFactory factory, Game game){
        this.db = db;
        this.factory = factory;
        this.game = game;
        db.CreateTableEntity();
        db.CreateTablePrize();
    }

    public List<Entity> getAllEntities(){
        return db.getAllEntities();
    }

    @Override
    public Entity createEntity(String data) {
        return factory.createEntity(data);
    }

    @Override
    public void addEntity(Entity entity) {
        db.addEntity(entity);
    }

    @Override
    public Entity getEntityById(int id) {
        return db.getEntityById(id);
    }

    @Override
    public List<Entity> getEntitiesByName(String name) {
        return db.getEntitiesByName(name);
    }

    @Override
    public void updateEntity(Entity entity) {
        db.updateEntity(entity);
    }

    @Override
    public void removeEntityById(int id) {
        db.removeEntityById(id);
    }

    @Override
    public void removeAllEntity() {
        db.removeAllEntity();
    }

    @Override
    public boolean checkGame() {
        return !game.getAllAwardData().isEmpty();
    }

    @Override
    public Entity tryGetAword() {
        return game.getAward();
    }

    @Override
    public void addEntityToPrizeTable(Entity entite) {
        db.addPrizes(entite);
    }

    @Override
    public void addEntityToGameList(Entity entity) {
        game.addAward(entity);
    }

    @Override
    public void removeEntityFromGameList(Entity entite) {
        game.removeAwardbyId(entite.getId());
    }

    @Override
    public String getGameEntityList() {
        return game.getAllAwardData();
    }

    @Override
    public boolean trySetEntityByIdForGame(int id) {
        return game.setAwordById(id);
    }

    @Override
    public boolean trySetEntityByIndexForGame(int index) {
        return game.setAwardByIndex(index);
    }

    @Override
    public boolean tryRemoveEntityByIdFromGameList(int id) {
        return game.removeAwardbyId(id);
    }

    @Override
    public void tryRemoveAllEntityFromGameList() {
        game.removeAllAwards();
    }
}