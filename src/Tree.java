import parcs.AM;
import parcs.AMInfo;
import parcs.channel;
import parcs.point;

import java.util.ArrayList;
import java.util.List;

public class Tree implements AM {

    public int getHeight(AMInfo info, Node root)
    {
        System.out.println("[" + root.getVertex() + "] Build started.");
        ArrayList<Node> nodes = new ArrayList<>();

        if (root.getLeft() != null) {
            nodes.add(root.getLeft());
        }

        if (root.getRight() != null) {
            nodes.add(root.getRight());
        }

        int height = 0;
        List<point> points = new ArrayList<>();
        List<channel> channels = new ArrayList<>();

        for (Node node: nodes) {
            point p = info.createPoint();
            channel c = p.createChannel();
            p.execute("Tree");
            c.write(node);
            points.add(p);
            channels.add(c);
        }

        for (channel c: channels) {
            height = Math.max(height, c.readInt());
            c.close();
        }
        for (point p: points) {
            p.delete();
        }

        System.out.printf("[%d] Build finished. = %d\n", root.getVertex(), height);
        return height + 1;
    }

    @Override
    public void run(AMInfo amInfo) {
        Node root = (Node)amInfo.parent.readObject();

        if (root == null) {
            amInfo.parent.write(0);
        } else {
            amInfo.parent.write(getHeight(amInfo, root));
        }
    }
}
