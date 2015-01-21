package itea.lsn7.DZ_task22_Figures;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        Figure[] list = {new Rectangle(16.5), new Rectangle(21.1), new Circle(14.2),
                new Rectangle(18.5), new Rectangle(10.3), new Circle(20.2)};
        Arrays.sort(list);
        for (Figure h : list)
            System.out.println(h.getArea() + " (" + h.getClass().getSimpleName() + ")");
    }
}

class Figure implements Comparable {
    protected double area;
    public Figure() {}
    public double getArea() { return area; }
    @Override
    public int compareTo(Object another) {
        Figure h = (Figure) another;
        if (area < h.area)
            return -1;
        else if (area == h.area)
            return 0;
        else if (area > h.area)
            return 1;
        else
            return 0; // make compiler happy
    }
}

class Circle extends Figure {
    public Circle(double area) {
        this.area = area;
    }
    @Override
    public double getArea() {
        return area;
    }
}

class Rectangle extends Figure {
    public Rectangle(double area) {
        this.area = area;
    }
    @Override
    public double getArea() {
        return area;
    }
}