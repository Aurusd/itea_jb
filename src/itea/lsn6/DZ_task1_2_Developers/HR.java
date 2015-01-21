package itea.lsn6.DZ_task1_2_Developers;

public class HR extends Person {

    protected int rank;

    public HR(String name, double basicSalary, int rank) {
        super(name, basicSalary);
        this.rank = rank;
    }

    @Override
    public double getSalary() {
        return basicSalary + (rank > 0 ? basicSalary * rank * 0.2 : 0);
    }
}