package model;

import viewModel.ChatBotViewModel;

import java.util.Stack;

public class ChatBotModel {

   public static Stack<String> stack = new Stack<>();
   private static ChatBotViewModel chatBotViewModel = new ChatBotViewModel();

  public   void languageSelectOption() {
        String sms = """
                =1. English
                =2. Tamil
                =3. Telgu
                =4. Hindi
                =5. Marathi
                """;
        chatBotViewModel.printTheList(sms);

    }


}
