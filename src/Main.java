import parcs.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        long start = System.nanoTime();
        task curTask = new task();
        curTask.addJarFile("Tree.jar");
        Node root = Node.buildFromFile(curTask.findFile("input"));

        AMInfo info = new AMInfo(curTask, null);
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("Tree");
        c.write(root);

        System.out.println("Waiting for result...");
        System.out.println("Result: " + c.readInt());

        c.close();
        p.delete();

        curTask.end();
        long end = System.nanoTime();
        System.out.printf("Time: %3.f ms\n", (end - start) / 1000.0);
    }
}
