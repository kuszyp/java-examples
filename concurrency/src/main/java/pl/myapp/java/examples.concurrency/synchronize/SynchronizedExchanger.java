package pl.myapp.java.examples.concurrency.synchronize;

public class SynchronizedExchanger {

    protected Object object = null;

    public synchronized Object getObject() {
        return this.object;
    }

    public synchronized void setObject(Object o) {
        this.object = o;
    }

    public Object getObj() {
        synchronized (this) {
            return this.object;
        }
    }

    public void setObj(Object o) {
        synchronized (this) {
            this.object = o;
        }
    }
}
