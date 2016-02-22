package se.mejsla.circle.rxjava.session1;

import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.observers.TestSubscriber;

import java.util.Arrays;

public class ContinueHereTest {

    TestSubscriber<Object> testSubscriber;

    @Before
    public void before() {
        testSubscriber = new TestSubscriber<>();
    }

    @Test
    public void sumPairsTest() throws Exception {
        Observable result = ContinueHere.sumPairs(Observable.just(0,2,3,5), Observable.just(0,4,3,77));

        result.subscribe(testSubscriber);
        testSubscriber.assertReceivedOnNext(Arrays.asList(0,6,6,82));
        testSubscriber.assertCompleted();
    }

    @Test
    public void scanTest() {
        Observable<Integer> scanning = ContinueHere.multiply(Observable.just(1, 2, 3, 4, 5));
        scanning.subscribe(testSubscriber);
        testSubscriber.assertReceivedOnNext(Arrays.asList(1, 2, 6, 24, 120));
        testSubscriber.assertCompleted();
    }

    @Test
    public void sumOfAllEvenNumbersTest() {
        ContinueHere.sumOfAllEvenNumbers(Observable.just(2,7,13,4,8,44,5,7))
                .subscribe(testSubscriber);
        testSubscriber.assertReceivedOnNext(Arrays.asList(58));
    }
}