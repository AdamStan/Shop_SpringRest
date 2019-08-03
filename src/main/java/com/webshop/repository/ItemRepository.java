package com.webshop.repository;

import com.webshop.model.items.Book;
import com.webshop.model.items.Game;
import com.webshop.model.items.Item;
import com.webshop.model.items.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository<T extends Item> extends CrudRepository<T, Integer> {
    Iterable<Item> findByName(String name);
    @Query("select e from Game as e")
    List<Game> findAllGames();
    @Query("select e from Book as e")
    List<Book> findAllBooks();
    @Query("select e from Movie as e")
    List<Movie> findAllMovies();
}
