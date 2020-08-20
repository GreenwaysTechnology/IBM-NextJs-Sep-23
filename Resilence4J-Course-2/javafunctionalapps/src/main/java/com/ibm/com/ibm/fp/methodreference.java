package com.ibm.com.ibm.fp;


@FunctionalInterface
interface Printer {
    void print(String value);
}

class MicroTaskRunner {
    public static void startMicroTaskStatic() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }

    public void startMicroTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}

class Loop {

    //thread logic is isloated into a separate method
    private void startMicroTask() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }

    public void start() {
        Thread thread = null;
        //thread logic
        thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();

        Runnable runner=() -> {
            System.out.println(Thread.currentThread().getName());
        };
        thread = new Thread(runner);
        thread.start();
        thread = new Thread(() -> startMicroTask());
        thread.start();
        //method reference : refering method without using lambda syntax this::method-instance methods
        thread = new Thread(this::startMicroTask);
        thread.start();
        //method reference : outside the class  reference::method
        MicroTaskRunner microTaskRunner = new MicroTaskRunner();
        thread = new Thread(() -> microTaskRunner.startMicroTask());
        thread.start();
        thread = new Thread(microTaskRunner::startMicroTask);
        thread.start();
        thread = new Thread(new MicroTaskRunner()::startMicroTask);
        thread.start();
        thread = new Thread(MicroTaskRunner::startMicroTaskStatic);
        thread.start();

    }
}

public class methodreference {
    public static void main(String[] args) {
        Loop loop = new Loop();
        loop.start();
        Printer printer = null;
        printer = value -> System.out.println(value);
        printer.print("Hello");

        printer = System.out::println;
        printer.print("Hello");


    }
}
