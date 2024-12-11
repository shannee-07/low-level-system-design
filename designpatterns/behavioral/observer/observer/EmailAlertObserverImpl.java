package designpatterns.behavioral.observer.observer;

import designpatterns.behavioral.observer.observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    String emailId;
    StocksObservable observable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId,"Product is in stock, hurry");
    }
    private void sendEmail(String emailId, String msg){
//        Send email to user
        System.out.println("Email sent to: "+emailId);
    }
}
