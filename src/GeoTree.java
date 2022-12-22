import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Iterator;

public class GeoTree implements Output {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }


    public void parentAppend (Person parent, Person children) throws IOException {
        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
        outputToFile("tree.txt", tree);
    }


    @Override
    public void outputToFile(String filename, ArrayList n) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
       for (int i = 0; i < n.size(); i++) {
            fileWriter.write(String.valueOf(n.get(i)));
            fileWriter.write ("\n");
        }
        fileWriter.flush();
    }
}
