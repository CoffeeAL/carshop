package com.loiko.alex.sparepart;

import com.loiko.alex.common.BaseDao;

import java.util.List;

public interface SparePartDao extends BaseDao<SparePart, Long> {

    List<SparePart> filterAllSpareParts(SparePartFilterDto filters, LimitOffSetDto limitOffset);
}