package com.webshop.model;

import com.webshop.model.items.*;
import com.webshop.model.users.Customer;
import com.webshop.model.users.Seller;
import com.webshop.repository.CreatorRepository;
import com.webshop.repository.CustomerRepository;
import com.webshop.repository.ItemRepository;
import com.webshop.repository.SellerRepository;
import org.postgresql.util.PGmoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * We want to execute some piece of code exactly before the application startup completes
 */
@Component
public class ExampleData implements ApplicationRunner {

    private static final List<Customer> CUSTOMERS = new ArrayList<>();
    private static final List<Seller> SELLERS = new ArrayList<>();
    private static final List<Creator> CREATORS = new ArrayList<>();

    private static final List<Game> GAMES = new ArrayList<>();
    private static final List<Book> BOOKS = new ArrayList<>();
    private static final List<Movie> MOVIES = new ArrayList<>();

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
        customer.setName("Ewa");
        customer.setSurname("Kowalska");
        customer.setUsername("ewa79");
        customer.setPassword("marek2008");
        CUSTOMERS.add(customer);
    }

    private static void addingSellers(){
        Seller seller = new Seller();
        seller.setName("Anna");
        seller.setSurname("Kowalska");
        seller.setUsername("anna78");
        seller.setPassword("jaroslawa2018");
        SELLERS.add(seller);
    }

    private static void addingItemsAndCreators(){
        Creator writer = new Creator();
        Creator gameDeveloper = new Creator();
        Creator director = new Creator();

        writer.setName("Agatha Christie");
        writer.setCountry("English");
        writer.setType("WRITER");

        gameDeveloper.setName("REDMaxis");
        gameDeveloper.setCountry("USA");
        gameDeveloper.setType("GAME_DEV");

        director.setName("DIZNEI");
        director.setCountry("USA");
        director.setType("MOVIE");

        CREATORS.add(writer);
        CREATORS.add(gameDeveloper);
        CREATORS.add(director);

        BOOKS.add((Book) ItemFactory.createItem(ItemFactory.ItemTypes.BOOK, "A Murder is Announced",
                "Agatha Christie’s most ingenious murder mystery...", writer,
                Date.valueOf("2015-07-15"), new BigDecimal(35.49)));
        BOOKS.add((Book) ItemFactory.createItem(ItemFactory.ItemTypes.BOOK, "Death in the Clouds",
                "Death in the Clouds is a work of detective fiction by British writer Agatha Christie",
                writer, Date.valueOf("2015-07-15"), new BigDecimal(35.49)));
        GAMES.add((Game) ItemFactory.createItem(ItemFactory.ItemTypes.GAME, "The Sims 3",
                "The Sims 3 is the third major title in the life simulation video game developed by Maxis " +
                        "and published by Electronic Arts", gameDeveloper, Date.valueOf("2009-06-02"),
                new BigDecimal(59.99)));
        GAMES.add((Game) ItemFactory.createItem(ItemFactory.ItemTypes.GAME, "The Sims 4",
                "The Sims 4 is the fourth major title in the life simulation video game series The Sims.",
                gameDeveloper, Date.valueOf("2014-09-05"), new BigDecimal(122.99)));
        MOVIES.add((Movie) ItemFactory.createItem(ItemFactory.ItemTypes.MOVIE, "The Lion King",
                "After the murder of his father, a young lion prince flees his kingdom only to learn the " +
                        "true meaning of responsibility and bravery.", director, Date.valueOf("2019-07-19"),
                new BigDecimal(54.47)));
        MOVIES.add((Movie) ItemFactory.createItem(ItemFactory.ItemTypes.MOVIE, "Toy Story 4",
                "When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and " +
                        "new friends reveals how big the world can be for a toy.", director,Date.valueOf("2019-08-09"),
                new BigDecimal(35.49)));
    }

    /**
     * Saves example data in database when application starts
     * @param args arguments with which application starts
     * @throws Exception it may be everything
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        creatorRepository.saveAll(CREATORS);
        movieRepository.saveAll(MOVIES);
        gameRepository.saveAll(GAMES);
        bookRepository.saveAll(BOOKS);
        sellerRepository.saveAll(SELLERS);
        customerRepository.saveAll(CUSTOMERS);
    }
}
