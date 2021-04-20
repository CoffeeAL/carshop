package com.loiko.alex.repository;

import com.loiko.alex.sparepart.LimitOffSetDto;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePartFilterDto;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class SparePartsFilterRepositoryImpl implements SparePartsFilterRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<SparePart> filterAllSpareParts(SparePartFilterDto filters, LimitOffSetDto limitOffset) {
        return null;
    }
}