package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cluster {
    public List points;
    public Point Centroid;


    public Cluster(int min,int max){
        points=new ArrayList();


        this.CreateRandomCentroids(min,max);
    }

    public Cluster(){
        points=new ArrayList();

    }
    public List getPoints() {
        return points;
    }


    public void setPoints(List points) {
        this.points = points;
    }

    public void addP(Point point){ points.add(point); }

    public void removeP(Point point){
        points.remove(point);
    }

    public Point CreateRandomCentroids(int min, int max){
        Random random=new Random();
        double rand1 = min + (max - min) * random.nextDouble();
        double rand2 = min + (max - min) * random.nextDouble();
        Point nokta=new Point(rand1,rand2);
        this.Centroid=nokta;
        return nokta;
    }
}
