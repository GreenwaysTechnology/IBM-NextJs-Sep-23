package com.ibm.fp.vavr;


import io.vavr.Function0;
import io.vavr.Function1;
import io.vavr.Function2;

public class VaVrFunctionAbstraction {
    public static void composition() {
        //How to coimbine many functions togehter , forms new Function
        Function1<Integer, Integer> plusOne = a -> {
            System.out.println("PlusOne a's Value : " + a);
            return a + 1; // 2 +1 => 3
        };
        Function1<Integer, Integer> multiplyByTwo = a -> {
            System.out.println("multiplyByTwo  a's Value: " + a);
            return a * 2; //  3 * 2
        };

        //andThen Compose functions from left to right side
        Function1<Integer, Integer> plusOneAndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(plusOneAndMultiplyBy2.apply(3).intValue());

        System.out.println("...................");

        //andThen Compose functions from right to left side
        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.compose(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());


    }

    public static void partials() {
        //One parameter is fixed , the remaining parameters are dynamic
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //create new function
        Function1<Integer, Integer> adder = sum.apply(2);
        System.out.println(adder.apply(100));
        //Partaial other wise called curry

    }

    public static void curry() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> adder = sum.curried().apply(12);
        System.out.println(adder.apply(100));
    }

    public static void cache() {
        //Memoization
        //Function0<Double> hashCache = Function0.of(Math::random).memoized();
        Function0<Double> hashCache = Function0.of(() -> Math.random()).memoized();
        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        System.out.println(randomValue1);
        System.out.println(randomValue2);


    }

    static void memoization() {
        Function2<Integer, Integer,Integer> calculate =  Function2.of(VaVrFunctionAbstraction::aVeryExpensiveMethod).memoized();
        calculate.apply(40,10);
        calculate.apply(40,10);
        calculate.apply(50,50);
        calculate.apply(50,80);
        calculate.apply(10,40);
    }

    private static Integer aVeryExpensiveMethod(Integer number1,Integer number2) {
        try {
            System.out.println("method is called : " + number1 + " " + number2);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number1 * number2;
    }

    public static void main(String[] args) {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 10));
        Function1<Integer, Integer> doubleMe = a1 -> a1 * 2;
        System.out.println(doubleMe.apply(10));
        //Function Composition:
        System.out.println("Function Composition");
        composition();
        System.out.println("Partial Application");
        partials();

        System.out.println("Curry Function");
        curry();
        System.out.println("Cache");
        cache();
        memoization();
    }

    private static int add(int a, int b) {
        return a + b;
    }


}
