package Game;

import java.util.function.Supplier;

public class Waiter {
    public void wait(Supplier<Object> supplier) {
        while (supplier.get() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
