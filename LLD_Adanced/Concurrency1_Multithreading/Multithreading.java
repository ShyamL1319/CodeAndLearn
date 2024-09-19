package LLD_Adanced.Concurrency1_Multithreading;

/**
 * Date: 10/02/2024:21:52
 * User: shyamlal
 */
public class Multithreading {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello from " + Thread.currentThread().getName());

        Thread t1 = new Thread(new Task());
        Thread t2 = new Thread(new Task());
        t2.setName("FirstThread");
        t1.setName("SecondThread");

        t1.start();
        t2.start();
        try {
            t2.join();
        } catch (Exception e) {
            throw new Exception(e);
        }
        System.out.println("We are done");
    }
}

class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Hellow from " + Thread.currentThread().getName());
    }
}
