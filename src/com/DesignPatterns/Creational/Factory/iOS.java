package src.com.DesignPatterns.Creational.Factory;

//concrete product
public class iOS implements OS{

    @Override
    public void spec() {
        System.out.println("iOS");
    }
}
