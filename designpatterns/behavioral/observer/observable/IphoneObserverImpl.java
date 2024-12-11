package designpatterns.behavioral.observer.observable;

import designpatterns.behavioral.observer.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObserverImpl implements StocksObservable {
    List<NotificationAlertObserver> observerList;
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        if(observerList == null){
            observerList = new ArrayList<>();
        }
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        System.out.println("Current stock"+ stockCount);
        if(stockCount==0){
            notifySubscribers();
        }
        stockCount+=newStockAdded;
    }

    @Override
    public int getStockCount() {
        return 0;
    }
}
