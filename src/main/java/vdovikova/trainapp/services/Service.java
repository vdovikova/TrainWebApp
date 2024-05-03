package vdovikova.trainapp.services;

import java.sql.SQLException;
import java.util.List;

public interface Service <T, Id>{
    void add(T obj);
    T getById(Id id) throws SQLException;
    List<T> getAll();
    void update(T obj);
    void deleteById(Id id);
    void deleteAll();
}
