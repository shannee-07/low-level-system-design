package designpatterns.structural.decorator;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription()+", Sugar";
    }
    @Override
    public double getCost(){
        return decoratedCoffee.getCost() + 3.7;
    }
}
