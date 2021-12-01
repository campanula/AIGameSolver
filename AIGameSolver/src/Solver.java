import java.util.*;
import java.util.Comparator;

public class Solver {
    private char value;
    private int count = 0;
    private String isGoal;
    private Node rootNode;
    Set<String> visitedNodes = new HashSet<String>();  // Creates hash set of already-visited nodes


    // constructor for solver
    public Solver(String isGoal, Node rootNode) {
        this.isGoal = isGoal;
        this.rootNode = rootNode;
    }

    //Making a class I can pull the heuristic from
    public enum Heuristic {
        myHeuristic
    }

    // creating a comparator to be used to sort nodes by their cost value
    public class Compare implements Comparator<Node> {

        @Override
        public int compare(Node a, Node b) {
            while (b.returnCost() < a.returnCost()) {
                return 1;
            }
            while (b.returnCost() > a.returnCost()) {
                return -1;
            }
            return 0;
        }
    }


    public void uniformCostSearch() {
        Node node = new Node(rootNode.returnState());
        Node childNode;

        Compare compare = new Compare(); // sorts queue based on cost values using comparator

        // initialises a queue with nodes sorted with their cost values
        PriorityQueue<Node> myQueue = new PriorityQueue<Node>(5, compare);
        Node n = node;

        while (!n.returnState().equals(isGoal)) { //while the node state does not equal the goal state
            String state = n.returnState(); //call the current state
            visitedNodes.add(state);    //add the node state to the visited nodes
            List<String> nodeChild = GameState.possibleMoves(state); //put the children of the visited node through the switch statements

            for (String newNode : nodeChild) { // for reach node in the children

                if (visitedNodes.contains(newNode)) {
                    //if the newNode is already in visitedNodes, break one iteration
                    continue;
                } else if (!visitedNodes.contains(newNode)) {
                    // if the newNode is not already in visitedNodes, continue as normal
                }

                visitedNodes.add(newNode); //add the node to visited nodes
                childNode = new Node(newNode); // create childNode as the newNode
                n.Child(childNode);
                childNode.Parent(n); // assign the parent of the childNode as the node

                value = childNode.returnState().charAt(childNode.returnParent().returnState().indexOf('0'));
                childNode.Cost(n.returnCost() + Character.getNumericValue(value), 0);
                myQueue.add(childNode); // add the childNode to the queue
            }
            n = myQueue.poll(); // returns and deletes the element at the front  of the queue
            count += 1; // increase loop counter by 1
        }
        Output.output1(rootNode, visitedNodes, n, count); //Output the data from the search using the output1 method

    }

    public void aStar(Heuristic heuristic) {

        Node node = new Node(rootNode.returnState());
        Node childNode;

        Compare compare = new Compare(); // sorts queue based on cost values using comparator

        // initialises a queue with nodes sorted with their cost values
        PriorityQueue<Node> myQueue = new PriorityQueue<Node>(5, compare);
        Node n = node;

        while (!n.returnState().equals(isGoal)) { //while the node state does not equal the goal state
            String state = n.returnState(); //call the current state
            visitedNodes.add(state);    //add the node state to the visited nodes
            List<String> nodeChild = GameState.possibleMoves(state); //put the children of the visited node through the switch statements

            for (String newNode : nodeChild) { // for reach node in the children

                if (visitedNodes.contains(newNode)) {
                    //if the newNode is already in visitedNodes, break one iteration
                    continue;
                } else if (!visitedNodes.contains(newNode)) {
                // if the newNode is not already in visitedNodes, continue as normal
                }

                visitedNodes.add(newNode); //add the node to visited nodes
                childNode = new Node(newNode); // create childNode as the newNode
                n.Child(childNode);
                childNode.Parent(n); // assign the parent of the childNode as the node

                //Calling the heuristic
                if (heuristic == Heuristic.myHeuristic) { // if heuristic one is specified in the main method
                    value = childNode.returnState().charAt(childNode.returnParent().returnState().indexOf('0'));
                    childNode.Cost(n.returnCost() + Character.getNumericValue(value), SetHeuristic.mHeuristic(childNode.returnState(), isGoal));
                    myQueue.add(childNode); // add the childNode to the queue
                }

            }
            n = myQueue.poll(); // returns and deletes the element at the front  of the queue
            count += 1; // increase loop counter by 1
        }
        Output.output2(rootNode, visitedNodes, n, count); //Output the data from the search using the output2 method

    }

}