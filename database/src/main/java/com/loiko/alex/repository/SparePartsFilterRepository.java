package com.loiko.alex.repository;

import com.loiko.alex.sparepart.LimitOffSetDto;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePartFilterDto;

import java.util.List;

public interface SparePartsFilterRepository {

    List<SparePart> filterAllSpareParts(SparePartFilterDto filters, LimitOffSetDto limitOffset);
}