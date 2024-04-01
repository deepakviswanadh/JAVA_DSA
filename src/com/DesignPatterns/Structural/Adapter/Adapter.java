package src.com.DesignPatterns.Structural.Adapter;

public class Adapter implements Target{

    Adaptee adaptee= new Adaptee();

    @Override
    public void implementMe() {
        //converting adaptee's method to adapter's way
        adaptee.convertMe();
    }
}
