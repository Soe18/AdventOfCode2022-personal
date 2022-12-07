package SeventhDay;

import java.util.ArrayList;

public class Node {
    private String name;
    private boolean isDir;
    private int size;
    private ArrayList<Node> childs;
    private Node parent;

    public Node() {}

    public Node(String name, boolean isDir, int size, Node parent) {
        this.name = name;
        this.isDir = isDir;
        this.size = size;
        this.parent = parent;
        childs = new ArrayList<>();
    }

    public Node(String name, boolean isDir, Node parent) {
        this.name = name;
        this.isDir = isDir;
        this.parent = parent;
        childs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public boolean isDir() {
        return isDir;
    }
    public int getSize() {
        return size;
    }
    public Node getParent() { return parent; }
    public ArrayList<Node> getChilds() { return childs; }

    public Node getChildByName(String name) {
        Node result = new Node();
        for (Node child: childs) {
            if (child.getName().equalsIgnoreCase(name))
                result = child;
        }
        return result;
    }

    public void createNewChild(Node e) {
        if (this.isDir()) childs.add(e);
    }

    public void findTotalSize() {
        for (Node child: childs) {
            if (child.isDir()) {
                child.findTotalSize();
            }
            this.size += child.getSize();
        }
    }

    // Custom classes just for Advent Of Code
    public int numbersDirWithLessThan100000() {
        int ct = 0;
        for (Node child: childs) {
            if (child.isDir()) {
                ct += child.numbersDirWithLessThan100000();
                if (child.getSize() <= 100000) {
                    ct += child.getSize();
                }
            }
        }
        return ct;
    }

    @Override
    public String toString() {
        String parentName;
        if (parent == null) parentName = null;
        else parentName = this.getParent().getName();
        return "Node{" +
                "name='" + name + '\'' +
                ", isDir=" + isDir +
                ", size=" + size +
                ", childs=" + childs +
                ", parent=" + parentName +
                '}';
    }

    // Test
    public static void main(String[] args) {
        Node tree = new Node("/", true, null);
        tree.createNewChild(new Node("b", true, tree));
        tree.getChildByName("b").createNewChild(new Node("a.png", false, 100, tree.getChildByName("b")));
        tree.createNewChild(new Node("c.txt", false, 12309, tree));
        //System.out.println(tree);

        Node child = tree.getChildByName("b");
        child.createNewChild(new Node("d", true, child));
        System.out.println(child);
        System.out.println(tree.getChildByName("b"));
    }
}
