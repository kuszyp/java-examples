package pl.myapp.java.examples.functional.streamApi;

import java.time.LocalDate;
import java.util.List;

public final class MapMultiExample {

    /*
     * The goal is to filter even integers and double their value.
     * The classic approach uses filter and map intermediate methods.
     * The new approach uses mapMulti to achieve the same result in a more concise way.
     */
    List<Integer> evenDoubledNumbersClassic(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .toList();
    }

    List<Integer> evenDoubledNumbersNew(List<Integer> numbers) {
        return numbers.stream()
                .<Integer>mapMulti((number, consumer) -> {
                    if (number % 2 == 0) {
                        consumer.accept(number * 2);
                    }
                })
                .toList();
    }

    /*
     * The mapMulti is pretty similar to the well-known flatMap(), which is useful to flatten a nested `Stream<Stream<R>>` model.
     * In the example below, we have Book record and Author record. There is a relation one-to-many between Author and Book.
     * The goal is to convert above one-to-many model to the flat one represented by a Bookshelf record.
     */
    record Book(String title, LocalDate published) { }
    record Author(String name, List<Book> books) { }
    record Bookshelf(String author, String book) { }

    List<Bookshelf> bookshelfClassic(List<Author> authors) {
        return authors.stream()
                .flatMap(author -> author.books().stream()
                        .map(book -> new Bookshelf(
                                author.name(),
                                book.title()))
                ).toList();

    }

    List<Bookshelf> bookshelfNew(List<Author> authors) {
        return authors.stream()
                .<Bookshelf>mapMulti((author, consumer) -> {
                    for (Book book : author.books()) {
                        consumer.accept(new Bookshelf(author.name(), book.title()));
                    }
                }).toList();
    }
}
