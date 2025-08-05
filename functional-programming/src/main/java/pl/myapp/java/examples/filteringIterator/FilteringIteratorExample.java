package pl.myapp.java.code;

import java.util.List;

public class FilteringIteratorExample {
  public static void main(String[] args) {

    pl.myapp.java.code.FilteringIterator<Integer> filteringIterator =
        new pl.myapp.java.code.FilteringIterator<>(List.of(1, 3, 3, 7, 5).iterator(), i -> i % 2 == 0);
    try {
      while (filteringIterator.hasNext()) {
        System.out.println(filteringIterator.next());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
