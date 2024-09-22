package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChatBotView {
    private static Scanner sc = new Scanner(System.in);

    public int takeInput(String prompt,String errorMessage) {

        System.out.println(prompt);
            while (true) {
                try {
                 int n = sc.nextInt();
                 return n;


        } catch (Exception InputMismatchException) {

            System.out.println(errorMessage);
            sc.next();
        }
            }

    }
}
