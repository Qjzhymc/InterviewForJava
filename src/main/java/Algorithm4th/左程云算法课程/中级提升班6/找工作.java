package Algorithm4th.左程云算法课程.中级提升班6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class 找工作 {
    class Job{
        int hard;
        int money;
        Job(int h, int m) {
            hard = h;
            money = m;
        }

    }
    class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            //hard相同，钱多的放前面
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        }
    }
    /**
     *
     * @param job 给定的各种job
     * @param ability 每个人的能力值
     * @return 返回每个人应该找那份工作
     */
    int[] getMoneys(Job[] job, int[] ability) {
        Arrays.sort(job, new JobComparator());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(job[0].hard, job[0].money);
        Job pre = job[0];
        for (int i = 1;i<job.length;i++) {
            //i的工资高，一定要hard也高
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                pre = job[i];
                map.put(pre.hard, pre.money);
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0;i<ability.length;i++) {
            //返回小于或等于给定key的最大键，满足能力范围内的最大的key
            Integer key = map.floorKey(ability[i]);
            ans[i] = key != null ? map.get(key) : 0;
        }
        return ans;
    }
}
