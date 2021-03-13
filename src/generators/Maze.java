package generators;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.Random;

public class Maze {
    private static Random random;
    public class Node {
        int roomIdentifier;
        Node top;
        Node bottom;
        Node left;
        Node right;
        Image imageBkgd;
        boolean isExit;
        int roomNum;

        Node (int roomIdentifier, boolean isExit, int roomNum) {
            this.roomIdentifier = roomIdentifier;
            top = null;
            bottom = null;
            left = null;
            right = null;
            imageBkgd = null;
            this.isExit = isExit;
            this.roomNum = roomNum;
        }

        public Node getRight() {
            return right;
        }
        public Node getTop() {
            return top;
        }
        public Node getLeft() {
            return left;
        }
        public Node getBottom() {
            return bottom;
        }
        public Image getImageBkgd() {
            return imageBkgd;
        }
        public boolean getIsExit() {
            return isExit;
        }
        public int getRoomIdentifier() {
            return roomIdentifier;
        }
        public int getRoomNum() {
            return roomNum;
        }
    }
    private static Node curr;
    public Maze() {    // constructor
        Node startNode = new Node(1, false,0);
        Node nodeOne = new Node(4, false, 1);
        Node nodeTwo = new Node(3, false, 2);
        Node nodeThree = new Node(5, false, 3);
        Node nodeFour = new Node(2, false, 4);
        Node nodeFive = new Node(8, false, 5);
        Node nodeSix = new Node(6, false, 6);
        Node nodeSeven = new Node(4, false, 7);
        Node nodeEight = new Node(5, false, 8);
        Node nodeNine = new Node(6, false, 9);
        Node nodeTen = new Node(5, false, 10);
        Node nodeEleven = new Node(5, false, 11);
        Node nodeTwelve = new Node(7, false, 12);
        Node nodeThirteen = new Node(6, false, 13);
        Node nodeFourteen = new Node(1, false, 14);
        Node nodeFifteen = new Node(7, false, 15);
        Node nodeSixteen = new Node(9, false, 16);
        Node nodeSeventeen = new Node(8, false, 17);
        Node nodeEighteen = new Node(1, false, 18);
        Node nodeExit = new Node(12, true, -1);

        startNode.top = nodeOne;
        startNode.right = nodeTwo;
        startNode.bottom = nodeFour;
        startNode.left = nodeThree;
        startNode.imageBkgd = new Image("/mazeroomstart.png");


        nodeOne.top = nodeEight;
        nodeOne.right = nodeTwo;
        nodeOne.bottom = startNode;
        nodeOne.imageBkgd = new Image("/mazeroom1.png");

        nodeTwo.top = nodeOne;
        nodeTwo.left = startNode;
        nodeTwo.right = nodeNine;
        nodeTwo.imageBkgd = new Image("/mazeroom2.png");

        nodeThree.right = startNode;
        nodeThree.bottom = nodeFour;
        nodeThree.left = nodeFive;
        nodeThree.imageBkgd = new Image("/mazeroom3.png");

        nodeFour.top = startNode;
        nodeFour.bottom = nodeSix;
        nodeFour.left = nodeThree;
        nodeFour.imageBkgd = new Image("/mazeroom4.png");

        nodeFive.right = nodeThree;
        nodeFive.bottom = nodeSeven;
        nodeFive.imageBkgd = new Image("/mazeroom5.png");

        nodeSix.top = nodeFour;
        nodeSix.left = nodeSeven;
        nodeSix.imageBkgd = new Image("/mazeroom6.png");

        nodeSeven.top = nodeFive;
        nodeSeven.bottom = nodeEleven;
        nodeSeven.right = nodeSix;
        nodeSeven.imageBkgd = new Image("/mazeroom7.png");

        nodeEight.right = nodeTen;
        nodeEight.bottom = nodeOne;
        nodeEight.left = nodeFifteen;
        nodeEight.imageBkgd = new Image("/mazeroom8.png");

        nodeNine.top = nodeTen;
        nodeNine.left = nodeTwo;
        nodeNine.imageBkgd = new Image("/mazeroom9.png");

        nodeTen.left = nodeEight;
        nodeTen.right = nodeEleven;
        nodeTen.bottom = nodeNine;
        nodeTen.imageBkgd = new Image("/mazeroom10.png");

        nodeEleven.right = nodeTen;
        nodeEleven.bottom = nodeTwelve;
        nodeEleven.left = nodeSeven;
        nodeEleven.imageBkgd = new Image("/mazeroom11.png");

        nodeTwelve.top = nodeEleven;
        nodeTwelve.right = nodeThirteen;
        nodeTwelve.imageBkgd = new Image("/mazeroom12.png");

        nodeThirteen.left = nodeTwelve;
        nodeThirteen.top = nodeFourteen;
        nodeThirteen.imageBkgd = new Image("/mazeroom13.png");

        nodeFourteen.bottom = nodeThirteen;
        nodeFourteen.imageBkgd = new Image("/mazeroom14.png");

        nodeFifteen.top = nodeSixteen;
        nodeFifteen.right = nodeEight;
        nodeFifteen.imageBkgd = new Image("/mazeroom15.png");

        nodeSixteen.left = nodeSeventeen;
        nodeSixteen.bottom = nodeFifteen;
        nodeSixteen.imageBkgd = new Image("/mazeroom16.png");

        nodeSeventeen.right = nodeSixteen;
        nodeSeventeen.bottom = nodeEighteen;
        nodeSeventeen.imageBkgd = new Image("/mazeroom17.png");

        nodeEighteen.top = nodeSeventeen;
        nodeEighteen.imageBkgd = new Image("/mazeroom18.png");

        nodeExit.imageBkgd = new Image("/mazeroomend.png");
        random = new Random();
        int randExitRoom = random.nextInt(6);   // exit room can be connected to 14 or 18
            // room 18 is connected to exit ... right, bottom, left possible
            if (randExitRoom == 0) {    // right exit
                nodeEighteen.right = nodeExit;
                nodeExit.left = nodeEighteen;
            } else if (randExitRoom == 1) { // bottom exit
                nodeEighteen.bottom = nodeExit;
                nodeExit.top = nodeEighteen;
            } else if (randExitRoom == 2){    // left exit
                nodeEighteen.left = nodeExit;
                nodeExit.right = nodeEighteen;
                // room 14 is connected to exit ... top, right, left possible
            } else if (randExitRoom == 3) {    // right exit
                nodeFourteen.right = nodeExit;
                nodeExit.left = nodeFourteen;
            } else if (randExitRoom == 4) { // top exit
                nodeFourteen.top = nodeExit;
                nodeExit.bottom = nodeFourteen;
            } else {    // left exit
                nodeFourteen.left = nodeExit;
                nodeExit.right = nodeFourteen;
            }

//        int randExitPath = random.nextInt(3);

//        if (randExitRoom == 0) {    // room 18 is connected to exit ... right, bottom, left possible
//            if (randExitPath == 0) {    // right exit
//                nodeEighteen.right = nodeExit;
//                nodeExit.left = nodeEighteen;
//            } else if (randExitPath == 1) { // bottom exit
//                nodeEighteen.bottom = nodeExit;
//                nodeExit.top = nodeEighteen;
//            } else {    // left exit
//                nodeEighteen.left = nodeExit;
//                nodeExit.right = nodeEighteen;
//            }
//        } else {    // room 14 is connected to exit ... top, right, left possible
//            if (randExitPath == 0) {    // right exit
//                nodeFourteen.right = nodeExit;
//                nodeExit.left = nodeFourteen;
//            } else if (randExitPath == 1) { // top exit
//                nodeFourteen.top = nodeExit;
//                nodeExit.bottom = nodeFourteen;
//            } else {    // left exit
//                nodeFourteen.left = nodeExit;
//                nodeExit.right = nodeFourteen;
//            }
//        }
        curr = startNode;
    }
    //getters
    public static Node getCurr() {
        return curr;
    }
//    public static Button getExitLeft() {
//        return exitLeft;
//    }
//    public static Button getExitRight() {
//        return exitRight;
//    }
//    public static Button getExitTop() {
//        return exitTop;
//    }
//    public static Button getExitBottom() {
//        return exitBottom;
    //}
}

