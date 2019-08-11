package com.webshop.repository;

import com.webshop.model.items.Book;
import com.webshop.model.items.Game;
import com.webshop.model.items.Item;
import com.webshop.model.items.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository<T extends Item> extends CrudRepository<T, Integer> {
    Iterable<Item> findByName(String name);
    @Query("select e from Game as e")
    List<Game> findAllGames();
    @Query("select e from Book as e")
    List<Book> findAllBooks();
    @Query("select e from Movie as e")
    List<Movie> findAllMovies();

    /**
     * Searchs in database for item with name like %name%
     * @param name
     * parameter for item's name
     * @return
     * list with items which has name like name
     */
    @Query(value = "select e from Item as e where LOWER(e.name) LIKE CONCAT('%', LOWER(:search_name),'%')")
    List<Item> findByNameWithQuery(@Param("search_name") String name);
}
