package src.com.DesignPatterns.Creational.Factory;

public class test {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.createOS("iOS").spec();
    }
}
