package com.functionalprogramming;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ReactiveProgramming {

    // These are used to implement asynchronous executions in java

    // Streams, Observable and observer is used to implement asynchronous functionalities in java

    // Flux is a part of reactive programming from Project Reactive

    // Other libraries are RxJava, Reactive Steams, Project Reactor

    // Flux and Mono are part of reactive programming.
    // They are of publisher type

    // 1. Mono are used to send only one item through it.
    private static Mono<String> getString() {
        Mono<String> mono = Mono.just("Hello World");
        return mono;
    }

    // 2. Flux are used to send a stream or list of items/objects
    private static Flux<String> getFluxString1() {
        Flux<String> flux = Flux.just("Java", "CPP", "Python", "Rust");
        return flux;
    }

    // Map to manipulate items
    private static Flux<String> manipulateFluxItems(){
        Flux<String> flux = Flux.just("Java", "CPP", "Python", "Rust");
        return flux.map(item -> item.toUpperCase());
    }

    // Flat map -> Used to return observable like mono or flux
    private static Flux<String> fluxFlatMap() {
        // 1. starting number and 2. input is count needs to be incremented from starting index
        Flux<String> flux = Flux.just("Java", "CPP", "Python", "Rust");

        return flux.flatMap(item -> Mono.just(item.toUpperCase()));
    }

    // Convert Iterable list to flux
    private static Flux<Integer> getFluxFromIterable() {
        List<Integer> list = List.of(10, 11, 12, 13, 14, 15);
        return Flux.fromIterable(list);
    }

    // Set timeout
    // Log to log actions performed
    private static Flux<Integer> delayFluxItems(){
        Flux<Integer> flux = Flux.range(100, 10).log().delayElements(Duration.ofSeconds(1));
        return flux;
    }

    private static Flux<Integer> skipItems() {
        Flux<Integer> flux = Flux.range(20, 10);
        return flux.skipUntil(n -> n>24);
    }

    // Concat -> will wait to complete of first item and start processing secod item in the list
    private static Flux<Integer> concatItems(){
        Flux<Integer> flux1 = Flux.range(10, 5).delayElements(Duration.ofMillis(300));
        Flux<Integer> flux2 = Flux.range(20, 5);

        return Flux.concat(flux1, flux2);
    }

    // merge wont wait for completion of first items it will pass item to the subscribers from any of the list
    private static Flux<Integer> mergeItems(){
        Flux<Integer> flux1 = Flux.range(10, 5).delayElements(Duration.ofMillis(300));
        Flux<Integer> flux2 = Flux.range(20, 5);

        return Flux.merge(flux1, flux2);
    }
    public static void main(String[] args) throws InterruptedException {

        getString().subscribe(System.out::println);

        System.out.println();

        // Flux
        getFluxString1().subscribe((data) -> {
            System.out.println("items : "+ data);
        });

        System.out.println();

        // 2. Map
        manipulateFluxItems().subscribe((data) -> {
            System.out.println(" Using map items : " + data);
        });

        System.out.println();

        // 3. Flat Map
        fluxFlatMap().subscribe((data) -> {
            System.out.println("using flat map : "+ data);
        });

        // 4. Convert from list interface
        getFluxFromIterable().subscribe(data -> {
            System.out.println("items from iterable : "+ data);
        });

        System.out.println();

        // 5. Delay Items
        delayFluxItems().subscribe(data -> {
            System.out.println("items delayed : "+ data);
        });

        Thread.sleep(5000); // to wait for all async operations to complete.

        System.out.println();

        // skip items
        skipItems().subscribe(data -> {
            System.out.println("items skipped : "+ data);
        });

        Thread.sleep(5000); // to wait for all async operations to complete.
        System.out.println("All operations completed.");

        System.out.println();

        // Concat
        concatItems().subscribe(data -> {
            System.out.println("items concat : "+ data);
        });

        Thread.sleep(5000); // to wait for all async operations to complete.

        System.out.println();

        // Merge
        mergeItems().subscribe(data -> {
            System.out.println("items merged : "+ data);
        });

        Thread.sleep(5000); // to wait for all async operations to complete.

        System.out.println("All operations completed.");

        // If removed main function will be completed before the async function call.
    }
}
