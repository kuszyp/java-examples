package pl.myapp.java.examples.concurrency.synchronize;

/*
 This two methods are not synchronized using the same monitor object.
 The setStaticObj method is synchronized using the class object as a monitor, while the setInstanceObj method
 is synchronized using the instance object as a monitor.
 */
public class MixedSynchronization {
    public static Object staticOObj = null;

    public static synchronized void setStaticObj(Object o) {
        staticOObj = o;
    }

    public Object instanceObj = null;

    public synchronized void setInstanceObj(Object o) {
        this. instanceObj = o;
    }
}
