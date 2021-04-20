package com.loiko.alex.service;

import com.loiko.alex.repository.SparePartRepository;
import com.loiko.alex.sparepart.LimitOffSetDto;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePartDao;
import com.loiko.alex.sparepart.SparePartFilterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SparePartService {

    private SparePartRepository sparePartRepository;

    @Autowired
    public SparePartService(SparePartRepository sparePartRepository) {
        this.sparePartRepository = sparePartRepository;
    }

    public List<SparePart> findAll() {
        List<SparePart> spareParts = new ArrayList<>();
        sparePartRepository.findAll().forEach(spareParts::add);
        return spareParts;
    }

        public List<SparePart> filterSpareParts(SparePartFilterDto filters, LimitOffSetDto limitOffSet) {
        return null;
    }
//
//    @Transactional
//    public Long save(SparePart sparePart) {
//        return sparePartDao.save(sparePart);
//    }
//

//

}