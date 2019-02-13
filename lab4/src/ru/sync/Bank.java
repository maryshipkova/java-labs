package ru.sync;

public class Bank {
    int intTo = 0;
    int intFrom = 220;

    synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("before: intTo: " + intTo + ", intFrom: " + intFrom + ", ThreadName: " + Thread.currentThread().getName());
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (Exception e) {

        }
        intTo += intTransaction;
        System.out.println("after: intTo: " + intTo + ", intFrom: " + intFrom + ", ThreadName: " + Thread.currentThread().getName());
    }
}
