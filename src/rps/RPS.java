package rps;

import java.util.Random;
import java.util.Scanner;

public class RPS {

    public static Scanner scanner = new Scanner(System.in);
    public static String playerPastMove = "p";
    public static String aiPastMove = "r";
    

    public static void main(String[] args) {

        System.out.println("Let's play rock, paper, scissors!");
        System.out.println("Play by typing r for rock, p for paper, and s for scissors");
        System.out.println("Let's start playing!");

        playGame();
        while (playAgain()) {
            playGame();
        }

    }

    public static void playGame() {
        String computer = aiChoice();
        String user = playerChoice();
        isWinner(computer, user);
        
    }

    public static String aiChoice() {
        Random rand = new Random();
        int cinput = rand.nextInt(3) + 1;
        String computer = "";

        if (playerPastMove.equals("r")) {
            if (aiPastMove.equals("p")) {
                computer = "s";
            }
            if (aiPastMove.equals("s")) {
                computer = "p";
            }
            if (aiPastMove.equals("r")) {
                computer = "p";
            }
        } else if (playerPastMove.equals("p")) {
            if (aiPastMove.equals("p")) {
                computer = "r";
            }
             if (aiPastMove.equals("s")) {
                computer = "r";
            }
            if (aiPastMove.equals("r")) {
                computer = "s";
            }
        } else if (playerPastMove.equals("s")) {
            computer = "r";
        } else {
            if (cinput == 1) {
                computer = "r";
            }
            if (cinput == 2) {
                computer = "p";
            }
            if (cinput == 3) {
                computer = "s";
            }
        }
        return computer;
    }

    public static boolean playAgain() {
        System.out.println("Play again?(y/n)");
        String input = scanner.nextLine();
        if (input.toLowerCase().equals("y")) {
            return true;
        } else if (input.toLowerCase().equals("n")) {
            return false;
        } else {
            System.out.println("Invalid Input");
            return playAgain();
        }

    }

    public static String playerChoice() {

        String user = "default";
        do {
            System.out.println("Choose one: r,p, or s");
            user = scanner.nextLine();
        } while (!isValidChoice(user));
        return user;
    }

    public static boolean isValidChoice(String choice) {
        boolean status;
        if (choice.equals("r")) {
            status = true;
        } else if (choice.equals("p")) {
            status = true;
        } else if (choice.equals("s")) {
            status = true;
        } else {
            status = false;
            System.out.println("Error! Enter only lower case letters r, p, or s");
        }

        return status;
    }

    public static void isWinner(String computer, String user) {

        playerPastMove = user;
        aiPastMove = computer;
        System.out.println(" AI Choice: " + computer);
        System.out.println(" Your Choice : " + user);
        if (computer.equals("r") && user.equals("s")) {

            System.out.println(" Computer wins! Better luck next time!");
        }
        if (computer.equals("s") && user.equals("p")) {

            System.out.println(" Computer wins! Better luck next time!");
        }
        if (computer.equals("p") && user.equals("r")) {

            System.out.println(" Computer wins! Better luck next time!");
        }
        if (computer.equals("r") && user.equals("p")) {

            System.out.println(" You win!");
        }
        if (computer.equals("s") && user.equals("r")) {

            System.out.println(" You win!");
        }
        if (computer.equals("p") && user.equals("s")) {

            System.out.println(" You win!");
        } else if (computer.equals(user)) {
            System.out.println(" Tie! ");
        }

    }

}
