package LLD_Adanced;

/**
 * Date: 17/09/2024:05:42
 * User: shyamlal
 */
public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Hellow from " + Thread.currentThread().getName());
    }
}
