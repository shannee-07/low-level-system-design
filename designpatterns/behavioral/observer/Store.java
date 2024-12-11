package designpatterns.behavioral.observer;

import designpatterns.behavioral.observer.observable.IphoneObserverImpl;
import designpatterns.behavioral.observer.observable.StocksObservable;
import designpatterns.behavioral.observer.observer.EmailAlertObserverImpl;
import designpatterns.behavioral.observer.observer.MobileAlertObserverImpl;
import designpatterns.behavioral.observer.observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStocksObservable = new IphoneObserverImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("abc@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("9876543210", iphoneStocksObservable);

        iphoneStocksObservable.add(observer1);
        iphoneStocksObservable.add(observer2);
        iphoneStocksObservable.add(observer3);

        iphoneStocksObservable.setStockCount(10);
    }

}
