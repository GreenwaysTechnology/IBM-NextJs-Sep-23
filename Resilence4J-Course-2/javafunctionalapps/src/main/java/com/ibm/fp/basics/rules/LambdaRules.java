package com.ibm.fp.basics.rules;

/**
 * Lambda Rules
 * 1.interface must have only one abstract method.
 * -SAM - Single Abstract method ; SRP - SOILD RULES
 * 2.you can have default and static methods
 */
interface Greeter {
    //static methods
    static String doSomething() {
        return "doSomething";
    }

    //abstract method
    void sayHello();

    //default
    default public String saySomething() {
        return "I am telling something";
    }
}

public class LambdaRules {
    public static void main(String[] args) {
        Greeter greeter = null;
        greeter = () -> {
            System.out.println("Hello");
        };
        greeter.sayHello();
        System.out.println(greeter.saySomething());
        System.out.println(Greeter.doSomething());
    }
}
