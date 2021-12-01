import java.util.ArrayList;

public class Node {

    private ArrayList<Node> childNodes;
    private String state;

    private int parent;
    private Node parentNode;
    private Node childNode;

    private int cost;
    private int totalCost;

    //Constructor for node
    public Node(String state) {
        childNodes = new ArrayList<Node>();
        this.state = state;
    }

    //method to call state
    public String returnState() {

        return state;
    }

    // method used to assign a value to the variable parentNode
    public void Parent(Node parent) {

        this.parentNode = parent;
    }

    // method to call parentNode
    public Node returnParent() {

        return parentNode;
    }

    // method to add a child to the ArrayList
    public void Child(Node childNode) {

        childNodes.add(childNode);
    }


    // method to work out the total cost, used to compare nodes
    public void Cost(int cost, int estCost) {

        this.totalCost = cost + estCost;
    }

    // method to call totalCost
    public int returnCost() {

        return totalCost;
    }

}