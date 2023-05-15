package ar.marcesanlabs.wsmusiccatalog.infrastructure.business;

import java.util.List;

public interface ICrudService<T, E> {

    T getByKey(E key);

    List<T> getAll();

    Boolean insert(T data);

    Boolean update(T data);

    Boolean delete(E key);
}
