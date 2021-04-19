package com.loiko.alex.model;

import com.loiko.alex.common.BaseDaoImpl;
import com.loiko.alex.sparepart.SparePart;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class ModelDaoImpl {

//    private final QModel MODEL = QModel.model;
//    private final Session SESSION = sessionFactory.getCurrentSession();
//    private static final ModelDaoImpl INSTANCE = new ModelDaoImpl();
//
//    @Autowired
//    public static ModelDaoImpl getInstance() {
//        return INSTANCE;
//    }
//
//    @Override
//    public Class<Model> getEntityClass() {
//        return Model.class;
//    }
//
//    @Override
//    public List<Model> findAll() {
//        return new JPAQuery<Model>(SESSION)
//                .select(MODEL)
//                .from(MODEL)
//                .fetch();
//    }
//
//    @Override
//    public List<SparePart> getSparePartList(Model model) {
//        return new JPAQuery<SparePart>(SESSION)
//                .select(QSparePart.sparePart)
//                .from(QSparePart.sparePart)
//                .where(QSparePart.sparePart.models.contains(model))
//                .fetch();
//    }
//
//    @Override
//    public Optional<Model> findById(Long id) {
//        return new JPAQuery<Model>(SESSION)
//                .select(MODEL)
//                .from(MODEL)
//                .where(MODEL.id.eq(id))
//                .fetch()
//                .stream()
//                .findAny();
//    }
}