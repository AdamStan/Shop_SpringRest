package com.webshop.controller;

import com.webshop.model.items.Book;
import com.webshop.model.items.Game;
import com.webshop.model.items.Item;
import com.webshop.model.items.Movie;
import com.webshop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.OperationNotSupportedException;
import java.util.List;

@Controller
@RequestMapping(path = "/items")
public class ItemsController {
    @Autowired
    public ItemRepository<Item> itemsRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Item> getAllItems(){
        return itemsRepository.findAll();
    }

    @GetMapping(path = "/allGames")
    public @ResponseBody List<Game> getAllGames() {
        return itemsRepository.findAllGames();
    }

    @GetMapping(path = "/allBooks")
    public @ResponseBody List<Book> getAllBooks() {
        return itemsRepository.findAllBooks();
    }

    @GetMapping(path = "/allMovies")
    public @ResponseBody List<Movie> getAllMovies() {
        return itemsRepository.findAllMovies();
    }
}
