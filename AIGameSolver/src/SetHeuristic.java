// heuristic for A* search to estimate the cost to the goal
public class SetHeuristic {
    public static int mHeuristic(String initialBoard, String goalBoard) {
        int dist = 0; //initialising the dist variable
        int manhattan = 0; //initialising the manhattan variable


        // calculates the manhattan distance for every tile from its current to goal position
        for (int x = 0; x < goalBoard.length(); x += 1) {

            for (int y = 0; y < initialBoard.length(); y += 1) {

                if (initialBoard.charAt(y) == goalBoard.charAt(x)) { //if the number is the same, work out the manhattan distance
                    manhattan = Math.abs((x / 3) - (y / 3)) + Math.abs((x % 3) - (y % 3)); //formula to work out the manhattan distance
                                                                                            // using 3 as the board is 3x3
                    dist = dist + manhattan;

                }

            }
        }
        return dist;
    }
}
