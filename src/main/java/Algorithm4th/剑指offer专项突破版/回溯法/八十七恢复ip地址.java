package Algorithm4th.剑指offer专项突破版.回溯法;

import java.util.LinkedList;
import java.util.List;

public class 八十七恢复ip地址 {
    List<String> restoreIpAddress(String s) {
        List<String> result = new LinkedList<>();
        helper(s, 0, 0, "", "", result);
        return result;
    }
    void helper(String s, int i, int segIndex, String seg, String ip, List<String> result) {
        if (i==s.length() && segIndex == 3 && isValid(seg)) {
            result.add(ip + seg);
        } else if (i<s.length() && segIndex<=3) {
            char ch = s.charAt(i);
            if (isValid(seg+ch)) {
                helper(s, i+1, segIndex, seg+ch, ip, result);
            }
            if (seg.length() > 0 && segIndex<3) {
                helper(s, i+1, segIndex+1, ch+"", ip+seg+".", result);
            }
        }
    }
    boolean isValid(String seg) {
        return Integer.valueOf(seg) < 256 && (seg.equals("0") || seg.charAt(0) != '0');
    }
}
