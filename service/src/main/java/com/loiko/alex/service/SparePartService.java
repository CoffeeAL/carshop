package com.loiko.alex.service;

import com.loiko.alex.sparepart.LimitOffSetDto;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePartDao;
import com.loiko.alex.sparepart.SparePartFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SparePartService {

    @Autowired
    private SparePartService sparePartService;

    private final SparePartDao sparePartDao;

    @Autowired
    public SparePartService(SparePartDao sparePartDao) {
        this.sparePartDao = sparePartDao;
    }

    @Transactional
    public Long save(SparePart sparePart) {
        return sparePartDao.save(sparePart);
    }

    public List<SparePart> findAll() {
        return sparePartDao.findAll();
    }

    public List<SparePart> filterSpareParts(SparePartFilterDto filters, LimitOffSetDto limitOffSet) {
        return sparePartDao.filterAllSpareParts(filters, limitOffSet);
    }
}