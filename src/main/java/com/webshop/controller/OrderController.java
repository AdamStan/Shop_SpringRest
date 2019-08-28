package com.webshop.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.webshop.model.items.Item;
import com.webshop.model.order.Order;
import com.webshop.model.order.OrderToItem;
import com.webshop.repository.ItemRepository;
import com.webshop.repository.OrderRepository;
import com.webshop.repository.OrderToItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderToItemRepository orderToItemRepository;

    /**
     * Adds new order to database
     * @param form data from frontend application
     */
    @PostMapping(path = "/make")
    @ResponseStatus(HttpStatus.OK)
    @SuppressWarnings("unchecked")
    public void makeAnOrder(@RequestBody String form){
        Order newOrder = new Order();
        JsonObject object = new JsonParser().parse(form).getAsJsonObject();
        newOrder.setCity(object.getAsJsonPrimitive("city").getAsString());
        newOrder.setStreet(object.getAsJsonPrimitive("street").getAsString());
        newOrder.setNumberOfBuilding(object.getAsJsonPrimitive("numberOfBuilding").getAsString());
        newOrder.setPostalCode(object.getAsJsonPrimitive("postalCode").getAsString());
        newOrder.setDateOfOrder(LocalDateTime.now());

        JsonArray arrayOfItemsInBasket = object.getAsJsonArray("itemsInBasket");
        Set<OrderToItem> itemsToOrder = new HashSet<>();

        arrayOfItemsInBasket.forEach(e -> {
            JsonPrimitive id = e.getAsJsonObject().getAsJsonPrimitive("id");
            JsonPrimitive count = e.getAsJsonObject().getAsJsonPrimitive("count");
            Optional item = itemRepository.findById(id.getAsInt());
            if(item.isPresent() && item.get() instanceof Item){
                OrderToItem orderToItem = new OrderToItem();
                orderToItem.setAmount(count.getAsInt());
                orderToItem.setOrderObject(newOrder);
                orderToItem.setItem((Item)item.get());
                itemsToOrder.add(orderToItem);
            }
        });
        orderRepository.save(newOrder);
        orderToItemRepository.saveAll(itemsToOrder);
    }

}
