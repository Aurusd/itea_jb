package itea.lsn13.Wrk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Человек1");
        map.put(2, "Человек2");
        map.put(null, "Человек3");
// 1.
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry : set)
            System.out.println(entry.getKey() + " = " + entry.getValue());
// 2.
        Set<Integer> set2 = map.keySet();
        for (Integer key : set2)
            System.out.println(map.get(key));
// 3.
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}
