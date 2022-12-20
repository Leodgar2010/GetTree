import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Research implements Output {
    ArrayList<Node> tree;
    ArrayList<String> result = new ArrayList<>();

   PersonComparator personComparator = new PersonComparator();



    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<Person> searchBase(Person p, Relationship re) {
        ArrayList<Person> result = new ArrayList<>();
        Iterator<Node> iterGeoTree = tree.iterator();
        while (iterGeoTree.hasNext()) {
            Node temp = iterGeoTree.next();
            if (temp.p1 == p && temp.re == re) {
                result.add(temp.p2);
            }
        }
        return result;
    }


    public ArrayList<String> searchSiblings(Person p) throws IOException {
        for (Person x : searchBase(p, Relationship.children)) {
            Iterator<Node> iterGeoTree = tree.iterator();
            while (iterGeoTree.hasNext()) {
                Node temp = iterGeoTree.next();
                if (temp.p2 == x && !result.contains(temp.p1.fullName) && personComparator.compare(temp.p1, p)!=0){
                   result.add(temp.p1.fullName);
                }
            }
            outputToFile("ResultSibling.txt", result);

        }return result;
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


