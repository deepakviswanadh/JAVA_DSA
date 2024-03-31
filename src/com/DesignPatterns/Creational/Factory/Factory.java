package src.com.DesignPatterns.Creational.Factory;

//factory
public class Factory {


    public OS createOS(String type){
        switch (type){
            case "Android":
                return new Android();
            case "iOS":
                return new iOS();
            case "Windows":
                return new Windows();
        }
        return null;
    }
}
