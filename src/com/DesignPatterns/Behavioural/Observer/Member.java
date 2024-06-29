package src.com.DesignPatterns.Behavioural.Observer;

public class Member implements Subscriber{

    public String name;
    public Publisher channel;


    Member(String name){
        this.name=name;
    }

    @Override
    public void subscribe(Publisher channel) {
        this.channel=channel;
        this.channel.addsub(this);
    }

    @Override
    public void unsubscribe() {
        this.channel.removesub(this);
        this.channel=null;
    }

    @Override
    public void getNotified(String title) {
        System.out.println("Hey "+name +" a new video: "+title+" has been uploaded");
    }
}
