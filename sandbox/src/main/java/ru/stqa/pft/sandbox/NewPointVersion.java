package ru.stqa.pft.sandbox;

/**
 * Created by tetyana.kostyrkina on 4/13/2016.
  */
public class NewPointVersion {
    private double y;
    private double x;


    public static void main(String[] args) {

        NewPointVersion p1 = new NewPointVersion(6.0, 1);
        NewPointVersion p2 = new NewPointVersion(2, 5.0);

        System.out.println("Distance between " + p1.x + "," + p1.y + " and " + p2.x + "," + p2.y + " are " +
                distance(p1, p2));

       }
    public NewPointVersion(double x, double y) {
        this.x = x;
        this.y = y;

    }
    public static double distance(NewPointVersion p1, NewPointVersion p2){
        return Math.sqrt((p2.x - p1.x)*(p2.x - p1.x) + (p2.y - p1.y)*(p2.y - p1.y));
    }
  }


