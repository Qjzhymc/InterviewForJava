package Algorithm4th.剑指offer专项突破版;

import java.util.Map;
import java.util.TreeMap;

public class 五十八日程表 {
    class MyCalendar{
        TreeMap<Integer, Integer> events;

        MyCalendar(){
            events = new TreeMap<>();
        }

        boolean book(int start, int end) {
            Map.Entry<Integer, Integer> event = events.floorEntry(start);
            if (event != null && event.getValue() > start) {
                return false;
            }

            event = events.ceilingEntry(start);
            if (event != null && event.getKey() < end) {
                return false;
            }
            events.put(start, end);
            return true;
        }
    }
}
