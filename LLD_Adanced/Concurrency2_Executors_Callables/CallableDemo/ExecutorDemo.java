package LLD_Adanced.Concurrency2_Executors_Callables.CallableDemo;

/**
 * Date: 12/08/2024:09:45
 * User: shyamlal
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0; i<100;i++){
            if(i==80){
                System.out.println("DEBUG-----");
            }
            executor.execute(new NumberPrinter(i));
        }
        executor.shutdown();
    }
}
