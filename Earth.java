package Assignment;

import javafx.geometry.Point3D;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Earth {
    private double[][] arrayofEarth;
    /* The first dimension is the coordinate number starting from 0;
   THe first column is the  longitude, the second one is the latitude, and the third one is the altitude
    */

    public void readDataArray(String filename) throws FileNotFoundException {

            Scanner FileData = new Scanner(new File("src/Assignment/" + filename));
            arrayofEarth = new double[2336041][3];
            // Initiating the array size
            int parameter = 0;
            int index = 0;
            //Initiated these variables to control the array(to assign the correct element in the array)
            //I can use FOR LOOP, but I am trying to use as many different methods as possible
            while (FileData.hasNextDouble()) {
                arrayofEarth[index][parameter] = FileData.nextDouble();
                parameter++;
                if (parameter == 3) {
                    parameter = 0;
                    index++;
                }
            }
            FileData.close();
        }

        // To catch if there is an Error opening the file



    public List<Point3D> CoordinatesAbove(Double altitude) {
        List<Point3D> CoordinatesAbove = new ArrayList<>();
        for (int i = 0; i <= 2336040; i++) {
            if (altitude <  arrayofEarth[i][2]) {
                CoordinatesAbove.add(new Point3D(arrayofEarth[i][0], arrayofEarth[i][1], arrayofEarth[i][2]));
            }
        }
        //System.out.println(CoordinatesAbove);
        return CoordinatesAbove;
    }

    public List<Point3D> CoordinatesBelow(Double altitude) {
        List<Point3D> CoordinatesBelow = new ArrayList<>();
        for (int i = 0; i <= 2336040; i++) {
            if (altitude >  arrayofEarth[i][2]) {
                CoordinatesBelow.add(new Point3D(arrayofEarth[i][0], arrayofEarth[i][1], arrayofEarth[i][2]));
            }
        }
        return CoordinatesBelow;
    }

    public void percentageAbove(Double altitude) {
        double sum = CoordinatesAbove(altitude).size() + CoordinatesBelow(altitude).size();
        double percentageAbove = (CoordinatesAbove(altitude).size() / sum) * 100;
        System.out.printf("The Percentage of the coordinates above %.1f is %.1f%%\n ", altitude, percentageAbove);
    }

    public void percentageBelow(Double altitude) {
        double sum = CoordinatesAbove(altitude).size() + CoordinatesBelow(altitude).size();
        double percentageBelow = (CoordinatesBelow(altitude).size() / sum) * 100;
        System.out.printf("The Percentage of the coordinates above %.1f is %.1f%% \n ", altitude, percentageBelow);
    }

    private Map<Integer, Point3D> mapOfEarth = new TreeMap<Integer, Point3D>();

    public void readDataMap(String fileName) throws FileNotFoundException {
        Scanner FileData = new Scanner(new File("src/Assignment/" + fileName));
        for (int index = 0; index < 2336041; index++) {
            mapOfEarth.put(index, new Point3D(FileData.nextDouble(), FileData.nextDouble(), FileData.nextDouble()));
        }

       //System.out.println(mapOfEarth);
    }

    public Map<Integer, Point3D> getMap(){
        return mapOfEarth;
    }

    public double getAltitude(double longitude, double latitude) {
        Point3D value;
        double altitude = 0.0;
        for (int i = 0 ; i < 2336041; i++) {
            value = mapOfEarth.get(i);
            if (value.getX() == longitude && value.getY() == latitude) {
                altitude = value.getZ();
           }
        }
       // System.out.println(altitude);
        return altitude;
    }
}





    




