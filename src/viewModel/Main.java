package viewModel;

public class Main {
    private static ChatBotViewModel chatBotViewModel = new ChatBotViewModel();
    public static void main(String[] args) {
        System.out.println("Welcome to chatBot App");
        chatBotViewModel.start();
    }
}