package com.loiko.alex.model;

import com.loiko.alex.common.BaseDaoImpl;
import com.loiko.alex.sparepart.SparePart;
import com.loiko.alex.sparepart.SparePart_;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ModelDaoImpl extends BaseDaoImpl<Model, Long> implements ModelDao {

    private static final ModelDaoImpl INSTANCE = new ModelDaoImpl();

    public static ModelDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Model> getEntityClass() {
        return Model.class;
    }

    @Override
    public List<SparePart> getSparePartList(Session session, Model model) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<SparePart> criteria = criteriaBuilder.createQuery(SparePart.class);
        Root<SparePart> root = criteria.from(SparePart.class);
        criteria.select(root)
                .where(criteriaBuilder.equal(root.get(SparePart_.models), model)
        );
        return session.createQuery(criteria).list();
    }
}