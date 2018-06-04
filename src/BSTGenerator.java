import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class BSTGenerator {
    public static void main(String[] args) throws Exception
    {
        int size;
        int vertex = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        PrintWriter writer = new PrintWriter("input");

        if (args.length == 1) {
            size = Integer.parseInt(args[0]);
        } else {
            Scanner scanner = new Scanner(System.in);
            size = scanner.nextInt();
        }

        writer.printf("%d\n", size);
        queue.add(vertex);
        vertex++;
        size--;

        while (size > 0) {
            int caseNum = new Random().nextInt(100);
            int currentVertex = queue.poll();

            if (caseNum >= 50) {
                caseNum = 2;
            } else if (caseNum >= 25) {
                caseNum = 1;
            } else {
                caseNum = 0;
            }

            switch (caseNum) {
                case 0:
                    writer.printf("%d  left %d\n", currentVertex, vertex);
                    queue.add(vertex);
                    size--;
                    vertex++;
                    break;
                case 1:
                    writer.printf("%d  right %d\n", currentVertex, vertex);
                    queue.add(vertex);
                    size--;
                    vertex++;
                    break;
                case 2:
                    writer.printf("%d  left %d\n", currentVertex, vertex);
                    queue.add(vertex);
                    size--;
                    vertex++;
                    if (size > 0) {
                        writer.printf("%d  right %d\n", currentVertex, vertex);
                        queue.add(vertex);
                        size--;
                        vertex++;
                    }
                    break;
                default:
                    break;
            }
        }
        writer.close();
    }
}
