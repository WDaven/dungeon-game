package generators;
import javafx.scene.image.Image;
import scenes.*;

import java.util.Random;

public class Maze {
    private static Random random;
    private static Node curr;
    private static int randExitRoom;
    private static boolean randExitRoomSet;
    private static Player player = new Player(100);

    //getters
    public static Node getCurr() {
        return curr;
    }

    public static Player getPlayer() {
        return player;
    }
    //setters
    public static void setRandExitRoomSet(boolean randExitRoomSet) {
        Maze.randExitRoomSet = randExitRoomSet;
    }

    public static void setRandExitRoom(int randExitRoom) {
        Maze.randExitRoom = randExitRoom;
    }

    public static void setCurr(Node curr) {
        Maze.curr = curr;
    }

    //Node inner class
    public class Node {
        private int roomIdentifier;
        private Node top;
        private Node bottom;
        private Node left;
        private Node right;
        private Image imageBkgd;
        private boolean isExit;
        private int roomNum;
        private MonsterParent monster;
        private boolean isVisited;
        private String dropItem;
        private boolean isChallenge;


        Node(int roomIdentifier, boolean isExit, int roomNum,
             MonsterParent monster, String dropItem, boolean isChallenge) {
            this.roomIdentifier = roomIdentifier;
            top = null;
            bottom = null;
            left = null;
            right = null;
            imageBkgd = null;
            this.isExit = isExit;
            this.roomNum = roomNum;
            this.monster = monster;
            isVisited = false;
            this.dropItem = dropItem;
            this.isChallenge = isChallenge;

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
        public boolean getIsVisted() {
            return isVisited;
        }
        public void setIsVisted(boolean isVisited) {
            this.isVisited = isVisited;
        }
        public MonsterParent getMonster() {
            return monster;
        }
        public String getDropItem() {
            return dropItem;
        }
        public boolean getIsChallenge() {
            return isChallenge;
        }
        public void setIsChallenge(boolean isChallenge) {
            this.isChallenge = isChallenge;
        }
    }

    public Maze() {    // constructor
        Node startNode = new Node(1, false, 0, new MonsterBlue(true), "dagger", false);
        startNode.setIsVisted(true);
        Node nodeOne = new Node(4, false, 1, new MonsterBlue(), "health potion", false);
        Node nodeTwo = new Node(3, false, 2, new MonsterGreen(), "great sword", false);
        Node nodeThree = new Node(5, false, 3, new MonsterRed(), "sword", false);
        Node nodeFour = new Node(2, false, 4, new MonsterBlue(), "crystal", true);
        Node nodeFive = new Node(8, false, 5, new MonsterRed(), "health potion", false);
        Node nodeSix = new Node(6, false, 6, new MonsterGreen(), "attack potion", false);
        Node nodeSeven = new Node(4, false, 7, new MonsterGreen(), "crystal", true);
        Node nodeEight = new Node(5, false, 8, new MonsterGreen(), "sword", false);
        Node nodeNine = new Node(6, false, 9, new MonsterBlue(), "health potion", false);
        Node nodeTen = new Node(5, false, 10, new MonsterRed(), "dagger", false);
        Node nodeEleven = new Node(5, false, 11, new MonsterBlue(), "attack potion", false);
        Node nodeTwelve = new Node(7, false, 12, new MonsterGreen(), "health potion", false);
        Node nodeThirteen = new Node(6, false, 13, new MonsterBlue(), "dagger", false);
        Node nodeFourteen = new Node(1, false, 14, new MonsterRed(), "attack potion", false);
        Node nodeFifteen = new Node(7, false, 15, new MonsterGreen(), "attack potion", false);
        Node nodeSixteen = new Node(9, false, 16, new MonsterBlue(), "crystal", false);
        Node nodeSeventeen = new Node(8, false, 17, new MonsterGreen(), "dagger", false);
        Node nodeEighteen = new Node(1, false, 18, new MonsterGreen(), "sword", false);
        Node nodeExit = new Node(12, true, -1, new MonsterBlue(), "health potion", false);

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
        if (!randExitRoomSet) {
            randExitRoom = random.nextInt(6);   // exit room can be connected to 14 or 18
        }
        // room 18 is connected to exit ... right, bottom, left possible
        if (randExitRoom == 0) {    // right exit
            nodeEighteen.right = nodeExit;
            nodeExit.left = nodeEighteen;
        } else if (randExitRoom == 1) { // bottom exit
            nodeEighteen.bottom = nodeExit;
            nodeExit.top = nodeEighteen;
        } else if (randExitRoom == 2) {    // left exit
            nodeEighteen.left = nodeExit;
            nodeExit.right = nodeEighteen;
        } else if (randExitRoom == 3) {    //ROOM 14// right exit
            nodeFourteen.right = nodeExit;
            nodeExit.left = nodeFourteen;
        } else if (randExitRoom == 4) { // top exit
            nodeFourteen.top = nodeExit;
            nodeExit.bottom = nodeFourteen;
        } else {    // left exit
            nodeFourteen.left = nodeExit;
            nodeExit.right = nodeFourteen;
        }

        curr = startNode;
    }
}