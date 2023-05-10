package Model.Infrastructure.Interfaces;

import Model.Entities.AbstractClasses.Entity;

public interface EntityFactory<T extends Entity> {
    public T createEntity(String data);
}