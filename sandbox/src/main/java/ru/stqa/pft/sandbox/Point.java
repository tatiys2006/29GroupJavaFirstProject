package ru.stqa.pft.sandbox;

/**
 * Created by tetyana.kostyrkina on 4/13/2016.
 */
public class Point {
    public double x1;
    public double y1;

    public double x2;
    public double y2;

    public double p1;
    public double p2;

    public Point(double p1, double p2) {
        this.p1 = (x2 - x1)*(x2 - x1);
        this.p2 = (y2 - y1)*(y2 - y1);
    }
}
