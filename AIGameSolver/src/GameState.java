import java.util.ArrayList;
import java.util.List;

public class GameState {
    //Board states
    //Creating the game states as strings to remove having to convert them
    final static public String INITIAL_BOARD = "876543210";
    final static public String GOAL_BOARD = "012345678";

    // method containing a set of switch statements
    // adds to a list all GameStates that can be reached in a single move from the current GameState, based on the state and the number
    public static List<String> possibleMoves(String state) {
        List<String> list = new ArrayList<String>(); // creates an ArrayList to add all the statements to

        //Assigning variables to each character in the string based on their index
        char zero = state.charAt(0);
        char one = state.charAt(1);
        char two = state.charAt(2);
        char three = state.charAt(3);
        char four = state.charAt(4);
        char five = state.charAt(5);
        char six = state.charAt(6);
        char seven = state.charAt(7);
        char eight = state.charAt(8);

        switch (state.indexOf("0")) { // declares the state with an index of 0
            case 0: {
                //Zero is adjacent to 1 and 3
                //Therefore zero can be replaced by one and three, etc..
                list.add(state.replace(zero, '*').replace(one, zero).replace('*', one));
                list.add(state.replace(zero, '*').replace(three, zero).replace('*', three));
                break;
            }
            case 1: {
                //One is adjacent to 2, 4 and 0
                list.add(state.replace(one, '*').replace(zero, one).replace('*', zero));
                list.add(state.replace(one, '*').replace(two, one).replace('*', two));
                list.add(state.replace(one, '*').replace(four, one).replace('*', four));
                break;
            }
            case 2: {
                //Two is adjacent to 1 and 5
                list.add(state.replace(two, '*').replace(one, two).replace('*', one));
                list.add(state.replace(two, '*').replace(five, two).replace('*', five));
                break;
            }
            case 3: {
                //Three is adjacent to 0, 4 and 6
                list.add(state.replace(three, '*').replace(zero, three).replace('*', zero));
                list.add(state.replace(three, '*').replace(four, three).replace('*', four));
                list.add(state.replace(three, '*').replace(six, three).replace('*', six));
                break;
            }
            case 4: {
                //Four is adjacent to 1, 3, 5 and 7
                list.add(state.replace(four, '*').replace(one, four).replace('*', one));
                list.add(state.replace(four, '*').replace(three, four).replace('*', three));
                list.add(state.replace(four, '*').replace(five, four).replace('*', five));
                list.add(state.replace(four, '*').replace(seven, four).replace('*', seven));
                break;
            }
            case 5: {
                //Five is adjacent to 2, 4 and 8
                list.add(state.replace(five, '*').replace(two, five).replace('*', two));
                list.add(state.replace(five, '*').replace(four, five).replace('*', four));
                list.add(state.replace(five, '*').replace(eight, five).replace('*', eight));
                break;
            }
            case 6: {
                //Six is adjacent to 3 and 7
                list.add(state.replace(six, '*').replace(three, six).replace('*', three));
                list.add(state.replace(six, '*').replace(seven, six).replace('*', seven));
                break;

            }
            case 7: {
                //Seven is adjacent to 4, 6 and 8
                list.add(state.replace(seven, '*').replace(four, seven).replace('*', four));
                list.add(state.replace(seven, '*').replace(six, seven).replace('*', six));
                list.add(state.replace(seven, '*').replace(eight, seven).replace('*', eight));
                break;
            }
            case 8: {
                //Eight is adjacent to 5 and 7
                list.add(state.replace(eight, '*').replace(five, eight).replace('*', five));
                list.add(state.replace(eight, '*').replace(seven, eight).replace('*', seven));
                break;
            }
        }
        return list; // returning the list of possible moves
    }
}
