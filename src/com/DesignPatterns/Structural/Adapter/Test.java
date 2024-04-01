package src.com.DesignPatterns.Structural.Adapter;

public class Test {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.implementMe();
    }
}
