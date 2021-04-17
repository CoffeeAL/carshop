package com.loiko.alex.repository;

import com.loiko.alex.brand.Brand;
import com.loiko.alex.model.CarModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarModelRepository extends CrudRepository<CarModel, Long>, BaseRepository<CarModel, Long> {

    //TODO use Optional
    CarModel findByBrand(Brand brand);

    //TODO use Optional
    CarModel findByBrandAndModel(Brand brand, String model);
}