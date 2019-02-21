package ru.sync;

public class WorkThread extends Thread {
    Bank bankWork;
    int intTrans;
    long lngSleep;
    public WorkThread(Bank bankWork, int intTrans, long lngSleep){
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    @Override
    public void run() {
        bankWork.calc(intTrans,lngSleep);
//        super.run();
    }
}
