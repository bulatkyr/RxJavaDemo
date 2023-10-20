package org.example;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class PrintObserver implements Observer<Long> {
  private Disposable disposable;

  @Override
  public void onSubscribe(@NonNull Disposable d) {
    this.disposable = d;
  }

  @Override
  public void onNext(@NonNull Long item) {
    System.out.println("Received in Observer: " + item);
  }

  @Override
  public void onError(@NonNull Throwable e) {
    disposable.dispose();
    e.printStackTrace();
  }

  @Override
  public void onComplete() {
    disposable.dispose();
    System.out.println("Complete");
  }
}
