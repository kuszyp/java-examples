package pl.myapp.java.examples.concurrency.synchronize;

import java.util.function.Consumer;

public class SynchronizedLambda {
    private static Object object = null;

    public static synchronized void setObject(Object o) {
        object = o;
    }

    public static void consumeObject(Consumer consumer) {
        consumer.accept(object);
    }

    public static void main(String[] args) {
        consumeObject(
                (obj) -> {
                    synchronized (SynchronizedLambda.class) {
                        System.out.println("Object: " + obj);
                    }
                });

        // This consumeObject method does not make sense. Use monitor objects that makes sense.
        //    consumeObject(
        //        (obj) -> {
        //          synchronized (String.class) {
        //            System.out.println("Object: " + obj);
        //          }
        //        });
    }
}
