import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Research implements Output {
    ArrayList<Node> tree;
    ArrayList<String> result = new ArrayList<>();

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<Person> searchBase(Person p, Relationship re) {
        ArrayList<Person> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.p1 == p && t.re == re) {
                result.add(t.p2);
            }
        }
        return result;
    }


    public ArrayList<String> searchSiblings(Person p) throws IOException {
        for (Person x : searchBase(p, Relationship.children)) {
            for (Node t : tree) {
                if (t.p2 == x && !result.contains(t.p1.fullName) && t.p1 != p) {
                    result.add(t.p1.fullName);
                }
            }
        }
        outputToFile("ResultSibling.txt", result);
        return result;
    }

    public ArrayList<String> searchParent(Person p) throws IOException {
        for (Person x : searchBase(p, Relationship.children)) {
            result.add(x.fullName);
        }
        outputToFile("ResultParent.txt", result);
        return result;
    }

    @Override
    public void outputToFile(String filename, ArrayList n) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        fileWriter.write(String.valueOf(n));
        fileWriter.flush();
    }
}


