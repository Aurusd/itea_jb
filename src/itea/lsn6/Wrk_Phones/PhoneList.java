package itea.lsn6.Wrk_Phones;

public class PhoneList {
    private Phone[] list = new Phone[100];
    private int p = 0;

    public void add(Phone s) {
        list[p++] = s;
    }

    public Phone get(int n) {
        return list[n];
    }

    public int findNumber(String name) {
        for (int i = 0; i < p; i++) {
            if (list[i].getNumber().equalsIgnoreCase(name))
                return i;
        }
        return -1;
    }

    public int getListLength() {
        return p;
    }
}