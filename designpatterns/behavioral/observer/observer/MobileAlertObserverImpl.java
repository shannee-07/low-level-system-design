package designpatterns.behavioral.observer.observer;

import designpatterns.behavioral.observer.observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    String phone;
    StocksObservable observable;

    public MobileAlertObserverImpl(String phone, StocksObservable observable) {
        this.phone = phone;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsgOnMobile("Product is in stock, hurry!");
    }
    private void sendMsgOnMobile(String msg){
//        Send msg logic
        System.out.println("Message sent to "+phone);
    }
}
