package pl.myapp.java.examples.concurrency.synchronize;

public class Reentrance {
    private int count = 0;

    public synchronized void inc() {
        count++;
    }

    // A thread that already holds the lock on a monitor object a given synchronized block is synchronized on can enter
    // the new synchronized block on the same monitor object. This is what is called reentrance.
    // 1. We take the thread that calls the incAndGet method
    // 2. The thread takes the lock on a monitor object that this method is synchronized on (which is the instance
    // that it is called on)
    // 3. The thread calls the inc method, which is synchronized on the same monitor object and the thread holds the lock
    // on this monitor object
    // 4. The thread increments the count field
    public synchronized int incAndGet() {
        inc();
        return count;
    }
}
