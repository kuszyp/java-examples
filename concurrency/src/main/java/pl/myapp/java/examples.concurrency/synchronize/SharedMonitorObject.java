package pl.myapp.java.examples.concurrency.synchronize;

public class SharedMonitorObject {
    private Object monitor = null;
    private int counter = 0;

    public SharedMonitorObject(Object monitor) {
        if (monitor == null) {
            throw new IllegalArgumentException("Monitor object cannot be null");
        }
        this.monitor = monitor; // monitor object can not be null
    }

    public void incCounter() {
        synchronized (this.monitor) {
            this.counter++;
        }
    }
}
