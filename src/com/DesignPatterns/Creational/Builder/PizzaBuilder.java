package src.com.DesignPatterns.Creational.Builder;

public interface PizzaBuilder {
    PizzaBuilder setName(String name);
    PizzaBuilder setSize(int size);

    Pizza build();
}
