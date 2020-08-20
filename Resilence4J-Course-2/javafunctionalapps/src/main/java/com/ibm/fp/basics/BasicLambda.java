package com.ibm.fp.basics;


/**
 * interfaces ;
 */
//How to provide implementation for an interface

interface Welcome {
    void sayHello();
}

//way 1:

/**
 * drawback of this model
 * - if i want to implement interface, i need new class again , this will increase no of classes.
 */
class WelcomeImpl implements Welcome {
    @Override
    public void sayHello() {
        //
        System.out.println("Hello");
    }
}

public class BasicLambda {
    public static void main(String[] args) {

        //Declare Welcome type variable
        Welcome welcome = null;
        //
        welcome = new WelcomeImpl();
        welcome.sayHello();

        //way -1anonymous inner class
        /**
         * This apporah is legacy object oriented model
         */
        welcome = new Welcome() {
            @Override
            public void sayHello() {
                System.out.println("Hello");
            }
        };
        welcome.sayHello();
        //we want only logic ,: lambda functions
        welcome = () -> {
            System.out.println("Hello");
        };
        welcome.sayHello();
    }
}

