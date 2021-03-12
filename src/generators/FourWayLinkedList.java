package generators;

import java.util.Random;

public class FourWayLinkedList {
    private final Node head;
    private String[] directionsPossibleList = new String[4];
    private final int topDir = 0;
    private final int rightDir = 1;
    private final int bottomDir = 2;
    private final int leftDir = 3;
    private static int highestPathCount;

    public FourWayLinkedList() {
        head = new Node(1);
        highestPathCount = 0;
        directionsPossibleList[0] = "1, 2, 3, 4, 6, 7, 10";    // 0 row is top direction
        directionsPossibleList[1] = "1, 3, 4, 5, 7, 8, 11";    // 1 row is right direction
        directionsPossibleList[2] = "1, 2, 4, 5, 8, 9, 10";    // 2 row is bottom direction
        directionsPossibleList[3] = "1, 2, 3, 5, 9, 11";    // 3 row is left direction
    }

    public Node addRandToPath(Node curr, int roomIdentifier, int pathCount) {
        Random random = new Random();
        Node newNode = new Node(roomIdentifier);
        int pathToTake = random.nextInt(4);
        if (curr == null) {
            if (pathCount > highestPathCount) {
                highestPathCount = pathCount;
            } else if (highestPathCount == 7) {
                newNode.isExit = true;
            }
            return new Node(roomIdentifier);
        } else {
            if (directionsPossibleList[pathToTake].contains("" + roomIdentifier)) {
                if (pathToTake == topDir) {
                    curr.setTop(addRandToPath(curr.getTop(), roomIdentifier, pathCount++));
                } else if (pathToTake == rightDir) {
                    curr.setRight(addRandToPath(curr.getRight(), roomIdentifier, pathCount++));
                } else if (pathToTake == bottomDir) {
                    curr.setBottom(addRandToPath(curr.getBottom(), roomIdentifier, pathCount++));
                } else {
                    curr.setLeft(addRandToPath(curr.getLeft(), roomIdentifier, pathCount++));
                }
            }
            return curr;
        }
    }

    public int getHighestPathCount() {
        return highestPathCount;
    }

    public Node getHead() {
        return head;
    }
}
