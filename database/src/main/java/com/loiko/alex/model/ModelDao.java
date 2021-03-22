package com.loiko.alex.model;

import com.loiko.alex.common.BaseDao;
import com.loiko.alex.sparepart.SparePart;
import org.hibernate.Session;

import java.util.List;

public interface ModelDao extends BaseDao<Model, Long> {

    List<SparePart> getSparePartList(Model model);
}