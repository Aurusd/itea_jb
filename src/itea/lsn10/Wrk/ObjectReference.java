package itea.lsn10.Wrk;

/**
 *
 */
public class ObjectReference {
    public static void main(String[] args) {
        //Object ref = new int[] {1, 2, 3};
        Object ref = new int[][] { {1, 2, 3}, {4, 5, 6} };
        System.out.println(intArrayToString(ref));
    }

    private static String intArrayToString(Object ref) {
        StringBuilder res = new StringBuilder("[");
        if (ref instanceof int[]) {
            int[] array = (int[]) ref;
            for (int i = 0; i < array.length; i++) {
                res.append(array[i]);
                if (i != array.length - 1) res.append(", ");
            }
        } else if (ref instanceof int[][]) {
            int[][] array = (int[][]) ref;
            for (int i = 0; i < array.length; i++) {
                res.append("[");
                for (int j = 0; j < array[i].length; j++) {
                    res.append(array[i][j]);
                    if (j != array[i].length - 1) res.append(", ");
                }
                res.append("]");
            }
        }
        res.append("]");
        return res.toString();
    }
}
