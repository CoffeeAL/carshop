package com.loiko.alex.common;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<T extends BaseEntityImpl<U>, U extends Serializable> {

    U save(T model);

    List<T> findAll();

    Optional<T> findById(U id);

    void update(T model);

    void delete(T model);
}