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
        String query = "select sp " +
                "from SparePart sp " +
                "where sp.sparePartName = filters.getSparePartName() and sp.country = filters.getCountry() and sp.price = filters.getPrice()";
        return entityManager.createQuery(query, SparePart.class)
                .setMaxResults(limitOffset.getLimit())
                .setFirstResult(limitOffset.getOffset())
                .getResultList();
    }
}