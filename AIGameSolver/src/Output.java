import java.util.Set;
import java.util.Stack;

public class Output {
    public static void output1(Node rootNode, Set<String> visitedNodes, Node finalNode, int count) {

        System.out.println("-------------------------");
        System.out.println("   Uniform Cost Search");
        System.out.println("-------------------------");
        long start = System.currentTimeMillis(); //grabbing the time before running the search

        //Gathering the output
        Stack<Node> stack = new Stack<Node>();
        stack.push(finalNode);

        //until the final node = the root node, push the parent of the final node
        while (!finalNode.returnState().equals(rootNode.returnState())) {
            Node returny = finalNode.returnParent();
            stack.push(returny);
            finalNode = returny;
        }

        //Printing out the output
        int i;
        int stacky = stack.size();

        for (i = stacky - 1; i >= 0; i--) {
            String output = stack.get(i).returnState().substring(0, 9); //using 0-9 as there are 9 values
            System.out.println(output);
        }

        long end = System.currentTimeMillis(); //grabbing the time after running the search

        // printed info about search process
        System.out.println("-------------------------");
        System.out.println("Number of moves: " + (stack.size()));
        System.out.println("Expanded nodes: " + (visitedNodes.size()));
        System.out.println("Unexpanded nodes: " + (count));
        System.out.println("Time taken: " + (end - start) + " millisecond(s)");

    }

    public static void output2(Node rootNode, Set<String> visitedNodes, Node finalNode, int count) {

        System.out.println("-------------------------");
        System.out.println("        A* Search");
        System.out.println("-------------------------");
        long start = System.currentTimeMillis(); //grabbing the time before running the search

        //Gathering the output
        Stack<Node> stack = new Stack<Node>(); //Creating a stack to push the printed strings into
        stack.push(finalNode);

        //until the final node = the root node, push the parent of the final node
        while (!finalNode.returnState().equals(rootNode.returnState())) {
            Node returny = finalNode.returnParent();
            stack.push(returny);
            finalNode = returny;
        }

        //Printing out the output from the stack
        int i;
        int stacky = stack.size();

        for (i = stacky - 1; i >= 0; i--) {
            String output = stack.get(i).returnState().substring(0, 9); //using 0-9 as there are 9 values
            System.out.println(output);
        }

        long end = System.currentTimeMillis(); //grabbing the time after running the search


        // printed info about search process
        System.out.println("-------------------------");
        System.out.println("Number of moves: " + (stack.size()));
        System.out.println("Expanded nodes: " + (visitedNodes.size()));
        System.out.println("Unexpanded nodes: " + (count));
        System.out.println("Time taken: " + (end - start) + " millisecond(s)");

    }
}
