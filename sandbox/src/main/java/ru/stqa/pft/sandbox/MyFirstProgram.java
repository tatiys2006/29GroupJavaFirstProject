package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static void main(String[] args) {
		hello("world");
      hello("user");

      Square s = new Square(5);

      System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));

      Rectangle r = new Rectangle(4,6);

      System.out.println("Площадь квадрата со сторонами " + r.a + " и " + r.b + " = " + area(r));

      Point p = new Point(4,5,6,7);
      System.out.println("Distance between " + p.x1 + "." + p.y1 + " and " + p.x2 + "." + p.y2 + "are" + distance(p));

  }

    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody + "!");
    }

    public static double area(Square s){
        return s.l * s.l;
    }

    public static double area(Rectangle r) {
        return r.a * r.b;
    }

    public static double distance(Point p1, Point p2){
        return Math.sqrt(p.p1 + p.p2);
        //d = \/(х2— х1)2 + (y2— y1)2
    }
}

