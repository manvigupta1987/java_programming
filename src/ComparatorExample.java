import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class student {
    int rollno;
    String name, address;

    public student(int rollno, String name, String address) {
        this.rollno = rollno;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class sortByRollNo implements Comparator<student> {

    @Override
    public int compare(student o1, student o2) {
        return o1.rollno - o2.rollno;
    }
}

class sortByName implements Comparator<student> {

    @Override
    public int compare(student o1, student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class ComparatorExample {

    public static void main(String[] args) {
        ArrayList<student> ar = new ArrayList<student>();
        ar.add(new student(111, "bbbb", "london"));
        ar.add(new student(131, "aaaa", "nyc"));
        ar.add(new student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new sortByRollNo());

        System.out.println("\nSorted by rollno");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new sortByName());

        System.out.println("\nSorted by name");
        for (int i = 0; i < ar.size(); i++)
            System.out.println(ar.get(i));
    }
}
