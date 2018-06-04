import java.io.File;
import java.io.Serializable;
import java.util.Scanner;

public class Node implements Serializable
{

    private int vertex;

    private Node left, right;

    public Node(int v)
    {
        this.vertex = v;
        this.left = this.right = null;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }

    public int getVertex() {
        return vertex;
    }

    public boolean addLeftChild(Node left)
    {
        if (this.getLeft() != null) {
            return false;
        }

        this.left = left;

        return true;
    }

    public boolean addRightChild(Node right)
    {
        if (this.getRight() != null) {
            return false;
        }

        this.right = right;

        return true;
    }

    public static Node buildFromFile(String filename) throws Exception
    {
        Scanner reader = new Scanner(new File(filename));
        int size = reader.nextInt();
        Node[] nodes = new Node[size];

        nodes[0] = new Node(0);

        for (int i = 1; i < size; i++) {
            int parent = reader.nextInt();
            String child = reader.next();
            int vertex = reader.nextInt();

            System.out.printf("%d %d %s\n", parent, vertex, child);

            if (nodes[vertex] == null) {
                nodes[vertex] = new Node(vertex);
            }

            if (child.compareTo("left") == 0) {
                nodes[parent].addLeftChild(nodes[vertex]);
            } else {
                nodes[parent].addRightChild(nodes[vertex]);
            }
        }

        return nodes[0];
    }
}
