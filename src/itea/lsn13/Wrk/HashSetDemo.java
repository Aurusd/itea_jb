package itea.lsn13.Wrk;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("111");
        hs.add("222");
        hs.add("111"); // !!!
        System.out.println(hs); //[222, 111]
    }
}
