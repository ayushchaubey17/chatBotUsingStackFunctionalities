package viewModel;

import model.ChatBotModel;
import view.ChatBotView;

public class ChatBotViewModel {


    private  static ChatBotModel chatBotModel = new ChatBotModel();
    private  static ChatBotView chatBotView = new ChatBotView();

    public void  start(){
        chatBotModel.languageSelectOption();
        int inputOfLanguage =   chatBotView.takeInput("--------------please Select your preffered Language","please enter a valid number");

        moveToLanguage(inputOfLanguage);

    }

    void moveToLanguage(int n) {
        if (n==1) chatBotModel.stack.push("English");

       else  if (n==2) chatBotModel.stack.push("Tamil");

        else  if (n==2) chatBotModel.stack.push("Telgu");

        else  if (n==2) chatBotModel.stack.push("Hindi");

        else  if (n==2) chatBotModel.stack.push("Marathi");

        String functionToCall = chatBotModel.stack.peek();

        callTheFunction(functionToCall);

    }

    private void callTheFunction(String functionToCall) {
        if (functionToCall.equals("English")) optionInEnglish();
        else   if (functionToCall.equals("Hindi")) optionInHindi();
    }

    private void optionInHindi() {
    }

    private void optionInEnglish()  {
        String sms = """
                =1. For Your Recharge
                =2. For your Caller tune
                =3. for cricket update
                =4. for ipl score
                =5. Big boss subscription
                =9. back
                =0. exit
                """;
        printTheList(sms);

//        System.out.println(sms);

        int inputOfService =   chatBotView.takeInput("--------------please Select your choice ","please enter a valid choice");
        goForTheEnglishChoice(inputOfService);
    }

    public  void printTheList(String sms) {
        String arr[] = sms.split("=");
        Thread t = Thread.currentThread();

        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                Thread.sleep(260);
            }
        }
        catch (InterruptedException e){
            System.out.println(sms);
        }


    }

    private void goForTheEnglishChoice(int i) {
        if (i == 0){
            chatBotModel.stack.clear();
            start();
        }
        else if(i==9){
           goToBack();
        }
        else if (i==1){
            chatBotModel.stack.push("Recharge");
            callForRecharge("Recharge");
        }


    }

    private void goToBack() {
        System.out.println(chatBotModel.stack.pop());

        if (chatBotModel.stack.isEmpty())start();
        else{
            String lastOperation = chatBotModel.stack.peek();
            performLastOperation(lastOperation);
        }

    }

    private void performLastOperation(String lastOperation) {
        if (lastOperation.equals("English"))callTheFunction(lastOperation);
        else if (lastOperation.equals("Recharge"))callForRecharge(lastOperation);

        else if (lastOperation.equals("Prepaid"))callForPrepaid(lastOperation);

        else {
            start();
        }

    }

    private void callForRecharge(String lastOperation) {
        String sms = """
                =1. prepaid recharge
                =2. postpaid recharge
                =3. tarrif plan
                =4. best plan
                =5. data plan
                =9. back
                =0. exit
                """;

//        System.out.println(sms);

        printTheList(sms);
        int inputOfRecharge=   chatBotView.takeInput(" --------------Select your Recharge type ","please enter a valid choice");
        goForRecharge(inputOfRecharge);
    }

    private void goForRecharge(int i) {

        if (i == 0){
            chatBotModel.stack.clear();
            start();
        }
        else if(i==9){
            goToBack();
        }
        else if (i==1){
            chatBotModel.stack.push("Prepaid");
            callForPrepaid("Prepaid");
        }
}

    private void callForPrepaid(String recharge) {
        String sms = """
                =1. 349 - 2gb/day  for 28 days 
                =2. 299 1gb/day for 28 days
                =3. 665 1.5gb/day for 84 days
                =4. 1089 1.5gb/day for 84 days
                =5. 3065 1.5gb/day for 84 days
                =9. back
                =0. exit
                """;

        printTheList(sms);

//        System.out.println(sms);
        int choiceOfRecharge=   chatBotView.takeInput("-------------- Select your  Recharge plan","please enter a valid choice");
       rechargePlan(choiceOfRecharge);


    }

    private void rechargePlan(int i) {
        if (i == 0){
            chatBotModel.stack.clear();
            start();
        }
        else if(i==9){
            goToBack();
        }
        else if (i==1){
            chatBotModel.stack.push("Prepaid");
            callForPrepaid("Prepaid");
        }
    }
}
