package org.mydemo;

import io.vavr.*;
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
        String some = "som";
        if (some.length() < 5) {
            throw new RuntimeException("Invalid length");
        }
        return some;
    }
}

public class FunctionAdvanced {
    public static void composition() {
        Function1<Integer, Integer> plusOne = a -> {
            System.out.println("plusone");
            return a + 1;
        };
        Function1<Integer, Integer> multiplyByTwo = a -> {
            System.out.println("multiplyByTwo");
            return a * 2;
        };
        Function1<Integer, Integer> plusOneAndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
        System.out.println(plusOneAndMultiplyBy2.apply(2).intValue());

        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.compose(multiplyByTwo);
        System.out.println(add1AndMultiplyBy2.apply(2).intValue());


    }

    public static void lift() {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

// = None
        Option<Integer> i1 = safeDivide.apply(1, 0);
        // System.out.println(i1.getOrElse(0));
        System.out.println(i1);
// = Some(2)
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i2);

    }

    public static void cache() {
        //Memoization
        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();

        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        System.out.println(randomValue1);
        System.out.println(randomValue2);
    }

    public static void curry() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum.curried().apply(2);

        System.out.println(add2.apply(4));
    }

    public static void options() {
        //The result would either None or SOME
        // optional *value*, no more nulls
        //Option<T> option = Option.of(...);
        Option<String> maybeFoo = Option.of("foo");
        System.out.println(maybeFoo);
        Option<String> maybeNone = Option.of(null);
        System.out.println(maybeNone);
        System.out.println(maybeNone.getOrNull());
        System.out.println(maybeNone.getOrElse("some value"));
    }

    public static void trys() {
        //FUNCTIONAL error handling
        //which represents a computation that may either result in an exception, or return a successfully computed value
        // no need to handle exceptions
        //Try.of(() -> bunchOfWork()).getOrElse(other);
        //Try (Sucess, Failure)
        Try<String> sometry = Try.of(SomeClass::doSomething);
        System.out.println(sometry);
        //System.out.println(sometry.get());
        System.out.println(sometry.getOrElse("default "));
        //if error
        String recovered = sometry.recover(throwable -> {
            return "From Cache";
        }).get();
        System.out.println("Recovery :" + recovered);

        //fluent pattern
        sometry.onSuccess(s -> {
            System.out.println("On Success :" + s);
        }).onFailure(f -> System.out.println("On Failure : " + f)).andFinally(() -> {
            System.out.println("Finally");
        });


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

    private static Either<String, Integer> computeStuff(Integer myval) {
        if (myval == 2)
            return Either.left("We dont support the number 2");
        return Either.right(myval * myval);
    }

    public static void eithers() {
//Either represents a value of two possible types. An Either is either a Left or a Right
        /**
         * . If the given Either is a Right and projected to a Left, the Left operations have no
         *  effect on the Right value. If the given Either is a Left and projected to a Right,
         *  the Right operations have no effect on the Left value.
         *  If a Left is projected to a Left or a Right is projected to a Right,
         *  the operations have an effect.
         */

        Either<String, Integer> eithervalue = computeStuff(2);
        System.out.println("Test Either - IsLeft " + eithervalue.isLeft());
        System.out.println("Test Either - IsRight " + eithervalue.isRight());
        System.out.println(eithervalue.getOrElse(0));
    }

    public static void futures() throws InterruptedException {
        //A Future is a computation result that becomes available at some point. All operations provided are non-blocking.
        // The underlying ExecutorService is used to execute asynchronous handlers, e.g. via onComplete(…​)
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
            return new Random().nextInt();
        }).onComplete(finalresult -> {
            System.out.println("YES WE ARE DONE WITH TOUGH WORK" + finalresult);
        });

        magicInt.await();
        System.out.println("is Completed: " + magicInt.isCompleted());
        System.out.println("Test Future - END");
    }

    //tuples returns more than one return values
    public static void tuples() {
        Tuple2<String, String> t1 = Tuple.of("Hai", "hello");
        System.out.println(t1);
    }


    private void doStuff(){
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
                Case($(1), "vÃ¦rdien eet"),
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


    public static void main(String[] args) throws InterruptedException {
        composition();
        System.out.println("Lifting");
        lift();
        System.out.println("Curry");
        curry();
        System.out.println("Cache");
        cache();
        System.out.println("Functional Values");
        System.out.println("Options");
        options();
        System.out.println("Try..");
        trys();
        System.out.println("lazy computing..");
        lazyValues();
        System.out.println("Either..");
        eithers();
        System.out.println("Futures..");
        //futures();
        System.out.println("Tupels..");
        tuples();
        System.out.println("Match..");
        matches();
    }
}
