package designpatterns.structural.decorator;

public class PlainCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "This is a plain coffee";
    }

    @Override
    public double getCost() {
        return 10.0;
    }
}
