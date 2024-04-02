package src.com.DesignPatterns.DependencyInjection;

public class Test {

    public static void main(String[] args) {
        SMSService smsService = new SMSService();
        MMSService mmsService= new MMSService();

        //constructor based injection
        //basing on the requirement, we can pass the required service
        //injecting dependency instead of making it hardly coupled in the class
        //interface segregation from SOLID
        MessageProcessorConstructor messageProcessorConstructor = new MessageProcessorConstructor(smsService);
        messageProcessorConstructor.processMessage();

        MessageProcessorConstructor messageProcessorConstructor1 = new MessageProcessorConstructor(mmsService);
        messageProcessorConstructor1.processMessage();


        //Setter based injection
        MessageProcessorSetter messageProcessorSetter = new MessageProcessorSetter();
        messageProcessorSetter.setService(smsService);
        messageProcessorSetter.processMessage();


        //Field based injection
        MessageProcessorField messageProcessorField = new MessageProcessorField();
        messageProcessorField.messageService=smsService;
        messageProcessorField.processMessage();
    }
}
