package com.webshop.repository;

import com.webshop.model.order.OrderToItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderToItemRepository extends CrudRepository<OrderToItem, Integer> {
}
