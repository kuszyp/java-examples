package pl.myapp.java.concurrency.memory;

import java.time.Instant;

public class MyObject {
  private final Instant created;

  public MyObject() {
    created = Instant.now();
  }
}
