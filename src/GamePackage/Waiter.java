package GamePackage;

import java.util.function.Supplier;

/**
 * This class implements a method to wait for a variable to become non-null.
 */
public class Waiter {
    /**
     * This is the only method in this class, it uses supplier to wait for a variable to become non-null.
     * A synchronized block is used to ensure that only one thread can access the critical section at a time.
     * @param supplier is the supplier
     * @throws InterruptedException is thrown if the thread is interrupted
     */
    public void wait(Supplier<Object> supplier) throws InterruptedException {
        synchronized (this) {
            while (supplier.get() == null) {
                wait(100);
            }
        }
    }
}
