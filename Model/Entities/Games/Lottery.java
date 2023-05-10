package Model.Entities.Games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Model.Entities.AbstractClasses.Entity;
import Model.Entities.Interfaces.Game;
import Model.Entities.Interfaces.WeigthForGame;

public class Lottery <T extends Entity & WeigthForGame> implements Game <T>{
    private List<T> awards = new ArrayList<T>();
    private int currentIndex = 0;

    @Override
    public boolean addAward(T entity) {
        if(entity.getCount() > 0 && !awards.contains(entity)){
            awards.add(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAwardbyId(int id) {
        for (T entity : awards) {
            if(entity.getId() == id){
                if(awards.get(currentIndex).getId() == id) currentIndex = 0;
                awards.remove(entity);
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeAllAwards() {
        awards.clear();
        currentIndex = 0;
    }

    @Override
    public boolean setAwordById(int id) {
        for (int i = 0; i < awards.size(); i++){
            if(awards.get(i).getId() == id){
                currentIndex = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setAwardByIndex(int index) {
        if(index <= awards.size() && index > 0){
            currentIndex = --index;
            return true;
        }
        return false;
    }

    @Override
    public String getAllAwardData() {
        StringBuilder data = new StringBuilder();
        int size = awards.size();
        for (int i = 0; i < size; i++) {
            data.append(Integer.toString(i + 1) + ". " + awards.get(i).getData() + "\n");
        }
        return data.toString();
    }

    @Override
    public List<T> getAllAwards() {
        return awards;
    }

    @Override
    public T getAward() {
        if(!awards.isEmpty()){
            T entity = awards.get(currentIndex);
            if(requestAward(entity.getWeight())){
                return entity;
            }  
        }
        return null;
    }

    private boolean requestAward(int weight){
        Random random = new Random();
        int num = random.nextInt(101);
        if (num <= weight) return true;
        return false;
    }
    
}