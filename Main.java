import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        LifeThreadsGame game = new LifeThreadsGame();
        Scanner input = new Scanner(System.in);
        System.out.println("______________________________________________________");
        System.out.println(" Life Threads: John Conway's Game of Life Simulation");
        System.out.println("------------------------------------------------------");
        System.out.println("Original");
        game.print(game.getGrid());

        System.out.print("How many generations? Please type in a positive integer: ");
        char choice = input.nextLine().trim().charAt(0);
        System.out.println("");
        System.out.println("Working...");

        for (int i = 0; i < choice; i++) {
            game.runThreads();
        }

        System.out.println("Generation " + choice);
        game.print(game.getNext_Generation());
    }
}