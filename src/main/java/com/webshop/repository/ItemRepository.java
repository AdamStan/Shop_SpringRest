package com.webshop.repository;

import com.webshop.model.items.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository<T extends Item> extends CrudRepository<T, Integer> {
}
