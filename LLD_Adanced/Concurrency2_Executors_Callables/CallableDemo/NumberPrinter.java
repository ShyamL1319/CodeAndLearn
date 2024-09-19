package LLD_Adanced.Concurrency2_Executors_Callables.CallableDemo;

/**
 * Date: 12/08/2024:09:44
 * User: shyamlal
 */
public class NumberPrinter implements Runnable {
    int number;
    NumberPrinter(int number){
        this.number = number;
    }
    @Override
    public void run(){
        System.out.println("Printing "+number + " from "+Thread.currentThread().getName());
    }
}
