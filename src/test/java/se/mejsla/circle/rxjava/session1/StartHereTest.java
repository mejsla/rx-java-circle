package se.mejsla.circle.rxjava.session1;

import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StartHereTest {

    TestSubscriber<Object> testSubscriber;

    @Before
    public void before() {
        testSubscriber = new TestSubscriber<>();
    }

    @Test
    public void helloMapTest() {
        Observable<String> observable = StartHere.helloMap(Observable.just("Jane Doe"));
        observable.subscribe(testSubscriber);

        testSubscriber.assertValue("Hello Jane Doe");
        testSubscriber.assertCompleted();
    }

    @Test
    public void concatTest() throws Exception {
        Observable<String> a = getDataWithInterval(Arrays.asList("One", "Two"), 100L);
        Observable<String> b = getDataWithInterval(Arrays.asList("Three", "Four"), 10L);

        Observable<String> observable = StartHere.concatObservables(a, b);

        observable.toBlocking().subscribe(testSubscriber);
        testSubscriber.assertReceivedOnNext(Arrays.asList("One", "Two", "Three", "Four"));
    }

    @Test
    public void mergeTest() throws Exception {
        Observable<String> a = getDataWithInterval(Arrays.asList("One", "Two"), 10L);
        Observable<String> b = getDataWithInterval(Arrays.asList("Three", "Four"), 15L);

        Observable<String> observable = StartHere.mergeObservables(a, b);

        observable.toBlocking().subscribe(testSubscriber);
        testSubscriber.assertReceivedOnNext(Arrays.asList("One", "Three", "Two", "Four"));
    }

    public static Observable<String> getDataWithInterval(List<String> data, long interval) {
        return Observable.zip(Observable.from(data), Observable.interval(interval, TimeUnit.MILLISECONDS), (s, aLong) -> s);
    }

}