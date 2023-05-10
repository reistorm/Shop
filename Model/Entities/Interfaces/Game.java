package Model.Entities.Interfaces;

import java.util.List;

import Model.Entities.AbstractClasses.Entity;

public interface Game <T extends Entity & WeigthForGame>{
    public boolean addAward(T entity);
    public boolean removeAwardbyId(int id);
    public void removeAllAwards();
    public boolean setAwordById(int id);
    public boolean setAwardByIndex(int index);
    public String getAllAwardData();
    public List <T> getAllAwards();
    public Entity getAward();
}