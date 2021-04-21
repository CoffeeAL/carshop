package com.loiko.alex.repository;

import com.loiko.alex.country.Country;
import com.loiko.alex.producer.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProducerRepository extends CrudRepository<Producer, Long>, CustomProducerRepository {

    Optional<Producer> findByProducerName(String producerName);

    @Query(value = "select p.* " +
            "from carshop_storage.producer p " +
            "join carshop_storage.spare_part s " +
            "   on p.id = s.producer_id " +
            "where p.producer_name = :name", nativeQuery = true)
    Optional<Producer> findByProducerNameNative(@Param("name") String producerName);

    List<Producer> findByCountry(Country country);

    Optional<Producer> findByProducerNameAndCountry(String producerName, Country country);

//    @Query("select m " +
//            "from Movie m " +
//            "join m.director d " +
//            "where m.name = :name and d.firstName = :firstName")
//    Optional<Movie> customMethod(@Param("name") String movieName, @Param("firstName") String directorName);

//        @Query("select sp " +
//            "from SparePart sp " +
//            "join sp.producer p"  +
//            "where p.producerName = :name and sp.vendorCode = :vendorCode")
//    Optional<Producer> customMethod(@Param("name") String producerName, @Param("vendorCode") String vendorCode);
}