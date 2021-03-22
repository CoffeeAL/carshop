package com.loiko.alex.sparepart;

import com.loiko.alex.common.BaseDaoImpl;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SparePartDaoImpl extends BaseDaoImpl<SparePart, Long> implements SparePartDao {

    private static final QSparePart SPARE_PART = QSparePart.sparePart;
    private final Session SESSION = sessionFactory.getCurrentSession();
    private static final SparePartDaoImpl INSTANCE = new SparePartDaoImpl();

    public static SparePartDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<SparePart> getEntityClass() {
        return SparePart.class;
    }

    @Override
    public List<SparePart> findAll() {
        return new JPAQuery<SparePartDao>(SESSION)
                .select(SPARE_PART)
                .from(SPARE_PART)
                .fetch();
    }

    @Override
    public Optional<SparePart> findById(Long id) {
        return new JPAQuery<SparePart>(SESSION)
                .select(SPARE_PART)
                .from(SPARE_PART)
                .where(SPARE_PART.id.eq(id))
                .fetch()
                .stream()
                .findAny();
    }

    @Override
    public List<SparePart> filterAllSpareParts(SparePartFilterDto filters, LimitOffSetDto limitOffset) {
        return new JPAQuery<SparePart>(SESSION)
                .select(SPARE_PART)
                .from(SPARE_PART)
                .where(SPARE_PART.sparePartName.eq(filters.getSparePartName()))
                .where(SPARE_PART.producer.country.eq(filters.getCountry()))
                .where(SPARE_PART.price.eq(filters.getPrice()))
                .fetch();
    }
}