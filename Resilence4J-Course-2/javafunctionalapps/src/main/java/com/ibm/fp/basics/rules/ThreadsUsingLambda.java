package com.ibm.fp.basics.rules;

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadsUsingLambda {
    public static void main(String[] args) {
        Thread thread = null;
        thread = new Thread(new MyThread());
        thread.start();

        Runnable myRunner = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        thread = new Thread(myRunner);
        thread.start();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();
        //Lambda
        Runnable myLambdaRunner = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        thread = new Thread(myLambdaRunner);
        thread.start();
        thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();

        //simple pattern
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();

    }
}
