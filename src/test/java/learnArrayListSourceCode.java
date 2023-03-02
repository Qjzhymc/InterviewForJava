import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class learnArrayListSourceCode {




    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(78);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        Hashtable hashtable = new Hashtable();

        HashMap<String, String> map = new HashMap<>();

        TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num = o1.getAge() - o2.getAge();
                return Integer.compare(num, 0);
            }
        });
        treeMap.put(new Person("person1", 3), "person1");
        treeMap.put(new Person("person2", 18), "person2");
        treeMap.put(new Person("person3", 35), "person3");
        treeMap.put(new Person("person4", 16), "person4");
        treeMap.entrySet().stream().forEach(personStringEntry -> {
            System.out.println(personStringEntry.getValue());
        });

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
