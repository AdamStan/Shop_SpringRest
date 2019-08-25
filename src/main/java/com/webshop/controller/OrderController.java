package com.webshop.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.webshop.model.order.Order;
import com.webshop.repository.ItemRepository;
import com.webshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    /**
     * Adds new order to database
     * @param form data from frontend application
     */
    @PostMapping(path = "/make")
    @ResponseStatus(HttpStatus.OK)
    public void makeAnOrder(@RequestBody String form){
        Order newOrder = new Order();
        JsonObject object = new JsonParser().parse(form).getAsJsonObject();
        newOrder.setCity(object.getAsJsonPrimitive("city").getAsString());
        newOrder.setStreet(object.getAsJsonPrimitive("street").getAsString());
        newOrder.setNumberOfBuilding(object.getAsJsonPrimitive("numberOfBuilding").getAsString());
        newOrder.setPostalCode(object.getAsJsonPrimitive("postalCode").getAsString());
        newOrder.setDateOfOrder(LocalDateTime.now());
        orderRepository.save(newOrder);
        System.out.println(object);
        System.out.println(form);
    }

}
