package Game;

import java.util.function.Supplier;

public class Waiter {
    public void wait(Supplier<Object> supplier) throws InterruptedException {
        synchronized (this) {
            while (supplier.get() == null) {
                wait(100);
            }
        }
    }
}
