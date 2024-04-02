package src.com.DesignPatterns.DependencyInjection;

public class MMSService implements MessageService{

    @Override
    public void implementService() {
        System.out.println("implemented through MMS Service");
    }
}
