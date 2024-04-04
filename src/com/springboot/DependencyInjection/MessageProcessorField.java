package src.com.springboot.DependencyInjection;

public class MessageProcessorField {

    MessageService messageService;

    //this is field based injection where the object is instantiated
    //1st and then we directly link to property to the object
    // and invoke the services

    public MessageProcessorField(){

    }

    public void processMessage(){
        if(this.messageService!=null){
            messageService.implementService();
        }
        else{
            System.out.println("Service not linked");
        }
    }
}
