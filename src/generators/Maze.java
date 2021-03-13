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
        Node nodeEight = new Node(8, false);
        Node nodeNine = new Node(6, false);
        Node nodeTen = new Node(5, false);
        Node nodeEleven = new Node(5, false);
        Node nodeTwelve = new Node(7, false);
        Node nodeThirteen = new Node(6, false);
        Node nodeFourteen = new Node(10, false);

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
    }

}

