package src.com.springboot.DependencyInjection;

public class MessageProcessorConstructor {
    MessageService messageService;

    //constructor based injection
    //basing on the type of the service that is being passed to the constructor,
    //the corresponding service will be invoked
    public MessageProcessorConstructor(MessageService messageService){
        this.messageService=messageService;
    }

    public void processMessage(){
        messageService.implementService();
    }
}
