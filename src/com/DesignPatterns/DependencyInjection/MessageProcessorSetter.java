package src.com.DesignPatterns.DependencyInjection;

public class MessageProcessorSetter {
    MessageService messageService;

    public MessageProcessorSetter(){

    };

    //this is setter based injection where the object is instantiated
    //1st and then a setter is called to inject the corresponding
    //dependency

    public void setService(MessageService messageService){
        this.messageService=messageService;

    }

    public void processMessage(){
        messageService.implementService();
    }
}
