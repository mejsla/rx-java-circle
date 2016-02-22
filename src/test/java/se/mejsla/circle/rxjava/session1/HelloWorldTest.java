package se.mejsla.circle.rxjava.session1;

import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

public class HelloWorldTest {

    TestSubscriber<Object> testSubscriber;

    @Before
    public void before() {
        testSubscriber = new TestSubscriber<>();
    }

    @Test
    public void testHelloObservable() throws Exception {
        Observable<String> stringObservable = HelloWorld.helloWorld();
        stringObservable.subscribe(testSubscriber);
        testSubscriber.assertValue("Hello World");
        testSubscriber.assertCompleted();
    }
}