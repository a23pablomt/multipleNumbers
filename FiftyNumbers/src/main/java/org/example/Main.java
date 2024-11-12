package org.example;


import java.io.FileNotFoundException;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ExecutionException, InterruptedException {

        ExecutorService pool1= Executors.newFixedThreadPool(1);
        ExecutorService pool2= Executors.newFixedThreadPool(12);

        FutureTask<String>[] tasks = new FutureTask[50];

        String[] numbers = new String[50];
        String[] multiplos = new String[50];

        for(int i = 0; i < 50; i++){
            Callable<String> called = new NumberGenerator();
            FutureTask<String> ft = new FutureTask<String>(called);
            Thread th = new Thread(ft);
            pool1.execute(th);
            numbers[i]= ft.get();
        }

        pool1.shutdown();

        for(int i = 0; i < 50; i++){
            Callable<String> calla = new Multiplos(numbers[i]);
            tasks[i] = new FutureTask<String>(calla);
            Thread th = new Thread(tasks[i]);
            pool2.execute(th);
            multiplos[i]= tasks[i].get();
        }

        pool2.shutdown();


        for(int i = 0; i < 50; i++){
            System.out.println(numbers[i]);
            System.out.println(multiplos[i]);
        }
    }
}