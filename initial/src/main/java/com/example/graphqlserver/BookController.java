package com.example.graphqlserver;

import java.util.stream.Stream;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public Stream<Book> books() {
        return Book.getAllBooks();
    }

    @QueryMapping
    public Stream<Author> authors() {
        return Author.getAllAuthors();
    }

    @SchemaMapping
    public Author author(Book book) {
        return Author.getById(book.authorId());
    }

    @MutationMapping
    public Author addAuthor(String firsName, String lastName) {
         return Author.addAuthor(firsName, lastName);
    }

}
