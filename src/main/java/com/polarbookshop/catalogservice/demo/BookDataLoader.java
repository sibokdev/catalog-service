package com.polarbookshop.catalogservice.demo;

import com.polarbookshop.catalogservice.repository.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import com.polarbookshop.catalogservice.domain.Book;
@Component // marking class as spring compenent to load in spring container
@Profile("testdata") // defining the profile
public class BookDataLoader {
    private final BookRepository bookRepository;
    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @EventListener(ApplicationReadyEvent.class) // next method should be executed once the application starts correctly
    public void loadBookTestData() {
        var book1 = new Book("1234567891", "Northern Lights",
                "Lyra Silverstar", 9.90);
        var book2 = new Book("1234567892", "Polar Journey",
                "Iorek Polarson", 12.90);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }

}
