package src.com.DesignPatterns.Creational.Builder;

public class Test {
    public static void main(String[] args) {
        PizzaHutPizza pizzaHutPizza= new PizzaHutPizza();
        pizzaHutPizza.setName("small").setSize(1).build();

        DominosPizza dominosPizza = new DominosPizza();
        dominosPizza.setName("med").setSize(2).build();
    }
}
