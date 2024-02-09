package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public record Book (String id, String name, int pageCount, String authorId) {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "Effective Java", 416, "0"),
            new Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "1"),
            new Book("book-3", "Down Under", 436, "2")
    );

    public static Book getById(String id) {
        return books.stream()
				.filter(book -> book.id().equals(id))
				.findFirst()
				.orElse(null);
    }

    public static Stream<Book> getAllBooks() {
        return books.stream();
    } 
}