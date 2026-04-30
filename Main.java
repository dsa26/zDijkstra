public class Main {
    public static void main(String[] args) {
        PathFinder path = new PathFinder("./nodes.txt", "./edges.txt");
        path.findPath("San Francisco", "Las Vegas");
        // PriorityQueue queue = new PriorityQueue();
        // queue.enqueue(new Node("San Francisco", 0, null));
        // queue.enqueue(new Node("Las Vegas", 380, null));
        // queue.enqueue(new Node("Los Angeles", 320, null));
        // queue.enqueue(new Node("Las Vegas", 540, null));
        // System.out.println(queue.peek().name);
        // System.out.println(queue.dequeue().distance);
        // System.out.println(queue.peek().name);
        // System.out.println(queue.dequeue().distance);
        // System.out.println(queue.peek().name);
        // System.out.println(queue.dequeue().distance);
        // System.out.println(queue.peek().name);
        // System.out.println(queue.dequeue().distance);
    }
}
