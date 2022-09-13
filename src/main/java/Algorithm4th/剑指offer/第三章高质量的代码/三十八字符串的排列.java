package Algorithm4th.剑指offer.第三章高质量的代码;

import java.util.Arrays;
import java.util.LinkedList;

public class 三十八字符串的排列 {
    public static String[] permutation(String s) {
        LinkedList<String> res = new LinkedList<>();
        char[] x = s.toCharArray();
        for (char ch : x) {
            System.out.println(ch);
        }
        System.out.println(Arrays.toString(x));
        dfs(0, s.toCharArray(), res);
        String[] arr = new String[res.size()];
        int i = 0;
        for (String str : res) {
            arr[i++] = str;
        }
        return arr;
    }
    //index下标前面的都排好了，index下标该怎么选
    private static void dfs(int index, char[] s, LinkedList<String> res) {
        System.out.println(s.toString());
        if (index == s.length) {
            System.out.println(s.toString());
            res.add(new String(s.toString()));
        } else {
            for (int i = index; i<s.length; i++) {
                swap(s, i, index);
                dfs(index+1, s, res);
                swap(s, i, index);
            }
        }
    }
    private static void swap(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }

    public static void main(String[] args) {
        char[] arr = {'a','n','c'};
        System.out.println(String.valueOf(arr));
        String[] res = permutation("abc");
        for (String str: res) {
            System.out.println(str);
        }
    }
}
