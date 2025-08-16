package pl.myapp.java.examples.concurrency.synchronize;

/*
 There are some classes that should not be used as a monitor object: strings, primitive types.
 Use objects new Object() or instances of your own classes.
*/
public class SharedMonitorObjectMain {
    public static void main(String[] args) {
        Object monitor1 = new Object();

        // If a thread calls incCounter() method on smo1 object, it will block other threads calling
        // incCounter() on smo2 object. This is because smo1 and smo2 objects share the same monitor
        // object.
        SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);
        smo1.incCounter();
        smo2.incCounter();

        Object monitor2 = new Object();

        // If a thread calls incCounter() method on smo3 object, it will not block other threads calling incCounter()
        // method on smo1 or smo2 objects. This is because smo3 object uses a different monitor object than
        // smo1 and smo2 objects.
        SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);
        smo3.incCounter();
    }
}
