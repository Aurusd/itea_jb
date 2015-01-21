package itea.lsn14.DZ_task12_Speed;

public class CurrSum {
    int sum;
    public CurrSum(int sum) {
        this.sum = sum;
    }
    public int get() {
        return sum;
    }
    public void set(int cell) {
        sum += cell;
    }
}
