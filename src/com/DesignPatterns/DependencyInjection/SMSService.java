package src.com.DesignPatterns.DependencyInjection;

public class SMSService implements MessageService{

    @Override
    public void implementService() {
        System.out.println("implemented through SMS Service");
    }
}
