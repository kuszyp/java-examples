# java-examples

## About

Repository containing various Java examples, including:

- Concurrency, threading, and synchronization
- Different approaches to work with database
- Functional programming
- Design patterns

## Table of Contents

1. [Concurrency](#concurrency)
    1. [Memory](#memory)
    2. [Synchronization](#synchronization)
    3. [Threads](#threads)
    4. [Virtual Threads](#virtual-threads)
2. [Database](#database)
    1. [JDBC](#jdbc)
    2. [Spring Data JPA](#spring-data-jpa)
    3. [Spring Data JDBC](#spring-data-jdbc)
3. [Functional Programming](#functional-programming)
    1. [Filtering Iterator](#filtering-iterator)
    2. [Stream API](#stream-api)
4. [Contact](#contact)

## Concurrency

### Memory

### Synchronization

### Threads

### Virtual Threads

## Database

### JDBC

### Spring Data JPA

### Spring Data JDBC

### Functional Programming

#### Filtering Iterator

#### Stream API

##### mapMulti()

`mapMulti()` is a new Stream API intermediate operation, available since JDK 16. It is represented by the following
`default` method in the Stream interface:

```java
default <R> Stream<R> mapMulti(BiConsumer<? super T, ? super Consumer<R>> mapper)
```

The `mapMulti()` can be used to replace the combination of `filter()` and `map()` intermediate operations. It gets an
input stream of elements and outputs another stream containing zero, less, the same, or larger number of elements that
can be unchanged or replaced by other elements. This means that each element from the input stream can pass through a
`one-to-zero`, `one-to-one`, or `ont-to-many` mapping.

The `mapMulti()` intermediate operation is useful when we have to replace only few elements from the stream. This is
formulated in the official documentation as follows: `When replacing each element with a small (possibly zero) number of
elements`.

## Contact

You can reach me at [github.com/kuszyp](https://github.com/kuszyp) or mail me at [github[at]myapp.pl](mailto:github@myapp.pl).
