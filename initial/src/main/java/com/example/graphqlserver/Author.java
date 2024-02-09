package com.example.graphqlserver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public record Author (String id, String firstName, String lastName) {

    private static AtomicInteger autoIncrement = new AtomicInteger();

    private static List<Author> authors = Arrays.asList(
            new Author(Integer.toString(autoIncrement.getAndIncrement()), "Joshua", "Bloch"),
            new Author(Integer.toString(autoIncrement.getAndIncrement()), "Douglas", "Adams"),
            new Author(Integer.toString(autoIncrement.getAndIncrement()), "Bill", "Bryson")
    );

    public static Author addAuthor(String firstName, String lastName) {
        Author author = new Author(Integer.toString(autoIncrement.getAndIncrement()), firstName, lastName);
        authors.add(author);
        return author;
    }

    public static Author getById(String id) {
        return authors.stream()
				.filter(author -> author.id.equals(id))
				.findFirst()
				.orElse(null);
    }
}
