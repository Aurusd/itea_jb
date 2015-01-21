package itea.lsn10.Wrk;

import java.util.Date;

/**
 *
 */
public class ObjectMethods {
    public static void main(String[] args) {
        Date[] a = { new Date(12345) };
        Date[] b = { new Date(12345) };
        Date[] c = a;
        System.out.println(a[0] == b[0]);   //false
        System.out.println(a == c);         //true

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());

        System.out.println("How equals() is implemented");
        System.out.println(a.equals(c));    //true
        System.out.println(a.equals(b));    //false !!!

        System.out.println("How hashCode() is implemented");
        System.out.println(a.hashCode());   //2085857771
        System.out.println(b.hashCode());   //248609774
        System.out.println(a[0].hashCode());//12345
        System.out.println(b[0].hashCode());//12345

        System.out.println("How clone() is implemented");
        c = a.clone();
        System.out.println(a == c);         //false
        System.out.println(a[0] == c[0]);   //true !!!

        System.out.println(a.getClass().getName()); /*
        Type descriptor:
          [Ljava.util.Date;
          [ - array
          L - long name (I - int, D - double, L - <some.name>; )
        */


    }
}
