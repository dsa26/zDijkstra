import java.util.Arrays;

public class Map {
    private Node[][] map;
    private String[] key;

    public Map() {
        map = new Node[0][0];
        key = new String[0];
    }

    public void addNode(String node) {
        map = Arrays.copyOf(map, map.length + 1);
        map[map.length - 1] = new Node[0];
        key = Arrays.copyOf(key, key.length + 1);
        key[key.length - 1] = node;
    }

    public void addEdge(String one, String two, int distance) {
        if (findIndex(one) != -1 && findIndex(two) != -1) {
            Node[] oneArr = map[findIndex(one)];
            oneArr = Arrays.copyOf(oneArr, oneArr.length + 1);
            oneArr[oneArr.length - 1] = new Node(two, distance, null);
            map[findIndex(one)] = oneArr;

            Node[] twoArr = map[findIndex(two)];
            twoArr = Arrays.copyOf(twoArr, twoArr.length + 1);
            twoArr[twoArr.length - 1] = new Node(one, distance, null);
            map[findIndex(two)] = twoArr;
        }
    }

    public Node[] getNode(String node) {
        return map[findIndex(node)];
    }

    public void displayMap() {
        for (Node[] list : map) {
            for (Node node : list) {
                System.out.println("Node: " + node.name + " Distance: " + node.distance);
            }
            System.out.println("---------");
        }
    }

    public int getLength() {
        return map.length;
    }

    public int findIndex(String str) {
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(str))
                return i;
        }

        return -1;
    }
}