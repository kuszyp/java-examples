package pl.myapp.java.examples.functional.streamApi;

import java.util.List;

/*
 * The goal is to filter even integers and double their value.
 * The classic approach uses filter and map intermediate methods.
 * The new approach uses mapMulti to achieve the same result in a more concise way.
 */
public final class MapMultiExample {

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

}
