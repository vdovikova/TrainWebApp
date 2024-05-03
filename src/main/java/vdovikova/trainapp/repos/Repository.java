package vdovikova.trainapp.repos;

import java.util.List;

public interface Repository <T, Id>{
    void add (T obj);
    T getById (Id id);
    List<T> getAll();
    void update(T obj);
    void deleteById(Id id);
    void deleteAll();
}
