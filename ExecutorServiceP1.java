import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Date: 10/02/2024:23:01
 * User: shyamlal
 */

public class ExecutorServiceP1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }

        executorService.shutdown();
    }
}
