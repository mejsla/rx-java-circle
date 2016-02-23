package se.mejsla.circle.rxjava.session1;

import rx.Observable;

public class StartHere {

    /**
     *
     * @param name an Observable emitting Strings
     * @return and Observable that for each item in the {@code name} observable prefixes it with "Hello ".
     * <br>
     * Hint: map
     */
    public static Observable<String> helloMap(Observable<String> name) {
        return name.map(s -> "Hello " + s);
    }

    /**
     *
     * @param s1 an Observable emitting strings
     * @param s2 an Observable emitting strings
     * @return an Observable containing the values from {@code s1} and {@code s2} concatenated
     * <br>
     * Hint: concat
     */
    public static Observable<String> concatObservables(Observable<String> s1, Observable<String> s2) {
        return  Observable.concat(s1, s2);
    }

    /**
     *
     * @param s1 an Observable emitting strings
     * @param s2 an Observable emitting strings
     * @return merge the two Observables {@code s1} and {@code s2}
     * <br>
     * Hint: merge
     */
    public static Observable<String> mergeObservables(Observable<String> s1, Observable<String> s2) {
        return  Observable.merge(s1, s2);
    }

}
