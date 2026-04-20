import java.util.Arrays;

public class PriorityQueue {
    private Node[] heap;

    public PriorityQueue() {
        this.heap = new Node[0];
    }

    public void enqueue(Node node) {
        Node[] temp = Arrays.copyOf(heap, heap.length + 1);
        int i = heap.length;
        temp[i] = node;
        while (parent(i) != -1 && temp[parent(i)].distance > node.distance) {
            temp[i] = temp[parent(i)];
            temp[parent(i)] = node;
            i = parent(i);
        }
        this.heap = temp;
    }

    public Node dequeue() {
        if (heap.length == 0)
            return null;
        Node ret = heap[0];
        heap[0] = heap[heap.length - 1];
        Node[] temp = Arrays.copyOf(heap, heap.length - 1);
        if (temp.length == 0) {
            this.heap = temp;
            return ret;
        }
        Node node = temp[0];
        int i = 0;
        while (smaller(temp, i) != -1 && node.distance > temp[smaller(temp, i)].distance) {
            temp[i] = temp[smaller(temp, i)];
            temp[smaller(temp, i)] = node;
            i = smaller(temp, i);
        }
        this.heap = temp;
        return ret;
    }

    public boolean contains(String name) {
        for (Node item : heap) {
            if (item.name.equals(name))
                return true;
        }

        return false;
    }

    public int[] getDistances(String name) {
        int[] current = new int[0];
        for (Node item : heap) {
            if (item.name.equals(name)) {
                current = Arrays.copyOf(current, current.length + 1);
                current[current.length - 1] = item.distance;
            }
        }
        return current;
    }

    public Node peek() {
        if (heap.length == 0)
            return null;
        return heap[0];
    }

    private int smaller(Node[] arr, int i) {
        if (child1(arr, i) == -1 && child2(arr, i) == -1)
            return -1;
        if (child2(arr, i) == -1)
            return child1(arr, i); // If child1 is -1 then child2 must be too

        if (arr[child1(arr, i)].distance > arr[child2(arr, i)].distance)
            return child2(arr, i);
        else
            return child1(arr, i);
    }

    private int parent(int i) {
        if (i == 0)
            return -1;
        return (i - 1) / 2;
    }

    private int child1(Node[] arr, int i) {
        if (2 * i + 1 >= arr.length)
            return -1;
        return 2 * i + 1;
    }

    private int child2(Node[] arr, int i) {
        if (2 * i + 2 >= arr.length)
            return -1;
        return 2 * i + 2;
    }
}