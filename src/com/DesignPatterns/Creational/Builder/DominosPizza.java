package src.com.DesignPatterns.Creational.Builder;

public class DominosPizza implements PizzaBuilder{

    private int size;
    private String name;


    @Override
    public PizzaBuilder setName(String name) {
        this.name=name;
        return this;
    }

    @Override
    public PizzaBuilder setSize(int size) {
        this.size=size;
        return this;
    }

    @Override
    public Pizza build() {
        return new Pizza(name, size);
    }
}
