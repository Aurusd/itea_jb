package itea.lsn6.DZ_task1_2_Developers;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Developer[] list = new Developer[50];
		Random r = new Random();
		for (int i = 0; i < list.length; i++) {
			switch (r.nextInt(4)) {
				case 0:
					list[i] = new JuniorDeveloper("Jun" + i, 700, r.nextInt(3));
					break;
				case 1:
					list[i] = new SeniorDeveloper("Sen" + i, 700, r.nextInt(6));
					break;
				case 2:
					list[i] = new TeamLeadDeveloper("TL" + i, 700, r.nextInt(12));
					break;
				case 3:
					list[i] = new PresidentDeveloper("Pr" + i, 700, r.nextInt(25));
					break;
				default:
					list[i] = new JuniorDeveloper("Jun" + i, 700, r.nextInt(2));
					break;
			}
		}
		/*Developer[] list = {
				new JuniorDeveloper("Mike", 500, 0),
				new JuniorDeveloper("Dima", 500, 1),
				new JuniorDeveloper("Vova", 500, 2),
				new SeniorDeveloper("Jack", 500, 5),
				new TeamLeadDeveloper("Robby", 500, 7),
				new PresidentDeveloper("Вася", 500, 12),
		};
		StringBuilder sb;
		for (Developer d : list) {
			sb = new StringBuilder() // !!!
				.append(d.getName())
				.append(": ")
				.append(d.getBasicSalary())
				.append(" -> ")
				.append(d.getSalary());
			
			System.out.println(sb.toString());
		}*/
		StringBuilder sb;
		for (Developer d : list) {
			if (d instanceof SeniorDeveloper && d.getSalary() > 1500) {
				sb = new StringBuilder()
						.append(d.getClass().getSimpleName())
						.append(" with name ")
						.append(d.getName())
						.append(": ")
						.append(d.getBasicSalary())
						.append(" -> ")
						.append(d.getSalary());

				System.out.println(sb.toString());
			}
		}
		System.out.println("----------");

		HR hr = new HR("Оля", 400, 4);
		sb = new StringBuilder()
				.append(hr.getName())
				.append(": ")
				.append(hr.getBasicSalary())
				.append(" -> ")
				.append(hr.getSalary());

		System.out.println(sb.toString());
		System.out.println("----------");

		int j = 0, s = 0, t = 0, p = 0;
		for (Developer d : list) { //узнаём, сколько каких девелоперов в списке
			if (d instanceof JuniorDeveloper)
				j++;
			else
			if (d instanceof SeniorDeveloper)
				s++;
			else
			if (d instanceof TeamLeadDeveloper)
				t++;
			else
				p++;
		}
		Developer[] listJ = new Developer[j];
		Developer[] listS = new Developer[s];
		Developer[] listT = new Developer[t];
		Developer[] listP = new Developer[p];
		j = s = t = p = 0;
		for (Developer d : list) {
			if (d instanceof JuniorDeveloper)
				listJ[j++] = d;
			else
			if (d instanceof SeniorDeveloper)
				listS[s++] = d;
			else
			if (d instanceof TeamLeadDeveloper)
				listT[t++] = d;
			else
				listP[p++] = d;
		}
		System.out.println("Список Junior-ов");
		toConsole(listJ);
		System.out.println("----------");
		System.out.println("Список Senior-ов");
		toConsole(listS);
		System.out.println("----------");
		System.out.println("Список TeamLead-ов");
		toConsole(listT);
		System.out.println("----------");
		System.out.println("Список President-ов");
		toConsole(listP);
	}

	static void toConsole(Developer[] lst) {
		StringBuilder sb;
		for (Developer d : lst) {
			sb = new StringBuilder() // !!!
					.append(d.getClass().getSimpleName())
					.append(" with name ")
					.append(d.getName())
					.append(": ")
					.append(d.getBasicSalary())
					.append(" -> ")
					.append(d.getSalary());
			System.out.println(sb.toString());
		}
	}
}