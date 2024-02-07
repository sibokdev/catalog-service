package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.repository.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import com.polarbookshop.catalogservice.domain.Book;

import java.util.List;

@Component // marking class as spring compenent to load in spring container
@Profile("testdata") // defining the profile
public class BookDataLoader {
    private final BookRepository bookRepository;
    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @EventListener(ApplicationReadyEvent.class) // next method should be executed once the application starts correctly
    public void loadBookTestData() {
        bookRepository.deleteAll();
        // changed new book for Book.of to use the record class constructor
        // The framework takes care of assigning a value for the identifier and the version under the hood.
        var book1 = Book.of("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90,"polartopia");
        var book2 = Book.of("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90,"polartopia");
        bookRepository.saveAll(List.of(book1,book2));
    }

}
