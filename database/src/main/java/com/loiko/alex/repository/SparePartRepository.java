package com.loiko.alex.repository;

import com.loiko.alex.sparepart.SparePart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SparePartRepository extends CrudRepository<SparePart, Long>, SparePartsFilterRepository {

    Optional<SparePart> findByVendorCode(String vendorCode);

    List<SparePart> findByProducer(Long producerId);
}