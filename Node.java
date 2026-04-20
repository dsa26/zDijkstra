public class Node {
    public String name;
    public int distance;
    public Node parent;

    public Node(String name, int distance, Node parent) {
        this.name = name;
        this.distance = distance;
        this.parent = parent;
    }
}
