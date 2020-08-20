                      Resilience : fault Management

Any System Subject to failure.

Layers of system and its failures

-Hardware failures
-OS Failures
-Network failures

Software failures:
..................
->JVM failures
  -out of memory
  -heap dump errors
  -process related errors
  -thread related errors
-How to fix failures
  -there tools available to detect memories,threads,heap dump 
   -jmeter,heapdump errors, apache benchmark....

->Exception handling
 file handling,database handling, call third party apis,networking, biz use case failures.
-How to fix application errors
  -Exception handlers--- give report , we can decide what do.

try{
 //what type of code i can write
 //The code subject to fail, risky code. : The code may cause error any time.

}
catch(Exception e){
  //for recovery code.
  //you report to other code or ui
  //you can log those errors, you can audit latter.
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Application types and its architectures:

1.Back end application
 -web
 -distributed application
2.User interface application
  -web
  -mobile
  -iot

Distributed Application:

Application is built based various components.

components
 -Data-Models-Entities
 -Repository-DAO---talks to DataSources
 -Integration Component - talks to External systems like - Mainframe,SAP,e-commerce platforms,Third party web services(SOAP,REST),SOA,NO SQL...
 -Biz layer/ Service layer
 -Web Layer

How to build distributed application ?

Distributed application built on various patterns and principles.

Types of Distributed application:
.................................

- Monolithic 
- MicroServices

Monolithic :
 It is distributed application.
 -Built,compile,pack,test,deploy as a single unit.
 -Technology driven model : focus given on tech stack eg if u select java, the whole is built mostly using java 
 -In case any failures in the  part of the system, the whole system may go down.
 .....

 Micro services :
  It is also one the distributed architecture /application

- Domain Driven Model 
    - built application based on biz domains.
    - Whole application is broken into biz modules ; In Reservation System
       - Customer is a separate application
          which has its own layers ,database,tech stack : polytech
       - Accounts is a separate application
          which has its own layers ,database,tech stack : polytech

-Built , compile ,test , deploy individually : 
          Continuous Req
          Continuous Dev
          Continuous Test
          Continuous deployment
          Continuous Release 
               -CI and CD : Dev ops

 Many Software communicates others under one roof : Micro services
   Where failures are highly expected.

How to handle Failures,Recover failures, How to respond to applications and users with respect to failures.

                                 Micro Services
                                      |
                        ------------------------------------
                        |                                  |
                    Application                        Infrastructure
                       |                                    |
                     Spring                           (CI/CD,Cloud......)
                 (Spring Cloud)

                    Micro Service Fault Management Technologies
                    ............................................
                     Application                        Infrastructure
                       |                                    |
                     Spring                           (CI/CD,Cloud......)
                   (Spring Cloud)                              
                        |             
       How to handle Application failures?
                       |
                    Spring 
                      |
                      |
       Latency and Fault Tolerance for Distributed Systems 
                      |
       -------------------------------                 
       |                             |          
    Hystrix                      Resilience4J
                                        |
                                We will learn about this

Getting started with Resilience4J:
................................
Resilience 4j has built on various programming models

->Traditional annotation driven model like Hystrix.
->Functional style programming
->Reactive and Functional Style Programming.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Functional Programming

Reactive Programming

Resilence4J

Software Setup:
- JDK 8
- Intellij idea - Community edition /any editor
- maven
- docker and docker compose
- apache bench mark
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Functional Programming and implementations:
..........................................

What is fp?
-Functional programming is one the programming paradigm.

Programming paradigm: Way to build
->Object oriented
->Procedural oriented
->Functional Programming
->Event Driven Programming
->Reactive Programming

Object Oriented Principles:
...........................
1.Abstraction
2.Encapsulation
3.Hierarchy
4.Typing
5.Modularity
----------------------
6.Concurrency
7.Persistency 

if any pl implements the first 5 principles are object oriented programming language. - C++,java,C#

"Object Based" Programming language

if any pl does not implement any of one of the  5 principles or partially implement are object based programming language.
 - javascript 

 Functional Programming:
   Functional programming is one the oldest programming model.
   It was created in 1935.

History of functional Programming
.................................
    In 1930,The scientist called "Alan Turing" : Turing Machine ->State Machine
    -Abstract computing machine : it is mathematical abstraction for storing ,processing data,read (state).

State Machine: 
  It is mathematical abstraction of "How to store state in memory and manipulate that memory".

 eg 
  int a =10; ----> a's memory address--->1024 and 10 

 State mutations:
   a++ -> 11-------What is memory address of 11? 1024.

After, 1970 - Concurrency--multi process -- multi threading

multi state mutation will lead
1.data corruption.
   ->Mutx - Lock
  
Lock will lead another problems
  -Blocking
  -what if thread takes more time--->waiting--performance
  -Thread dead locking

Solution to Turning Machine:
.............................

Lambda Calculus:
  It is another mathematical approach like state machine to represent state in memory and mutate it.

Lambda Calculus invented by The "Alonzo Church" , Who is PHD student of "Alan Turning"..

The Programming languages which implements "lambda Calculus theory" called "Functional programming".

Lambda expressions the programs construction through "functions" -->f()

The languages which implements lambda Calculus
 ->Scheme
 ->haskell

Java is object oriented only?
No , After Java 8.

Java 8 implements Lambda Calculus(Functional Programming)

  "Java is Object oriented, functional Style" Programming language.
      -Hybrid language.

Today most of the pl , are hybrid.
  javascript : object based,functional style,event driven.......
  

With Respect hybrid languages
 java- Object oriented, functional style.

style vs pure:
..............
  if a pl implements 100% principles of an paradigm, those languages called "Pure"

  if a pl implements not all principles or partially, those languages called "style".
  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxx

Functional Programming  Principles:
...................................
 
  Function is abstraction to encapsulate application state and its logic

1.Side Effects:
  The application mutate some sort of state, may be outer world(out side to application boundary) - database calls,files.

2.Referential Transparency:
  Variables are once defined dnt change their value throughout the program
  In fp, programs dont have assignment statements.
  what if i want to change the variable, we should not mutate old memory address,
     rather assign computed result into new memory address.
  This eleminates any changes of side effects because any variable can be replaced with
  its actual value at any point of execution.

"Pure" function :

Pure should be

 1. function takes arg, return the same , which never modifes the state.
  
      function  update(value){
           return value;
      }
  
 2.  What if i want to change state

   Thinking in values:
             The value changes should not be in same place, rather than it should be in different memory address--->Immutablity -- Immutable values

      function  update(value){
           return value; //state changes
      }


 100               104          240
 |                  |           |
 Value1---update-->Value2 ---->update



3.Recursion:
   no loops in fp- only fp

4.Function is first class citizen : every thing is function, function itself a value.

  ->function as parameter---->Callback ---Async 
  ->Function is returned --->closure
  ->function composition --> f()-->f()--f()=>result
     ->curry
     ->memoization
     -Partial applications
     -Lifting

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Java Functional Programming implementation:

1.Function declarations,invocation using free variable patterns
  => Lambda expression
2.Pure function 
3.Function Composition

Functional programming is simulated in source code only via interfaces, but once code is compiled , it becomes object models.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Lambda calcus implemenation:
...........................

inner classes:
 1.anonymous inner class --- functional implements.

interfaces : functional interface

functional interfaces: To enable functional programming in java

1.To implement lambda , java provides interface having single abstract method "SAM".

Functional interfaces must have only one abstract method  : SRP principle.

2.interface can have other methods
   -default methods
   -static methods


Basic:
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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Can we use any interface in jdk as lambda?
Yes!, any interface is having single abstract method. we can use

eg:
Thread creation using Runnable  interface?


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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Use case;

What if somebody has provided interface, now you have to use lambda based on that interface.

java provides an annotation, maker annotation,used by compiler during compile time.

@Functional

package com.ibm.fp.basics.rules;

@FunctionalInterface
interface Hello {
    void sayHello();
}

public class FunctionalAnnotation {
    public static void main(String[] args) {
        Hello hello = null;
        hello = () -> {
            System.out.println("Hello");
        };
        hello.sayHello();

    }
}

How to refactor lambda code ;  various code simplification
..........................................................
->Simple Code Refactoring
->Parameters and Args
->return values
->Type Inference


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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

What you can pass as parameter and Return from lambda?

You can pass primitives and objects

  int,string,double,boolean,Employee,Order......

Can you can Pass function as parameter to another function or constructors?

 Yes!


package com.ibm.fp.lambda.advanced;

/**
 * Function as parameter to another function.
 */

@FunctionalInterface
interface Handler {
    void connect();
}

//parameters and args with respect to function as parameters:  simulate non blocking data return

@FunctionalInterface
interface HttpHandler {
    boolean write(Object data);
}


class NetServer {
    //Take Handler as Arg
    public void start(Handler handler) {
        handler.connect();
    }
}

class HttpServer {
    public void handleRequest(HttpHandler httpHandler) {
        try {
            //fake Response
            String fakeResponse = "Hello! HttpServer";
            Thread.sleep(1000);
            boolean status = httpHandler.write(fakeResponse);
            if (status) {
                System.out.println("Response committed");
            } else {
                System.out.println("something went wrong");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}

class HandlerImpl implements Handler {
    @Override
    public void connect() {
        System.out.println("Start Net Server");
    }
}

public class FunctionAsParam {
    public static void main(String[] args) {
        NetServer netServer = null;
        netServer = new NetServer();

        netServer.start(new HandlerImpl());

        //anonous
        Handler handler = null;

        handler = new Handler() {
            @Override
            public void connect() {
                System.out.println("Start Net Server");
            }
        };
        netServer.start(handler);

        netServer.start(new Handler() {
            @Override
            public void connect() {
                System.out.println("Start Net Server");
            }
        });
        //lambda methods
        handler = () -> System.out.println("Start Net Server via Lambda");
        netServer.start(handler);
        //inline
        netServer.start(() -> System.out.println("Start Net Server via inline Lambda"));

        ///////////////////////////////////////////////////////////////////////////////////
        HttpServer httpServer = new HttpServer();

        //call
        httpServer.handleRequest(new HttpHandler() {
            @Override
            public boolean write(Object data) {
                System.out.println(data);
                return true;
            }
        });
        //lambda way of gettting data
        System.out.println("Waiting");
        httpServer.handleRequest(response -> {
            System.out.println(response);
            return true;
        });
        System.out.println("end");


    }
}
//////////////////////////////////////////////////////////////////////////////////

Lab 1:
Objective : Lambda as parameter.

Create Login Validation Api.
Login api should pass data to handler based on biz logic
 -userName = admin and password =admin
 if user and password is admin and admin, send "Login Success" Message else "Login failed Message".
login method should accept two functions
   -Resolve - handling success result
   _Reject - handling failure result.

Clue : Pass two function as parameter , one is SUccess handler and another one is failure handler.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Method References:

->It is technique to reduce lot of lambda code itself.


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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Advanced Uses:

if you want to implement lambda, you need functional interface.

Lets i want to design common interfaces which accepts and returns

-single input, no output
-two input , single output
-only integer input,return the same
-two any type of input,return boolean ; predicate
etc...
do you think that it is good idea to have your own functional interfaces for common uses cases

No!

Then what i should do? 

Java 8 provides java.util.function package which has lot of built in common use interfaces.

Important functional interfaces:
...............................
1.Consumer
2.Predicate
3.Supplier
4.UnaryOperator
5.BinaryOperator
6.Function

 		 T - any Type  <T>  - Generic type

 		nothing->T            Supplier
		T->nothing            Consumer
		T->T                  UnaryOperator
		T,T->T                BinaryOperator
		S->T                  Function
		T->boolean            Predicate


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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&


                                  Resilience4J
                                ................

Life Before Resilience4J:
..........................

Hystrix is a latency and fault tolerance library designed to isolate points of access to remote systems, services and 3rd party libraries, stop cascading failure and enable resilience in complex distributed systems where failure is inevitable.


latency and fault :

 latency   -slow
 fault     -Error /something went wrong.

Why netflx stop?

 They dont want to measure app performance,fault management using "Preconfigured" through
settings
  program settings -
    source code
    app config files -properties or yaml files
who recommends Resilience4 4J.
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Resilience4j is a lightweight fault tolerance library inspired by Netflix Hystrix, but designed for functional programming.


Features of  Resilience4 4J

1.Provides two model of programming
  1.legacy style - Annotation style - OO
  2.higher-order functions(decorators) to enhance any functional interface, lambda expression or method reference with fault management apis.

2.It is very light weight when compare to hystrix
    RE4J has only one direct dependency  - Vavr,
     Vavr has no any external dependency
 hystrix has dependency archaius 
     - appche common, guava.

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

                                Vavr
                            -------------
Vavr is an object-functional language extension to Java 8, which aims to reduce the lines of code and increase code quality. It provides persistent collections, functional abstractions for error handling, concurrent programming, pattern matching and much more.

Vavr fuses the power of object-oriented programming with the elegance and robustness of functional programming. The most interesting part is a feature-rich, persistent collection library that smoothly integrates with Java's standard collections.

Vavr inspired from Java 8 functional programming implementations
 -lambdas
 -streams

 Missing Main java 8 feature 
  - Immutablity

Immutable Collection: according to java 8 , not modifiable
   List<T> list = Collection.unmodifiableList(list)

   ///add
   list.add() //throw error.

Features:
.........
->Vavr Will give real immutable Collection , You can modify, but modification wont
happen on Original List instance rather it will create  new Instance.

According to Vavr, Collections are pure, immutable, functional style.

->Functional Implementation
  -Function Composition
  -Curry function
  -Higher Order Function
  -Lifting
  -Partial function
  -Switch..Case

-Vavr Values
  -Option
  -Try
  -Lazy
  -Either
  -Future
  
  Getting Started:

   <dependencies>
        <dependency>
            <groupId>io.vavr</groupId>
            <artifactId>vavr</artifactId>
            <version>0.10.2</version>
        </dependency>
    </dependencies>

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Collections:
............

->How to create immutable Collection.

Note:
Object creation:
 - Via constructor patterns
    SomeClass someRef=new SomeClass()
 -Via Factory
    SomeClass SomeRef = SomeClassFactory.factoryMethod()

    someClass().someapi().build() - Every api returns the same type of someClass

 If you want to create Object in Vavr we use factory method named "of"
   -> SOmeClass.of()=>Returns Object Reference
  
package com.ibm.fp.vavr;

import io.vavr.collection.List;
import io.vavr.collection.Queue;
import io.vavr.collection.SortedSet;
import io.vavr.collection.TreeSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class VavrCollectionDemo {
    public static void main(String[] args) {
        //List Cration

        List<String> names = List.of("Subramanian", "Raj", "Ram");
        names.forEach(name -> System.out.println(name));
        System.out.println(names.hashCode());
        List<String> newList = names.tail().prepend("Srisha");
        System.out.println(newList.hashCode());

        Queue<Integer> queue = Queue.of(1, 2, 5);
        System.out.println(queue);

        //Set
        SortedSet<Integer> set = TreeSet.of(6, 12, 78, 89);
        System.out.println(set);
        //Comparator
        Comparator<Integer> c = (a, b) -> b - a;
        SortedSet<Integer> reversed = TreeSet.of(c, 2, 3, 1, 2);
        System.out.println(reversed);

        //Stream api from java 8 and vavr also supports streams
        //Fluent Pattern , Pure functions,Immutablity
        System.out.println(Arrays.asList(30, 89, 67).stream().map(Integer::intValue).collect(Collectors.toList()));


    }
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Function Abstraction:

Java 8 Provides java.util.Function as generic functional interface.
-Drawbacks
   -It takes only one parameter
   -BiFunction which accepts two parameters

Vavr provides functions up to a limit of 8 parameters.
The interfaces are named as Function0,Function1,Function2.....8

How to declare functions?
package com.ibm.fp.vavr;


import io.vavr.Function2;
import io.vavr.Function1;

public class VaVrFunctionAbstraction {
    public static void main(String[] args) {
        Function2<Integer, Integer,Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(10, 10));
        Function1<Integer, Integer> doubleMe = a1 -> a1 *2;
        System.out.println(doubleMe.apply(10));


    }
}

Advanced Functional Programming Concepts:
.........................................

1.Composition:
Functions can be chained together
Applying a function to the result of another function creates a new function.
The functions f: X → Y and g: Y → Z can be concatenated to form a function h: g (f (x)) with h: X → Z. 


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

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Partial Functions: Partial Application:
.......................................

It allows you to derive a function from existing one by fixing some values.
You can fix one or more parameters, and the number of fixed parameters defines
the boundary of the new function.


    public static void partials() {
        //One parameter is fixed , the remaining parameters are dynamic
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //create new function
        Function1<Integer, Integer> adder = sum.apply(2);
        System.out.println(adder.apply(100));

    }

Curry Function:
 Curry is a concept to partially apply a function by fixing a value for one of the parameters.
    public static void curry() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> adder = sum.curried().apply(12);
        System.out.println(adder.apply(100));
    }
Caching : Memoization:
.......................
Memoization is a form of caching.A memoized function executes only once and then
returns the result from the a cache.
   public static void cache() {
        //Memoization
        Function0<Double> hashCache = Function0.of(Math::random).memoized();
        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        System.out.println(randomValue1);
        System.out.println(randomValue2);
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
-Vavr Values
  -Option
  -Try
  -Lazy
  -Either
  -Future

Option:
.......
Option is used to invert NullPointerException. You can Treat null Pointer Exception in good way using functional style.

The result would either None or SOME
 optional *value*, no more nulls
Option<T> option = Option.of(...);



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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Try : Functional Error Handling:
...............................

A value can be wrapped in a context
If one applies a function to the packed value, it can depending on the context have a different result.
Which represents a computation that may either result in an exception, or return a successfully computed value

Try(SUCCESS,FAILURE) =>ANY ONE

try{
 api call --->
}catch(){
 
}

class SomeClass {
    public static String doSomething() {
        String some = "somadfafafadfaf";
        if (some.length() < 5) {
            throw new RuntimeException("Invalid length");
        }
        return some;
    }
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
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Lazy:
Which represents lazy evaulated value, Compared to Supplier,Lazy is memoizing.

    //which represents a lazy evaluated value. Compared to a Supplier,
        // Lazy is memoizing, i.e. it evaluates only once and therefore is referentially transparent.
        Lazy<Double> lazy = Lazy.of(Math::random);
        System.out.println(lazy.isEvaluated()); // = false
        System.out.println(lazy.get());         // = 0.123 (random generated)
        System.out.println(lazy.isEvaluated()); // = true
        System.out.println(lazy.get());         // = 0.123 (memoized)
Either:
  Either represents a value of two possible types.
    -Left and Right

 public static void eithers() {
//Either represents a value of two possible types. An Either is either a Left or a Right
        Either<String, Integer> eithervalue = computeStuff(2);
        System.out.println("Test Either - IsLeft " + eithervalue.isLeft());
        System.out.println("Test Either - IsRight " + eithervalue.isRight());
        System.out.println(eithervalue.getOrElse(0));
    }

Future:
  A future is a computation result that becomes available at some point.
   -deferred execution.
 All operations are provided are non blocking.
 The underlying "Executor Service" is used to execute async handlers.

 Future handle async result - either success / failure.

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


Functional Switch Case:

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

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Resillence4J-Fault tolerance Patterns:
.....................................

Patterns:
1.Bulk head
2.CircuitBreaker
3.RateLimiter
4.TimeLimiter(Timeout)
5.Retry

Coding:
Modularization :
 With Resilience4j you dont need to go all in one, you can pick up what you need.
Resilience4j provides several core modules and add-on modules:

core libs
resilience4j-circuitbreaker: Circuit breaking
resilience4j-ratelimiter: Rate limiting
resilience4j-bulkhead: Bulkheading
resilience4j-retry: Automatic retrying (sync and async)
resilience4j-cache: Result caching
resilience4j-timelimiter: Timeout handling

framework abstractions

resilience4j-spring-boot: Spring Boot Starter
resilience4j-spring-boot2: Spring Boot 2 Starter
resilience4j-ratpack: Ratpack Starter
resilience4j-Vertx: Vertx Future decorator

Mertics or Fault Management modules

Metrics modules
resilience4j-micrometer: Micrometer Metrics exporter
resilience4j-metrics: Dropwizard Metrics exporter
resilience4j-prometheus: Prometheus Metrics exporter

&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Coding :

Two Spring Boot Project

-BackEnd
-FrontEnd

Front End
 -has list of Rest End point
Back End
 -has list of Rest End Point

 FrontEnd----SpringRestTemplate----------------------BackEnd

Project Creation:

1.Spring Project:
  https://start.spring.io/

BackEnd Application: Provider
.............................
application.properties
 server.port=8081

Controller: Which to be called by Other Application.

package com.example.resilence4jprovider;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


@RestController
@Log
public class MessageController {

    private static final int WAIT_TIME_MS = 1000;
    private int counter = 0;

    @GetMapping("/")
    public String okay() {
        return "I'm okay.";
    }

    @GetMapping("/slow")
    public String slow() throws InterruptedException {
        Thread.sleep(WAIT_TIME_MS);
        return "I'm okay, just slow";
    }

    @GetMapping("/error")
    public String error() {
        throw new InternalServerErrorException("I'm definitely not okay!");
    }

    @GetMapping("/erratic")
    public String erratic() throws InterruptedException {
        log.info(Integer.toString(counter++));
        if (ThreadLocalRandom.current().nextInt(0, 5) != 0) {
            log.info("erratic");
            throw new InternalServerErrorException("I am erratic");
        }
        log.info("ok");
        return "For I am ok!";
    }

}

Exception:
package com.example.resilence4jprovider;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * InternalServerErrorException
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String msg) {
        super(msg);
    }
    
}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Consumer Application: Front End Application

application.properties
provider.uri=http://localhost:8081
maxConcurrent=1


main :

ResilienceConsumerApplication.java

package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ResilienceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResilienceConsumerApplication.class, args);
	}

}
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
Communication:
  Consumer Application will call rest end point of Provider Application.
For Communicaiton we need Object-RestTemplate

Create RestTemplateBean: Inside Configuration.

package com.example.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ConsumerConfiguration
 */
@Configuration
public class ConsumerConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
}

Resilence4J Depedency in pom.xml:
.................................

<dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-circuitbreaker</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-bulkhead</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-ratelimiter</artifactId>
            <version>1.0.0</version>
        </dependency>

        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-timelimiter</artifactId>
            <version>1.5.0</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-retry</artifactId>
            <version>1.0.0</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

Implementation of Resilence4J: only for Functional Style;
.........................................................

Steps:

Creation:
    1.Configuration Object
    2.Create Registry Object
    3.Create BulkHead Object
...................................................
Decoration: Wrapping ; just like wrapping code inside try block in exeception block
  4.Decorate your call ---->Wrap the call 
...................................................
Execute a functional Interface
  5.TRY it - once execution done, handle it, watch it.


BulkHead:
.........

Step-1 : Create Configuration Object.

BulkHeadConfig config=BulkHeadConfig
                        .custom()
                        .maxConcurrentCalls(10)
                        .maxWaitDuration(Duration.ofMillis(100))
                        .build();

Step-2 : Create Registry with Global Configuration.


BulkHeadRegistry  registry=BuildHeadRegistry.of(config);

Step 3 : Create BulkHead Object from the Registry.

BulkHead bulkHead=registry.bulkhead("mybulkhead");

*******************************************************************************
Execution: Where , where you want to call third party Service.

Step 4.1: Decorator : Decorator may vary implementation to implementation
BulkHeadDecorators:
 -Callable
 -Supplier
 -Runnable
 -Consumer
 -CheckedRunnable
 -CheckedSupplier
 -CheckedConsumer
 -CompletionStage

CheckedFunction0<String> decoratedSupplier=BulkHead.decorateCheckedSupplier(bulkhead,()->{
     //call external api
     return restTemplate.forObject(url);
 });

Step 4.2 : Execution : Handle Response: It could either SUCCESS /FAILURE
Try<String> result=Try.Of(decoratedSupplier)
result
  .Onsuccess()
  .onFailure()
  .recover()
..............................................................................


























































































































