import java.util.*;

public class collectionRemove {

    public static void main(String[] args) {
        String[] s = new String[]{
                "dog","lazy","a","over","jumps"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);

        System.out.println(list);

        s = list.toArray(new String[0]);
        for (String str : s) {
            System.out.println(str + " ");
        }

    }
}
