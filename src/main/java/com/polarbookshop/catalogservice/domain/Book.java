package com.polarbookshop.catalogservice.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

// starting from java 14 we can make use of record class insted of the old java POJOS used to create DTO's
// as you can see here the record class doesn't need to have a getter and setter declared, also the properties are provided on the constructor
// a record clas also can be used as and entity just by providing an @id annotation on constructor
public record Book(
        @Id
        Long id,
        @NotBlank(message = "The book ISBN must be defined.")
        @Pattern(
                regexp = "^([0-9]{10}|[0-9]{13})$",
                message = "The ISBN format must be valid."
        )
        String isbn,
        @NotBlank(
                message = "The book title must be defined."
        )
        String title,
        @NotBlank(message = "The book author must be defined.")
        String author,
        @NotNull(message = "The book price must be defined.")
        @Positive(message = "The book price must be greater than zero.")
        Double price,
        @Version
        int version
        ) {

        public static Book of(String isbn, String title, String author, Double price) {
                return new Book(null, isbn, title, author, price, 0); // An entity is considered new when the ID is null and the version is 0.
        }

}
