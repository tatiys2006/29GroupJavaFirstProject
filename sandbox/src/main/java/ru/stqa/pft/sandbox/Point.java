package ru.stqa.pft.sandbox;

/**
 * Created by tetyana.kostyrkina on 4/13/2016.
  */
public class Point {
    public double x1;
    public double y1;
    public double x2;
    public double y2;



    public static void main(String[] args) {
       
        Point p = new Point(1.0, 1, 2, 1.0);

        System.out.println("Distance between " + p.x1 + "," + p.y1 + " and " + p.x2 + "," + p.y2 + " are " +
                p.distance());
        
       }
    public Point(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double distance(){
        return Math.sqrt((this.x2 - this.x1)*(this.x2 - this.x1) + (this.y2 - this.y1)*(this.y2 - this.y1));
    }
  }


