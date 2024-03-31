package src.com.DesignPatterns.Creational.Factory;

//concrete product
public class Windows implements OS{
    @Override
    public void spec() {
        System.out.println("Windows");
    }
}
