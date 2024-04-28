package src.com.DesignPatterns.Behavioural.Observer;

public interface Publisher {
    public void publish(String title);
    public void addsub(Subscriber sub);
    public void removesub(Subscriber sub);
}
