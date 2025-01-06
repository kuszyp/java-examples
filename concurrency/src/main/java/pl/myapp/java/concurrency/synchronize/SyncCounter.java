package pl.myapp.java.concurrency.synchronize;

public class SyncCounter {
    private long counter = 0;

    public synchronized void incCounter() {
        this.counter++;
    }

    public synchronized long getCounter() {
        return this.counter;
    }
}
