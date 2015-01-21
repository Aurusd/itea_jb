package itea.lsn6.DZ_task1_2_Developers;

public class PresidentDeveloper extends Developer {  // )))))))

    public PresidentDeveloper(String name, double basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
        return (basicSalary * 8) + (experience > 0 ? basicSalary * experience * 0.1 : 0);
    }
}