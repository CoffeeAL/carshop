package com.loiko.alex.repository;

import com.loiko.alex.user.User;
import com.loiko.alex.user.role.AdminRole;
import com.loiko.alex.user.role.ClientRole;
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
//
//    List<ClientRole> findAllClientsByRole(ClientRole clientRole);
//
//    @Modifying
//    @Query(value = "DELETE FROM carshop_storage.admin WHERE admin_id = :adminId", nativeQuery = true)
//    void deleteAdminById(@Param("adminId") Long adminId);
//
//    @Modifying
//    @Query(value = "DELETE FROM carshop_storage.client WHERE client_id = :clientId", nativeQuery = true)
//    void deleteClientById(@Param("clientId") Long clientId);
//
//    @Modifying
//    @Query(value = "INSERT INTO carshop_storage.client (role) VALUES (:role)", nativeQuery = true)
//    void addClient(@Param("role") ClientRole clientRole);
}