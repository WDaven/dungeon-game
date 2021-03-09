package generators;
import java.util.Random;

public class Maze {

    private FourWayLinkedList fourWayLinkedList;

    public Maze() {    // constructor
        fourWayLinkedList = new FourWayLinkedList();
        // generating random room identifier 1-12 inclusive
        Random rand = new Random();
        int randRoomIdentifier = rand.nextInt(12) + 1;
        // setting head Node to room 1
        fourWayLinkedList.addRandToPath(fourWayLinkedList.getHead(), randRoomIdentifier, 0);
    }
    public void generateMaze() {
        Random rand = new Random();
        int randRoomIdentifier = rand.nextInt(12) + 1;
        while (fourWayLinkedList.getHighestPathCount() < 7) {
            fourWayLinkedList.addRandToPath(fourWayLinkedList.getHead(), randRoomIdentifier, 0);
        }
    }

}

