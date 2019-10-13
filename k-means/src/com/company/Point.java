package com.company;

import java.util.Random;

public class Point {

    public double x;
    public double y;
    Random random = new Random();

    public Point(double x,double y){
        this.x=x;
        this.y=y;

    }

    public void setPoint(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Point getPoint(){
        return new Point(x,y);
    }
    public static double euclidDist(Point main,Point centroid){
        double dist=Math.sqrt(Math.pow((main.x-centroid.x),2)+ Math.pow(main.y-centroid.y,2));
            return dist;
    }




    public String toString(){

        return " X : "+x+"  Y : "+y;
    }


}
