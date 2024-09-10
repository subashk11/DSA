package com.functionalprogramming;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Arrays;

public class ReactiveProgramming {

    // These are used to implement asynchronous executions in java

    // Streams, Observable and observer is used to implement asynchronous functionalities in java

    public static void main(String[] args) {

        // Flux is a part of reactive programming from Project Reactive

        // Other libraries are RxJava, Reactive Steams, Project Reactor

        Flux<Integer> flux = Flux.range(1,10);

//        flux.toStream().forEach( (num) -> { System.out.println( " Items present in the flux" + num);});

        // stream and print using observer
        flux.filter(e -> e%2 == 0).map( e-> e*2).publishOn(Schedulers.parallel()).subscribe(System.out::println);

        // Wait for a moment to allow the
        // async processing to complete

        // If removed main funtion will be completed before the async function call
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Error while running");
        }
    }
}
