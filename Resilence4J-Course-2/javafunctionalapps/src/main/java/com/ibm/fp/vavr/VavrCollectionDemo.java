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
