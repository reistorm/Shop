package Database.Interfaces;

import java.util.List;

import Model.Entities.AbstractClasses.Entity;

public interface DbRequest <T extends Entity>
{
    public void CreateTableEntity();
    public void CreateTablePrize();
    public List<T> getAllEntities();
    public T getEntityById(int id);
    public List<T> getEntitiesByName(String name);
    public void addEntity(T entity);
    public void updateEntity(T entity);
    public void removeEntityById(int id);
    public void removeAllEntity();
    public String getAllPrizes();
    public void addPrizes(T entity);

}