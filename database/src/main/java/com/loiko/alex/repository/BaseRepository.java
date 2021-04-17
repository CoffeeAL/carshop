package com.loiko.alex.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, U> {

    List<T> findAll();

    Optional<T> findById(U id);
}
