package pl.myapp.java.examples.concurrency.synchronize;

public class SyncCounter {
    private long counter = 0;

    public synchronized void incCounter() {
        this.counter++;
    }

    public synchronized long getCounter() {
        return this.counter;
    }
}
