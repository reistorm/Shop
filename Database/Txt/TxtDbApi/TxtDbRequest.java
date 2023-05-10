package Database.Txt.TxtDbApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.io.File;

import Database.Interfaces.DbRequest;
import Model.Entities.AbstractClasses.Entity;
import Model.Infrastructure.Interfaces.EntityFactory;

public class TxtDbRequest<T extends Entity> implements DbRequest<T> {

    private Utilities util;
    EntityFactory <T> factory;
    private String pathEntity;
    private String pathPrize;

    public TxtDbRequest(String path, EntityFactory <T> factory) {
        this.pathEntity = path + "EntityDb.txt";
        this.pathPrize = path + "PrizeDb.txt";
        this.util = new Utilities();
        this.factory = factory;
    }


    @Override
    public void CreateTableEntity() {
        CreateTable(this.pathEntity);
    }

    @Override
    public void CreateTablePrize() {
        CreateTable(this.pathPrize);
    }

    private void CreateTable(String path){
        File file = new File(path);
        if (file.exists()) return;
        else{
            this.util.WriteFile(path, "0<maxId>\n");
        }
    }

    @Override
    public List<T> getAllEntities() {
        StringBuilder data = util.ReadFile(this.pathEntity);
        return getEntities(data);
    }

    public List<T> getEntities(StringBuilder data){
        List<T> result = new ArrayList<T>();
        String[] stringsData = data.toString().split("<maxId>\n");
        if(stringsData.length == 1) return result;
        String[] entitiesData = stringsData[1].split("\n");
        Arrays.stream(entitiesData).forEach(s -> result.add(factory.createEntity(s)));
        return result;
    }

    @Override
    public T getEntityById(int id) {
        StringBuilder data = util.ReadFile(this.pathEntity);
        for (T entity : getEntities(data)) if(entity.getId() == id) return entity;
        return null;
    }

    @Override
    public List<T> getEntitiesByName(String name) {
        StringBuilder data = util.ReadFile(this.pathEntity);
        return getEntities(data).stream().filter(t -> t.getName().toLowerCase().indexOf(name.toLowerCase()) != -1).toList();
    }

    @Override
    public void addEntity(T entity) {
        StringBuilder data = util.ReadFile(this.pathEntity);
        int maxId = Integer.valueOf(data.toString().split("<maxId>\n")[0]);
        String newMaxId = Integer.toString(maxId + 1);
        String entityData = newMaxId + ":" + entity.toString() + "\n";
        data.append(entityData).replace(0, data.indexOf("<maxId>\n"), newMaxId);
        util.WriteFile(this.pathEntity, data.toString());
    }

    @Override
    public void updateEntity(T entity) {
        StringBuilder data = util.ReadFile(this.pathEntity);
        List<T> entities = getEntities(data);
        String resultStr = data.toString();
        for (T t : entities) {
            if(t.getId() == entity.getId()){
                String oldEntityData = Integer.toString(t.getId()) + ":" + t.toString();
                String newEntityData = Integer.toString(entity.getId()) + ":" + entity.toString();
                resultStr = resultStr.replace(oldEntityData, newEntityData);
                break;
            }
        }
        util.WriteFile(this.pathEntity, resultStr);
    }

    @Override
    public void removeEntityById(int id) {
        StringBuilder data = util.ReadFile(this.pathEntity);
        List<T> entities = getEntities(data);
        String resultStr = data.toString();
        for (T t : entities) {
            if(t.getId() == id){
                String oldEntityData = Integer.toString(t.getId()) + ":" + t.toString() + "\n";
                resultStr = resultStr.replace(oldEntityData, "");
                break;
            }
        }
        util.WriteFile(this.pathEntity, resultStr);
    }

    @Override
    public void removeAllEntity() {
        StringBuilder data = util.ReadFile(this.pathEntity);
        String maxId = data.toString().split("<maxId>\n")[0];
        this.util.WriteFile(this.pathEntity, maxId + "<maxId>\n");
    }

    @Override
    public String getAllPrizes() {
        StringBuilder data = util.ReadFile(this.pathPrize);
        String[] stringsData = data.toString().split("<maxId>\n");
        if(stringsData.length == 1) return "";
        return stringsData[1];
    }

    @Override
    public void addPrizes(T entity) {
        StringBuilder data = util.ReadFile(this.pathPrize);
        Date dateTime = new Date();
        int maxId = Integer.valueOf(data.toString().split("<maxId>\n")[0]);
        String newMaxId = Integer.toString(maxId + 1);
        String prizeData = newMaxId + ":" + entity.getName() + ":" + dateTime.toString() + "\n";
        data.append(prizeData).replace(0, data.indexOf("<maxId>\n"), newMaxId);
        util.WriteFile(this.pathPrize, data.toString());
    }

    
}