package com.loiko.alex.producer;

import com.loiko.alex.common.BaseDaoImpl;
import com.loiko.alex.country.Country;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProducerDaoImpl extends BaseDaoImpl<Producer, Long> implements ProducerDao {

    private static final QProducer PRODUCER = QProducer.producer;
    private final Session SESSION = sessionFactory.getCurrentSession();
    private static final ProducerDaoImpl INSTANCE = new ProducerDaoImpl();

    public static ProducerDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Class<Producer> getEntityClass() {
        return Producer.class;
    }

    @Override
    public List<Producer> findAll() {
        return new JPAQuery<Producer>(SESSION)
                .select(PRODUCER)
                .from(PRODUCER)
                .fetch();
    }

    @Override
    public Optional<Producer> findById(Long id) {
        return new JPAQuery<Producer>(SESSION)
                .select(PRODUCER)
                .from(PRODUCER)
                .where(PRODUCER.id.eq(id))
                .fetch()
                .stream()
                .findAny();
    }

    @Override
    public List<Producer> findProducersByCountry(Country country) {
        return new JPAQuery<Producer>(SESSION)
                .select(PRODUCER)
                .from(PRODUCER)
                .where(PRODUCER.country.eq(country))
                .fetch();
    }
}