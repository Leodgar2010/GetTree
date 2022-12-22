import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
   @Override
    public int compare(Person a, Person b) {
       if (a == b) {return 0; } else {return 1;}
    }
}


