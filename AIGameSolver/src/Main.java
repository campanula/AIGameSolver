import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {

    Main() throws FileNotFoundException { //Main method with error handling

        //Variables for main method
        int input;
        String initialBoard;

        //Scanner that prompts user to choose which search algorithm to implement
        System.out.println("Enter 1 for uniform cost search, enter 2 for A* search");
        //Creating scanner
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) scanner.next();
        input = scanner.nextInt();

        //Outputs code for uniform cost search
        if(input == 1) {
            initialBoard = GameState.INITIAL_BOARD;

            Solver search = new Solver(GameState.GOAL_BOARD, new Node(initialBoard));

            PrintStream uniform = new PrintStream(new File("outputUniCost.txt"));
            System.setOut(uniform);
            search.uniformCostSearch();

            //Outputs code for A* search
        }else if (input == 2) {
            initialBoard = GameState.INITIAL_BOARD;

            Solver search = new Solver(GameState.GOAL_BOARD, new Node(initialBoard));

            PrintStream aStar = new PrintStream(new File("outputAstar.txt"));
            System.setOut(aStar);
            search.aStar(Solver.Heuristic.myHeuristic);

            //Error handling for main method
        }else{
            System.out.println("Please restart and enter either 1 or 2");
        }
    }

    //Calls Main method with error handling
    public static void main(String[] args) throws Exception {
        new Main();
    }
}
