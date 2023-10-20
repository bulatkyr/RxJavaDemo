package org.example;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.*;

public class Main {
  public static void main(String[] args) {
    // create an observable that will emit increased long every two seconds
    Observable<Long> obs = Observable.intervalRange(1L, 5L, 0L, 2L, TimeUnit.SECONDS);
    obs.blockingSubscribe(new PrintObserver()); // one way to subscribe
    obs.blockingSubscribe( // another way to subscribe
        item -> System.out.println("Next item in onNext " + item),
        err -> err.printStackTrace(),
        () -> System.out.println("Complete"));
  }
}
