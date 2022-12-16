public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина");
        Person vasya = new Person("Вася");
        Person masha = new Person("Маша");
        Person jane = new Person("Женя");
        Person ivan = new Person("Ваня");
        Person petr = new Person("Петя");
        GeoTree gt = new GeoTree();
        gt.parentAppend(irina, vasya);
        gt.parentAppend(irina, masha);
        gt.parentAppend(vasya, jane);
        gt.parentAppend(vasya, ivan);
        gt.parentAppend(petr, vasya);

        System.out.println("Братья/сестры гражданина " +vasya.fullName+":"+new Research(gt).searchSiblings(vasya));
        System.out.println("Родители гражданина " +vasya.fullName+ ":" +new Research(gt).searchParent(vasya));


    }

}