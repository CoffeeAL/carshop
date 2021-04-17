package com.loiko.alex.repository;

import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.model.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ModelRepository extends CrudRepository<Model, Long>, BaseRepository<Model, Long> {

    List<Model> findByCarBodyType(CarBody carBody);

    List<Model> findByEngineType(EngineType engineType);
}