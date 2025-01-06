package pl.myapp.java.concurrency.synchronize;

/*
  Because these two methods use different monitor objects, they will not mutually exclude threads from entering them.
 */
public class MultipleMonitorObjects {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    private int counter1 = 0;
    private int counter2 = 0;

    // synchronized using monitor1 object
    public void incCounter1() {
        synchronized (this.monitor1) {
            this.counter1++;
        }
    }

    // synchronized using monitor2 object
    public void incCounter2() {
        synchronized (this.monitor2) {
            this.counter2++;
        }
    }
}
