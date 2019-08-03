package com.webshop.model;

import com.webshop.model.items.*;
import com.webshop.model.users.Customer;
import com.webshop.model.users.Seller;
import com.webshop.repository.CreatorRepository;
import com.webshop.repository.CustomerRepository;
import com.webshop.repository.ItemRepository;
import com.webshop.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * We want to execute some piece of code exactly before the application startup completes
 */
@Component
public class ExampleData implements ApplicationRunner {

    private static final List<Customer> CUSTOMER_LIST= new ArrayList<>();
    private static final List<Seller> SELLER_LIST = new ArrayList<>();
    private static final List<Creator> CREATOR_LIST = new ArrayList<>();

    private static Game game;
    private static Book book;
    private static Movie movie;

    @Autowired
    public CustomerRepository customerRepository;
    @Autowired
    public SellerRepository sellerRepository;
    @Autowired
    public ItemRepository<Book> bookRepository;
    @Autowired
    public ItemRepository<Game> gameRepository;
    @Autowired
    public ItemRepository<Movie> movieRepository;
    @Autowired
    public CreatorRepository creatorRepository;

    static {
        addingCustomers();
        addingSellers();
        addingItemsAndCreators();
    }

    private static void addingCustomers(){
        Customer customer = new Customer();
        customer.setName("Anna");
        customer.setSurname("Kowalska");
        customer.setUsername("anna78");
        customer.setPassword("jaroslawa2018");
        CUSTOMER_LIST.add(customer);
    }

    private static void addingSellers(){
        Seller seller = new Seller();
        seller.setName("Anna");
        seller.setSurname("Kowalska");
        seller.setUsername("anna78");
        seller.setPassword("jaroslawa2018");
        SELLER_LIST.add(seller);
    }

    private static void addingItemsAndCreators(){
        Creator writer = new Creator();
        Creator gameDeveloper = new Creator();
        Creator movieCompany = new Creator();

        writer.setName("XYZ");
        writer.setCountry("Poland");
        writer.setType("WRITER");

        gameDeveloper.setName("RED");
        gameDeveloper.setCountry("Poland");
        gameDeveloper.setType("GAME_DEV");

        movieCompany.setName("DIZNEI");
        movieCompany.setCountry("USA");
        movieCompany.setType("MOVIE");

        CREATOR_LIST.add(writer);
        CREATOR_LIST.add(gameDeveloper);
        CREATOR_LIST.add(movieCompany);

        book = new Book();
        book.setName("ABC");
        book.setDescription("ABC was written by XYZ");
        book.setCreator(writer);
        book.setBookCover("SOFT");
        book.setAvailable(Boolean.TRUE);
        book.setNumberOfSites(243);
        game = new Game();
        game.setName("AmazingGame");
        game.setDescription("");
        game.setCreator(gameDeveloper);
        game.setVideoGameGenre("Action");
        game.setHowLong(12L);
        movie = new Movie();
        movie.setName("Another SuperHero Movie");
        movie.setCarrier("DVD");
        movie.setHowLongInMinutes(69);
        movie.setMainActors("Jessica G, Maria D");
        movie.setCreator(movieCompany);

    }

    /**
     * Saves example data in database when application starts
     * @param args arguments with which application starts
     * @throws Exception it may be everything
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        creatorRepository.saveAll(CREATOR_LIST);
        movieRepository.save(movie);
        gameRepository.save(game);
        bookRepository.save(book);
        sellerRepository.saveAll(SELLER_LIST);
        customerRepository.saveAll(CUSTOMER_LIST);
    }
}
