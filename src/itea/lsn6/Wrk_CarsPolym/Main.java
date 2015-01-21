package itea.lsn6.Wrk_CarsPolym;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Car {
    public String getName() {
          return "����������";
    }
}

class BMW extends Car {
    @Override
    public String getName() {
         return "BMW";
    }
}

class Lada extends Car {
    @Override
    public String getName() {
         return "Lada";
    }
}

class BMW_M extends BMW {
    @Override
    public String getName() {
         return super.getName() + "_M";
    }
}

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите целое число: ");
        String s = d.readLine();
        
        Car c = new Car();
        System.out.println(c.getName());
        
        if (s.equals("1"))
            c = new BMW();
        else if (s.equals("2"))
            c = new BMW_M();
        else
            c = new Lada();
        
        System.out.println(c.getName());
}

}
