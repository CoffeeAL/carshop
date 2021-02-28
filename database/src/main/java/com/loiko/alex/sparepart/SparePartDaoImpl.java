package com.loiko.alex.sparepart;

import com.loiko.alex.common.BaseDaoImpl;

public class SparePartDaoImpl extends BaseDaoImpl<SparePart, Long> implements SparePartDao {
    private static final SparePartDaoImpl INSTANCE = new SparePartDaoImpl();

    public static SparePartDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<SparePart> getEntityClass() {
        return SparePart.class;
    }
}