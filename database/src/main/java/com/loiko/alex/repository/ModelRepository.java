package com.loiko.alex.repository;

import com.loiko.alex.carbody.CarBody;
import com.loiko.alex.engine.EngineType;
import com.loiko.alex.model.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long> {

    List<Model> findByCarBody(CarBody carBody);

    List<Model> findByEngineType(EngineType engineType);
}