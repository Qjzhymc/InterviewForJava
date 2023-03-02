import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class removeElementInCollection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<=10; i++) {
            list.add(i);
        }
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            int num = iter.next();
            if (num % 2 == 0) {
                iter.remove();//用Iterator可以在遍历的过程中移除元素
            }
        }
        System.out.println(list);


    }
}
