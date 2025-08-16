package pl.myapp.java.examples.functional.filteringIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public final class FilteringIterator<E> implements Iterator<E> {

    private final ArrayList<E> list = new ArrayList<>();
    private int currentIndex = 0;

    public FilteringIterator(final Iterator<E> iterator, final Predicate<E> filter) {
        while (iterator.hasNext()) {
            E item = iterator.next();
            if (filter.test(item)) {
                list.add(item);
            }
        }
    }

    /** Returns true if there is next element matching predicate */
    @Override
    public boolean hasNext() {
        while (currentIndex < list.size()) {
            return true;
        }
        return false;
    }

    /**
     * Returns next element matching predicate if any. If no elements matching predicate are present,
     * throws NoSuchElementException
     */
    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return list.get(currentIndex++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
