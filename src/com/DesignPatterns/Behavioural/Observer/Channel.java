package src.com.DesignPatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Publisher{

    public String name;
    public List<Subscriber>subscribers;

    Channel(String name){
        this.name=name;
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void publish(String title) {
        for(Subscriber sub:subscribers){
            sub.getNotified(title);
        }
    }

    @Override
    public void addsub(Subscriber sub) {
        this.subscribers.add(sub);
    }

    @Override
    public void removesub(Subscriber sub) {
        this.subscribers.remove(sub);
    }
}
