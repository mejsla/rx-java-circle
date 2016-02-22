package se.mejsla.circle.rxjava.session1;

import org.junit.Before;
import org.junit.Test;
import rx.Observable;
import rx.observables.GroupedObservable;
import rx.observers.TestSubscriber;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EndHereTest {

    TestSubscriber<Object> testSubscriber;

    @Before
    public void before() {
        testSubscriber = new TestSubscriber<>();
    }

    @Test
    public void getFromFastestSourceTest() throws Exception {
        Observable<String> slowSource = StartHereTest.getDataWithInterval(Arrays.asList("One", "Two"), 100L);
        Observable<String> fastSource = StartHereTest.getDataWithInterval(Arrays.asList("Three", "Four"), 10L);

        Observable<String> observable = EndHere.getFromFastestSource(slowSource, fastSource);

        observable.toBlocking().subscribe(testSubscriber);
        testSubscriber.assertReceivedOnNext(Arrays.asList("Three", "Four"));
    }

    @Test
    public void groupBySentenceLengthTest() {
        Observable<GroupedObservable<Integer, String>> group =
                EndHere.groupBySentenceLength(Observable.just(
                        "Love You Till Tuesday", "The Prettiest Star", "Hang On to Yourself", "Holy Holy", "Life on Mars?"));

        TestSubscriber<GroupedObservable> testSubscriber = new TestSubscriber<>();

        group.subscribe(testSubscriber);
        testSubscriber.assertValueCount(3);

        List<GroupedObservable> onNextEvents = testSubscriber.getOnNextEvents();
        TestSubscriber testGroupSubscriber = new TestSubscriber();
        onNextEvents.get(0).subscribe(testGroupSubscriber);
        assertEquals("Incorrect key", 4, onNextEvents.get(0).getKey());
        testGroupSubscriber.assertReceivedOnNext(Arrays.asList("Love You Till Tuesday", "Hang On to Yourself"));
    }
}