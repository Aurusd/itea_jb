package itea.lsn14.DZ_task12_Speed;

public class SumByThreads extends Thread {
    CurrSum sum;
    int cell;
    public SumByThreads(CurrSum sum, int cell) {
        this.sum = sum;
        this.cell = cell;
    }
    @Override
    public void run() {
        synchronized (sum) {
            sum.set(cell);
        }
    }
}
