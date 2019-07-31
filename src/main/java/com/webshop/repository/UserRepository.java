package com.webshop.repository;

import com.webshop.model.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
