package se.mejsla.circle.rxjava.session1;

import rx.Observable;

public class HelloWorld {

    public static void main(String[] args) {
        Observable.just("World").subscribe((str) -> System.out.println("Hello " + str));
    }

    public static Observable<String> helloWorld() {
        return Observable.just("Hello World");
    }
}
