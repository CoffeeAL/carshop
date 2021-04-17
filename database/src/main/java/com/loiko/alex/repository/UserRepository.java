package com.loiko.alex.repository;

import com.loiko.alex.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>, BaseRepository<User, Long> {

}