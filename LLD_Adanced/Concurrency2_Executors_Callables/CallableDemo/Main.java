package LLD_Adanced.Concurrency2_Executors_Callables.CallableDemo;

/**
 * Date: 12/08/2024:09:34
 * User: shyamlal
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> l = List.of(7,3,1,2,4,6,17,12);
        ExecutorService executorService = Executors.newCachedThreadPool();

        Sorter sorter = new Sorter(l,executorService);
        Future<List<Integer>> output = executorService.submit(sorter);

        // List<Integer> output = sorter.call();
        System.out.println("Some unrelated work1 ...");
        System.out.println("Some unrelated work2 ...");
        System.out.println(output.get()); //Blocking Code
        executorService.shutdown();

        ////////////// Factorial Thread ??????>?????
        List<Long> inputNumbers = Arrays.asList(100000000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
        List<FactorialThread> threads = new ArrayList<>();
        for(long number:inputNumbers){
            FactorialThread t = new FactorialThread(number);
            //System.out.println(t.getState());
            threads.add(t);
        }

        for(Thread t:threads){
            t.start();
        }

        for(Thread t:threads){
            t.join(2000);
        }

        //--------------------//
        for(int i=0;i<inputNumbers.size();i++){
            FactorialThread t = threads.get(i); //ith Thread Object
            if(t.isFinished()){
                System.out.println(t.getResult());
            }
            else{
                System.out.println("Couldn't complete calc in 2s");
            }
        }

        //Let's wait for 2 seconds
        // Thread.sleep(10000);

        //wait for thread to complete
        /*factorialThread.join(2000);

        if(factorialThread.isFinished()){
            System.out.println(factorialThread.getResult());
        }
        else{
            System.out.println("Calc took too long to finish");
        }*/

        System.out.println("Main is completed!");

        ////////// Executor Example ???????????
        for(int i=0; i<100;i++){
            Thread t = new Thread(new NumberPrinter(i));
            t.start();
        }

    }
}