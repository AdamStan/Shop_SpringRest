package com.webshop.model

import com.webshop.model.items.Book
import com.webshop.model.items.Game
import com.webshop.model.items.Item
import com.webshop.model.items.Movie
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertTrue;
import org.postgresql.util.PGmoney

import java.sql.Date

/**
 * Tests function to create item from ItemFactory
 */
class ItemFactoryTest {
    @Test
    void createBook(){
        Item item = ItemFactory.createItem(ItemFactory.ItemTypes.BOOK, "A Murder is Announced",
                "Agatha Christie’s most ingenious murder mystery...", writer,
                Date.valueOf("2015-07-15"), new PGmoney(35.49));
        assertTrue(item instanceof Book);
    }

    @Test
    void createGame(){
        Item item = ItemFactory.createItem(ItemFactory.ItemTypes.GAME, "The Sims 3",
                "The Sims 3 is the third major title in the life simulation video game developed by Maxis " +
                        "and published by Electronic Arts", gameDeveloper, Date.valueOf("2009-06-02"),
                new PGmoney(59.99));
        assertTrue(item instanceof Game)
    }

    @Test
    void createMovie(){
        Item item = ItemFactory.createItem(ItemFactory.ItemTypes.MOVIE, "Toy Story 4",
                "When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and " +
                        "new friends reveals how big the world can be for a toy.", director,Date.valueOf("2019-08-09"),
                new PGmoney(35.49));
        assertTrue(item instanceof Movie);
    }

    @Test
    void createItem(){
        Item item = ItemFactory.createItem(ItemFactory.ItemTypes.ITEM, "Toy Story 4",
                "When a new toy called \"Forky\" joins Woody and the gang, a road trip alongside old and " +
                        "new friends reveals how big the world can be for a toy.", director,Date.valueOf("2019-08-09"),
                new PGmoney(35.49));
        assertFalse(item instanceof Movie);
        assertFalse(item instanceof Game);
        assertFalse(item instanceof Book);
    }
}
