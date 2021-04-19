package com.loiko.alex.repository;

import com.loiko.alex.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User, Long> {

}