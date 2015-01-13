package itea.lsn13.Wrk;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo2 {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<String, String>();
        m.put("1234", "abcd");
        m.put("9988", "abcd");
        m.put("1234", "bcde"); // !! значение затирается новым !!
        System.out.println(m); // {1234=bcde, 9988=abcd}
    }
}
