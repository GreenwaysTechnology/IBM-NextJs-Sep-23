package com.ibm.fp.lambda.advanced;

//Single
@FunctionalInterface
interface Single {
    void sayHello();
}

//args and parameters
@FunctionalInterface
interface Greeter {
    void setMessage(String message);
}

@FunctionalInterface
interface BiFunction {
    void setMessage(String message, String name);
}

//return values
@FunctionalInterface
interface Adder {
    int add(int a, int b);
}


public class LambdaAdvanced {
    public static void main(String[] args) {
        //Single
        Single single = null;
        //Code refectoring
        single = () -> {
            System.out.println("Helllo");
        };
        single.sayHello();
        // if function has only one line of body, we can remove {}
        single = () -> System.out.println("Helllo");
        single.sayHello();
        //Parameters and args
        Greeter greeter = null;
        //message is args, what you receive
        greeter = (String message) -> {
            System.out.println(message);
        };
        //"Hello" is parameter; what you pass
        greeter.setMessage("Hello");
        //if you write lambda you can remove type
        //Type interfence; type of variable is understood.
        greeter = (message) -> System.out.println(message);
        greeter.setMessage("Hello");
        //if funcition take single parameter, you can remove even bracket
        greeter = message -> System.out.println(message);
        greeter.setMessage("Hello");

        //two parameters
        BiFunction biFunction = null;
        biFunction = (message, name) -> System.out.println(message + name);
        biFunction.setMessage("Hello", "Subramanian");

        //Return values
        Adder adder = null;
        adder = (a, b) -> {
            int result = a + b;
            return result;
        };
        System.out.println(adder.add(10, 10));
        //return value , only return statement : remove return statement as well
        adder = (a, b) -> a + b;
        System.out.println(adder.add(10, 10));

    }
}
