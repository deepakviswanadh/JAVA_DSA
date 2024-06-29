package src.com.DesignPatterns.Structural.Composite;

public class Test {

    public static void main(String[] args) {
        Composite PC = new Composite("PC");
        Composite CPU = new Composite("CPU");
        Composite Peripherals = new Composite("Peripherals");
        Composite motherboard = new Composite("MB");

        Component mouse = new Leaf("mouse",500);
        Component keyboard = new Leaf("keyboard",1500);
        Component RAM = new Leaf("ram",3000);
        Component processor = new Leaf("processor",10500);
        Component HDD = new Leaf("HDD",5000);


        motherboard.addComponent(RAM);
        motherboard.addComponent(processor);

        Peripherals.addComponent(mouse);
        Peripherals.addComponent(keyboard);


        CPU.addComponent(motherboard);
        CPU.addComponent(HDD);

        PC.addComponent(CPU);
        PC.addComponent(Peripherals);

        PC.showPrice();
    }
}
