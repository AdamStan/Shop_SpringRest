package com.webshop.repository;

import com.webshop.model.users.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Integer> {
}
