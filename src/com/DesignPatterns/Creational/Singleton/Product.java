package src.com.DesignPatterns.Creational.Singleton;

public class Product {

    //private static instance
    private static Product product;

    //private constructor
    private Product(){

    }

    //public static method to access that private single instance
    public static Product getInstance(){
        if(product==null){
            product = new Product();
        }
        return product;
    }
}
