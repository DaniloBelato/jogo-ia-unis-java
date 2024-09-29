import java.util.Random;
import java.util.Scanner;

public class jogoIaUnis {
    private static final String[] CHOICES = {"Pedra", "Papel", "Tesoura"};
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        playGame();
        scanner.close();
    }

    private static void playGame() {
        while (true) {
            String userChoice = getUserChoice();
            if (userChoice.equalsIgnoreCase("Sair")) {
                break;
            }

            String aiChoice = getAIChoice();
            displayChoices(userChoice, aiChoice);
            determineWinner(userChoice, aiChoice);
        }
    }

    private static String getUserChoice() {
        System.out.println("Escolha Pedra, Papel ou Tesoura. Digite 'Sair' para sair.");
        return scanner.nextLine();
    }

    private static String getAIChoice() {
        return CHOICES[random.nextInt(CHOICES.length)];
    }

    private static void displayChoices(String userChoice, String aiChoice) {
        System.out.println("Você escolheu " + userChoice + ". A IA escolheu " + aiChoice + ".");
    }

    private static void determineWinner(String userChoice, String aiChoice) {
        if (userChoice.equalsIgnoreCase(aiChoice)) {
            System.out.println("Empate!");
        } else if (isUserWinner(userChoice, aiChoice)) {
            System.out.println("Você ganhou!");
        } else {
            System.out.println("A IA ganhou!");
        }
    }

    private static boolean isUserWinner(String userChoice, String aiChoice) {
        return (userChoice.equalsIgnoreCase("Pedra") && aiChoice.equalsIgnoreCase("Tesoura")) ||
               (userChoice.equalsIgnoreCase("Papel") && aiChoice.equalsIgnoreCase("Pedra")) ||
               (userChoice.equalsIgnoreCase("Tesoura") && aiChoice.equalsIgnoreCase("Papel"));
    }
}
