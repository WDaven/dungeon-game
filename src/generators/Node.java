package generators;

public class Node {
    int roomIdentifier;
    Node top;
    Node bottom;
    Node left;
    Node right;
    boolean isExit;

    Node(int roomIdentifier) {
        this.roomIdentifier = roomIdentifier;
        top = null;
        bottom = null;
        left = null;
        right = null;
        isExit = false;
    }

    public Node getTop() {
        return top;
    }
    public Node getRight() {
        return right;
    }
    public Node getBottom() {
        return bottom;
    }
    public Node getLeft() {
        return left;
    }
    public void setTop(Node node) {
        top = node;
    }
    public void setRight(Node node) {
        right = node;
    }
    public void setBottom(Node node) {
        bottom = node;
    }
    public void setLeft(Node node) {
        left = node;
    }
}
