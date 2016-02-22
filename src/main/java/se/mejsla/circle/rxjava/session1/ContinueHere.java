package se.mejsla.circle.rxjava.session1;

import rx.Observable;

public class ContinueHere {

    /**
     *
     * @param o1
     * @param o2
     * @return an Observable where the values from each input observable have been added
     * <br>
     * Hint: zipWith
     */
    public static Observable<Integer> sumPairs(Observable<Integer> o1, Observable<Integer> o2) {
        return Observable.error(new RuntimeException("Not Implemented"));
    }

    /**
     * @param integers an Observable emitting integers
     * @return an integer Observable where each value is multiplied with the preceding value/values.
     * <br>
     * Hint: scan
     */
    public static Observable<Integer> multiply(Observable<Integer> integers) {
        return Observable.error(new RuntimeException("Not Implemented"));
    }

    /**
     *
     * @param integers an Observable emitting integers
     * @return and Observable that emits one item which is the sum of all the even integers.
     * <br>
     * Hint: filter & reduce
     */
    public static Observable<Integer> sumOfAllEvenNumbers(Observable<Integer> integers) {
        return Observable.error(new RuntimeException("Not Implemented"));
    }
}
