package src.com.DesignPatterns.Behavioural.Observer;

public class test {
    public static void main(String[] args) {
        Publisher p1 = new Channel("pewds");
        Subscriber s1 = new Member("m1");
        Subscriber s2= new Member("m2");
        Subscriber s3 = new Member("m3");
        s1.subscribe(p1);
        s2.subscribe(p1);
        s3.subscribe(p1);

        p1.publish("test video");

        s2.unsubscribe();

        p1.publish("one guy unsubbed");

    }
}
