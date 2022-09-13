package Algorithm4th.剑指offer专项突破版;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class 设计插入删除随机访问的容器 {
    HashMap<Integer, Integer> numToLocation;
    ArrayList<Integer> nums;
    设计插入删除随机访问的容器( ) {
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }
    boolean insert(int val) {
        if (numToLocation.containsKey(val)) {
            return false;
        }
        numToLocation.put(val, nums.size());
        nums.add(val);
        return true;
    }
    boolean remove(int val) {
        if (!numToLocation.containsKey(val)) {
            return false;
        }
        int location = numToLocation.get(val);
        numToLocation.put(nums.get(nums.size()-1), location);
        numToLocation.remove(val);

        nums.set(location, nums.get(nums.size()-1));
        nums.remove(nums.size()-1);
        return true;
    }
    int getRandom(){
        Random random = new Random();
        int r = random.nextInt(nums.size());
        return nums.get(r);
    }
}
