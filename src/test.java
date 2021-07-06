import java.lang.String;

import java.util.*;

public class test {

    @Override
    public int hashCode() {
        return 1;
    }

//    public void show(String i) {
//        System.out.println("Show String");
//    }

//    public void show(Integer i) {
//        System.out.println("Show Integer");
//    }

    public void show(Object obj) { System.out.println("Show Object");}
    public static void main(String[] args) {
        HashMap<test, java.lang.String> map = new HashMap<>();
        test test1 = new test();
        test test2 = new test();
        test test3 = new test();
        test test4 = new test();

        map.put(test1, "Manvi");
        map.put(test2, "Manvi");
        map.put(test3, "Manvi1");
        map.put(test4, "Manvi11");

        // throw the error if you add StringBuffer in the treeSet as its not comparable.

//        TreeSet<StringBuffer> treeSet = new TreeSet<>();
//        StringBuffer sb1 = new StringBuffer("a");
//        StringBuffer sb2 = new StringBuffer("b");
//        StringBuffer sb3 = new StringBuffer("c");
//
//        treeSet.add(sb1);
//        treeSet.add(sb2);
//        treeSet.add(sb3);
//
//        System.out.println("treeset is "+  treeSet);

        List<Object> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();

        list1 = list2;


        System.out.println("size of map" +  map.size());

        int[] arr = {1, 2, 3, 4, 5};
        Arrays.stream(arr).map(item -> item * 5).forEach(System.out::println);

        String string = "Mainvi";
        System.out.println(string.chars().filter(ch -> ch == 'i').count());

        System.out.println("apple".compareTo("banana"));

        test1.show(null);  // null is a vaild value for all three types Object, String and Integer.
        // When String and Integer are present, then Java can't decide which one to call. So, throws the compilation error.
        // When object and string are present, Object is the super class of String, It calls the String method first.

        Integer iobj1 = 100;
        Integer iobj2 = 101;

        if(iobj1 == iobj2) {
            System.out.println("equal");
        } else {
            System.out.println("Not equal");
        }


    }
}
