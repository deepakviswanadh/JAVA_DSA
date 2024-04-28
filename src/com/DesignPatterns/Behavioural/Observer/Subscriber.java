package src.com.DesignPatterns.Behavioural.Observer;

public interface Subscriber {
    public void subscribe(Publisher channel);
    public void unsubscribe();

    public void getNotified(String title);
}
