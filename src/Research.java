import java.util.ArrayList;

public class Research {
    ArrayList<Node> tree;

    public Research(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<Person> searchBase(Person p, Relationship re) {
        ArrayList<Person> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.p1 == p && t.re == re) {
                result.add(t.p2);
            }
        }return result;
    }
        public ArrayList<String> searchSiblings(Person p) {

        ArrayList <Person> mask = searchBase (p,Relationship.children);
        System.out.println(mask);
        ArrayList<String> result = new ArrayList<>();
            for (Person x: mask) {
                for (Node t : tree) {
                    if (t.p2 == x && !result.contains(t.p1.fullName)&& t.p1!=p) {
                        result.add(t.p1.fullName);
                    }
                }
            }
        return result;
    }
    public ArrayList<String> searchParent(Person p) {

        ArrayList <Person> mask = searchBase (p,Relationship.children);
        System.out.println(mask);
        ArrayList<String> result = new ArrayList<>();
        for (Person x: mask) {
                     result.add(x.fullName);
                }


        return result;
    }
}


