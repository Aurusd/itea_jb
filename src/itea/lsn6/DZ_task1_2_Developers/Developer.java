package itea.lsn6.DZ_task1_2_Developers;

public abstract class Developer extends Person {

	public Developer(String name, double basicSalary, int experience) {
		super(name, basicSalary);
		this.experience = experience;
	}
}