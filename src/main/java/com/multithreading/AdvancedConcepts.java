package com.multithreading;

class Counter{
    int count;
    public synchronized void increment(){
        count++;
    }
}

class CounterThread extends Thread{
    Counter counter;
    public CounterThread(Counter counter){
        this.counter = counter;
    }
    public void run(){
        for(int i=0;i<1000;i++){
            counter.increment();
        }
    }
}
public class AdvancedConcepts {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        CounterThread t1 = new CounterThread(counter);
        CounterThread t2 = new CounterThread(counter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.count);
    }
}
