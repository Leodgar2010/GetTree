import java.util.ArrayList;

public class Research {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> tree;

    public ArrayList<Person> SearchBase(Person p, Relationship re) {
        ArrayList<Person> result = new ArrayList<>();
        for (Node t : tree) {
            if (t.p1 == p && t.re == re) {
                result.add(t.p2);
            }
        }return result;
    }
        public ArrayList<String> SearchSiblings(Person p) {

        ArrayList <Person> mask = SearchBase (p,Relationship.children);
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
    public ArrayList<String> SearchParent(Person p) {

        ArrayList <Person> mask = SearchBase (p,Relationship.children);
        System.out.println(mask);
        ArrayList<String> result = new ArrayList<>();
        for (Person x: mask) {
                     result.add(x.fullName);
                }


        return result;
    }
}


