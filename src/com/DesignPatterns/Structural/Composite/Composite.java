package src.com.DesignPatterns.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{

    List<Component>components;
    String name;

    Composite(String name){
        this.name= name;
        components= new ArrayList<>();
    }

    @Override
    public void showPrice() {
        System.out.println(this.name);
        components.stream().forEach(Component::showPrice);
    }

    public void addComponent(Component component){
        components.add(component);
    }
}
