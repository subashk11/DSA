package com.multithreading;

//Threads can be implemented in two ways
//1. Extending Thread Class
//2. Implementing Runnable Interface

class Cake extends Thread {
    public void run() {
        try{
            System.out.println("Cake is Preparing : "+ Cake.currentThread().getId());
            System.out.println("Baking Cake  : "+ Cake.currentThread().getId());
            System.out.println("Frosting Cake : "+ Cake.currentThread().getId());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}

//using runnable interface
class CakeInterface implements Runnable {
    public void run() {
        try{
            System.out.println("Cake is Preparing : "+ Thread.currentThread().getId());
            System.out.println("Baking Cake  : "+ Thread.currentThread().getId());
            System.out.println("Frosting Cake : "+ Thread.currentThread().getId());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
public class Basics {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {

            //using Thread class
            Cake cake = new Cake();
            cake.start();
        }


        for (int i = 0; i < 4; i++) {

            //using Thread class
            Thread cake = new Thread(new CakeInterface());
            cake.setName("Thread "+i);
            cake.start();
        }
    }
}
