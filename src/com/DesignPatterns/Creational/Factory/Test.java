package src.com.DesignPatterns.Creational.Factory;

public class Test {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.createOS("iOS").spec();
    }
}
