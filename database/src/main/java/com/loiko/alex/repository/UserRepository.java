package com.loiko.alex.repository;

import com.loiko.alex.user.User;
import com.loiko.alex.user.role.AdminRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

//    Optional<User> findByLogin(String login);
//
//    List<AdminRole> findAllAdminsByRole(AdminRole adminRole);

//    @Modifying
//    @Query(value = "DELETE FROM carshop_storage.admin WHERE admin_id = :adminId", nativeQuery = true)
//    void deleteAdminById(@Param("adminId") Long adminId);
//
//    @Modifying
//    @Query(value = "DELETE FROM carshop_storage.client WHERE client_id = :clientId", nativeQuery = true)
//    void deleteClientById(@Param("clientId") Long clientId);
}