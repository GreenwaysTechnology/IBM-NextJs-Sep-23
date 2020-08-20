package com.ibm.fp.vavr;


import io.vavr.Lazy;
import io.vavr.collection.Stream;
import io.vavr.concurrent.Future;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import static io.vavr.API.*;
import java.util.Random;
import java.util.concurrent.Executors;

class SomeClass {
    public static String doSomething() {
        String some = "somadfafafadfaf";
        if (some.length() < 5) {
            throw new RuntimeException("Invalid length");
        }
        return some;
    }
}

public class VaVrValues {
    public static void options() {
        //The result would either None or SOME
        // optional *value*, no more nulls
        //Option<T> option = Option.of(...);
        Option<String> maybeFoo = Option.of("foo");
        System.out.println(maybeFoo);
        //Get value
        System.out.println(maybeFoo.get());
        Option<String> maybeNone = Option.of(null);
        System.out.println(maybeNone);
        //System.out.println(maybeNone.get());
        //escape from the Runtime Error, handle it safely
        System.out.println(maybeNone.getOrNull());
        System.out.println(maybeNone.getOrElse("some default"));

    }

    public static void trys() {
        /**
         * try{
         *     SomeClass.doSomething()
         * }catch(Exception es){
         *
         * }
         */
        Try<String> sometry = Try.of(SomeClass::doSomething);
        System.out.println(sometry);
        //Get data if no error else
        // System.out.println(sometry.get());
        System.out.println(sometry.getOrElse("I am giving some values"));
        //Recover from Errors : Select alternate plans ,
        // if something goes wrong you may give data caching server
        String recovered = sometry.recover(throwable -> {
            return "From Cache"; // call cachingprovider.cacheapi
        }).get();
        System.out.println("Recovery :" + recovered);

        //fluent pattern
        sometry.onSuccess(s -> {
            System.out.println("On Success :" + s);
        }).onFailure(f -> System.out.println("On Failure : " + f)).andFinally(() -> {
            System.out.println("Finally");
        });


    }

    private static Either<String, Integer> computeStuff(Integer myval) {
        if (myval == 2)
            return Either.left("We dont support the number 2");
        return Either.right(myval * myval);
    }

    //
    public static void eithers() {
//Either represents a value of two possible types. An Either is either a Left or a Right
        Either<String, Integer> eithervalue = computeStuff(2);
        System.out.println("Test Either - IsLeft " + eithervalue.isLeft());
        System.out.println("Test Either - IsRight " + eithervalue.isRight());
        System.out.println(eithervalue.getOrElse(0));
    }

    //Non blocking Code:
    public static void futures() throws InterruptedException {
        //A Future is a computation result that becomes available at some point. All operations provided are non-blocking.
        // The underlying ExecutorService is used to execute asynchronous handlers, e.g. via onComplete(â€¦â€‹)
        /**
         * A Future has two states: pending and completed.
         *
         * Pending: The computation is ongoing. Only a pending future may be completed or cancelled.
         *
         * Completed: The computation finished successfully with a result, failed with an exception or was cancelled.
         */
        Future<Integer> magicInt = Future.of(Executors.newSingleThreadExecutor(), () -> {
            System.out.println("We have begun");
            Stream<Integer> take = Stream.from(1).take(500);
            for (int t : take) {
                if (t % 1000 == 0)
                    System.out.println("t is now: " + t);
            }
            System.out.printf(Thread.currentThread().getName());

            return new Random().nextInt();
        }).onComplete(finalresult -> {
            System.out.println("YES WE ARE DONE WITH TOUGH WORK" + finalresult);
        });

        magicInt.await();
        System.out.println("is Completed: " + magicInt.isCompleted());
        System.out.println("Test Future - END");
    }
    //match --functional switch case
    public static void matches() {
        /**
         *     import static io.vavr.API.*;
         *     Having the static methods Match, Case and the atomic patterns
         *     $() - wildcard pattern
         *
         *     $(value) - equals pattern
         *
         *     $(predicate) - conditional pattern
         */
        Integer i = 10;

        Integer of1 = Match(i).of(
                Case($(1), 10),
                Case($(), 20)
        );
        String matched = Match(i).of(
                Case($(1), "xxx eet"),
                Case($(2), "value two")
                , Case($(), "default value... ?")
        );

        System.out.println("matched: " + matched);

        i=1;
        Option<String> match2 = Match(i).option(
                Case($(1), "Value 1"),
                Case($(2), "value two")
        );
        System.out.println(match2.getOrElse("0"));



    }

    public static void lazyValues() {
        //which represents a lazy evaluated value. Compared to a Supplier,
        // Lazy is memoizing, i.e. it evaluates only once and therefore is referentially transparent.
        Lazy<Double> lazy = Lazy.of(Math::random);
        System.out.println(lazy.isEvaluated()); // = false
        System.out.println(lazy.get());         // = 0.123 (random generated)
        System.out.println(lazy.isEvaluated()); // = true
        System.out.println(lazy.get());         // = 0.123 (memoized)
    }


    public static void main(String[] args) throws InterruptedException {
        System.out.println("Option");
        options();
        System.out.println("Trys....");
        trys();
        System.out.printf("Lazy");
        lazyValues();
        System.out.printf("eithers");
        eithers();
        System.out.printf("Future");
        futures();
        System.out.printf("Matches");
        matches();

    }

}

