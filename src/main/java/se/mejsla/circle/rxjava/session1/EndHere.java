package se.mejsla.circle.rxjava.session1;

import rx.Observable;
import rx.observables.GroupedObservable;

public class EndHere {

    /**
     *
     * @param s1 an Observable emitting strings
     * @param s2 an Observable emitting strings
     * @return the data from the fastest source
     * <br>
     * Hint: amb
     */
    public static Observable<String> getFromFastestSource(Observable<String> s1, Observable<String> s2) {
        return Observable.amb(s1, s2);
    }

    /**
     *
     * @param strings an Observable emitting strings
     * @return strings grouped by number of words in each string (words are separated by a space)
     * <br>
     * Hint: groupBy
     */
    public static Observable<GroupedObservable<Integer, String>> groupBySentenceLength(Observable<String> strings) {
        return strings.groupBy(album -> album.split(" ").length);
    }

}
