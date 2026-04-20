import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class PathFinder {
    private Map map;
    private int[] visited; // Decided to implement this to make it more efficient

    public PathFinder(String nodes, String edges) {
        this.map = new Map();
        readNodes(nodes, map);
        readEdges(edges, map);
        this.visited = new int[map.getLength()];
        Arrays.fill(visited, -1);
    }

    public void findPath(String start, String end) {
        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(new Node(start, 0, null));
        visited[map.findIndex(start)] = 0;
        while (queue.peek() != null) {
            if (queue.peek().name.equals(end)) {
                break;
            }
            Node next = queue.dequeue();
            System.out.println("Next: " + next.name + " Distance: " + next.distance);
            Node[] options = map.getNode(next.name);
            for (Node option : options) {
                if (visited[map.findIndex(option.name)] == -1
                        || (next.distance + option.distance) < visited[map.findIndex(option.name)]) {
                    queue.enqueue(new Node(option.name, next.distance + option.distance, next));
                    visited[map.findIndex(option.name)] = next.distance + option.distance;
                    System.out.println("Update: " + option.name + " Distance: " + (next.distance
                            + option.distance));
                } else {
                    System.out.println("No: " + option.name + " Old: " +
                            visited[map.findIndex(option.name)] + " New: "
                            + (next.distance + option.distance));
                }
            }
            System.out.println("----");
        }

        Node current = queue.dequeue();
        while (current != null) {
            System.out.println("Node: " + current.name + " Distance: " + current.distance);
            current = current.parent;
        }
    }

    private static void readEdges(String filePath, Map map) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                String[] split = line.split(";");
                map.addEdge(split[0], split[1], Integer.parseInt(split[2]));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void readNodes(String filePath, Map map) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                String[] split = line.split(";");
                map.addNode(split[0]);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
