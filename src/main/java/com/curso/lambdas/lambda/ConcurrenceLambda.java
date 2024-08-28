package com.curso.lambdas.lambda;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConcurrenceLambda {
    static Runnable printerSum = ()->{
        long numero1 = 0;
        System.out.println(Thread.currentThread().getName());
        for(int i = 0;  i<10000; i++){
            numero1+=i;
        }
        System.out.println("total "+numero1);
    };

    static Callable<Long> getSum = () -> {
        long numero1 = 0;
        System.out.println(Thread.currentThread().getName());
        for(int i = 0;  i<10; i++){
            numero1+=i;
        }
        return  numero1;
    };

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       var exec = Executors.newSingleThreadExecutor();
      //  exec.submit(printerSum);
        var result = exec.submit(getSum);
        System.out.println(result.get());
        exec.shutdown();
    }
}
