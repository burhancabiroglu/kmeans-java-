package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Point> allpoint=new ArrayList<>();

        String row;
        BufferedReader csvReader;
        double d1;
        double d2;

        try {
            csvReader=new BufferedReader(new FileReader("data.csv"));
            row=csvReader.readLine();
            while ((row=csvReader.readLine())!=null){
                String[] data=row.split(",");
                d1=Double.parseDouble(data[1]);
                d2=Double.parseDouble(data[2]);
                allpoint.add(new Point(d1,d2));
            }
        }

        catch (Exception e){
            System.out.println("dosya yolu bulunmadı");
        }



        System.out.print("Cluster Sayısını giriniz: ");
        Scanner scan=new Scanner(System.in);
        int s=scan.nextInt();

        Cluster[] clusters=new Cluster[s];

        for (int i=0;i<s;i++){

            clusters[i]=new Cluster(0,8);
            System.out.println((i+1)+". Küme olusturuldu ve merkezi : "+clusters[i].Centroid);
        }

        System.out.print("\niterasyon sayısını giriniz: ");
        int ite=scan.nextInt();
        int ksize=allpoint.size();




        for (int i=0;i<ite;i++){
            for (int n=0;n<s;n++){
                clusters[n].points.clear();

            }

            for (int j=0;j<ksize;j++){


                List distances=new ArrayList();


                for (int b=0;b<s;b++){
                    double edist=0;
                    edist=Point.euclidDist(clusters[b].Centroid,allpoint.get(j));

                    distances.add(edist);

                }


                twodat detan=findMin(distances);

                clusters[detan.index].addP(allpoint.get(j));



            }
            //Centroidler yenilenecek

            for(int y=0;y<s;y++){
                double topx=0;
                double topy=0;
                double ort=0;
                if(!clusters[y].points.isEmpty()){
                    for (int t=0;t<clusters[y].points.size();t++){
                        Point deneme= (Point) clusters[y].getPoints().get(t);
                        topx+=deneme.x;
                        topy+=deneme.y;

                    }
                    clusters[y].Centroid.setPoint(topx/clusters[y].points.size(),topy/clusters[y].points.size());
                }

            }
        }


        System.out.println("küme merkezi:"+clusters[0].Centroid+  " Eleman Sayısı: "+clusters[0].points.size());
        System.out.println("küme merkezi:"+clusters[1].Centroid+  " Eleman Sayısı: "+clusters[1].points.size());
        System.out.println("küme merkezi:"+clusters[2].Centroid+  " Eleman Sayısı: "+clusters[2].points.size());





    }


    public static class twodat{
        public int index;
        public double min;


        public twodat(int index,double min){
            this.min=min;
            this.index=index;
        }

    }
    public static twodat findMin(List list){
        double min=100000000;
        int indexim=0;

        for (int i=0;i<list.size();i++){
            if((double)list.get(i) < min){
                min= (double)list.get(i);
                indexim=i;
            }
        }
        twodat data=new twodat(indexim,min);

        return data;
    }
}
