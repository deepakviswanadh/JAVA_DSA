package src.com.DesignPatterns.Creational.Builder;

public class Pizza {

    public String name;
    public int size;

    public Pizza(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }


}
