package src.com.DesignPatterns.Creational.Factory;


//concrete product
public class Android implements OS{


    @Override
    public void spec() {
        System.out.println("Android");
    }
}
