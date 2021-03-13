package generators;
import java.util.Random;

public class Maze {
    class Node {
        int roomIdentifier;
        Node top;
        Node bottom;
        Node left;
        Node right;
        boolean isExit;

        Node(int roomIdentifier, boolean isExit) {
            this.roomIdentifier = roomIdentifier;
            top = null;
            bottom = null;
            left = null;
            right = null;
            this.isExit = isExit;
        }
    }

    public Maze() {    // constructor
        Node startNode = new Node(1, false);
        Node nodeOne = new Node(4, false);
        Node nodeTwo = new Node(3, false);
        Node nodeThree = new Node(5, false);
        Node nodeFour = new Node(2, false);
        Node nodeFive = new Node(8, false);
        Node nodeSix = new Node(6, false);
        Node nodeSeven = new Node(4, false);
        Node nodeEight = new Node(5, false);
        Node nodeNine = new Node(6, false);
        Node nodeTen = new Node(5, false);
        Node nodeEleven = new Node(5, false);
        Node nodeTwelve = new Node(7, false);
        Node nodeThirteen = new Node(6, false);
        Node nodeFourteen = new Node(10, false);
        Node nodeFifteen = new Node(7, false);
        Node nodeSixteen = new Node(9, false);
        Node nodeSeventeen = new Node(8, false);
        Node nodeEighteen = new Node(1, false);
        Node nodeExit = new Node(12, true);

        startNode.top = nodeOne;
        startNode.right = nodeTwo;
        startNode.bottom = nodeFour;
        startNode.left = nodeThree;

        nodeOne.top = nodeEight;
        nodeOne.right = nodeTwo;
        nodeOne.bottom = startNode;

        nodeTwo.top = nodeOne;
        nodeTwo.left = startNode;
        nodeTwo.right = nodeNine;

        nodeThree.right = startNode;
        nodeThree.bottom = nodeFour;
        nodeThree.left = nodeFive;

        nodeFour.top = startNode;
        nodeFour.bottom = nodeSix;
        nodeFour.left = nodeThree;

        nodeFive.right = nodeThree;
        nodeFive.bottom = nodeSeven;

        nodeSix.top = nodeFour;
        nodeSix.left = nodeSeven;

        nodeSeven.top = nodeFive;
        nodeSeven.bottom = nodeEleven;

        nodeEight.right = nodeTen;
        nodeEight.bottom = nodeOne;
        nodeEight.left = nodeFifteen;

        nodeNine.top = nodeTen;
        nodeNine.left = nodeTwo;

        nodeTen.left = nodeEight;
        nodeTen.right = nodeEleven;
        nodeTen.bottom = nodeNine;

        nodeEleven.right = nodeTen;
        nodeEleven.bottom = nodeTwelve;
        nodeEleven.left = nodeSeven;

        nodeTwelve.top = nodeEleven;
        nodeTwelve.right = nodeThirteen;

        nodeThirteen.left = nodeTwelve;
        nodeThirteen.top = nodeFourteen;

        nodeFourteen.bottom = nodeThirteen;

        nodeFifteen.top = nodeSixteen;
        nodeFifteen.right = nodeEight;

        nodeSixteen.left = nodeSeventeen;
        nodeSixteen.bottom = nodeFifteen;

        nodeSeventeen.right = nodeSixteen;
        nodeSeventeen.bottom = nodeEighteen;

        nodeEighteen.top = nodeSeventeen;

        Random random = new Random();
        int randExitRoom = random.nextInt(2);   // exit room can be connected to 14 or 18
        int randExitPath = random.nextInt(3);

        if (randExitRoom == 0) {    // room 18 is connected to exit ... right, bottom, left possible
            if (randExitPath == 0) {    // right exit
                nodeEighteen.right = nodeExit;
                nodeExit.left = nodeEighteen;
            } else if (randExitPath == 1) { // bottom exit
                nodeEighteen.bottom = nodeExit;
                nodeExit.top = nodeEighteen;
            } else {    // left exit
                nodeEighteen.left = nodeExit;
                nodeExit.right = nodeEighteen;
            }
        } else {    // room 14 is connected to exit ... top, right, left possible
            if (randExitPath == 0) {    // right exit
                nodeFourteen.right = nodeExit;
                nodeExit.left = nodeFourteen;
            } else if (randExitPath == 1) { // top exit
                nodeFourteen.top = nodeExit;
                nodeExit.bottom = nodeFourteen;
            } else {    // left exit
                nodeFourteen.left = nodeExit;
                nodeExit.right = nodeFourteen;
            }
        }

    }

}

