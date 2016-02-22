package se.mejsla.circle.rxjava.session1;

import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

public class HelloWorldTest {

    @Test
    public void testHelloObservable() throws Exception {
        TestSubscriber<Object> testSubscriber = new TestSubscriber<>();
        Observable<String> stringObservable = HelloWorld.helloWorld();
        stringObservable.subscribe(testSubscriber);

        testSubscriber.assertValue("Hello World");
        testSubscriber.assertCompleted();
    }
}