package com.ibm.com.ibm.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BuiltInFunctionalInterfaces {
    public static void main(String[] args) {
        //Consumer :returns
        Consumer<String> consumer = null;
        consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("Accept");
        consumer = value -> System.out.println(value);
        consumer.accept("Accept");
        //
        Supplier<String> supplier = null;
        supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };
        System.out.println(supplier.get());
        supplier = () -> "Hai";
        System.out.println(supplier.get());

        //consumer inside java apis : collections : iterators : forEach
        List<String> names = Arrays.asList("Subramanian", "Geetha", "Divya Sree");
        names.forEach(name-> System.out.println(name));
        names.forEach(System.out::println);

        Predicate<Integer> predicate = null;
        predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer.intValue() == 10; // true or false
            }
        };
        String result = "";
        result = predicate.test(10) ? "True" : "False";
        System.out.println(result);

        predicate = value -> value.intValue() == 10;
        result = predicate.test(10) ? "True" : "False";
        System.out.println(result);


    }
}
