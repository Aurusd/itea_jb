package itea.lsn6.DZ_task1_2_Developers;

public abstract class Person {

    protected String name;
    protected double basicSalary;
    protected int experience;

    public Person(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public abstract double getSalary();
}