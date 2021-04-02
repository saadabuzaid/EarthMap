package Assignment;

public class MapCoordinate implements Comparable {
    double LATITUDE;
    double LONGITUDE;
    double ALTITUDE;

   public MapCoordinate(double Longitude, double Latitude, double Altitude){
        LATITUDE = Latitude;
        LONGITUDE = Longitude;
        ALTITUDE = Altitude;
    }

    public double distanceTo(MapCoordinate Coordinate){
        double X1 = Math.pow(Coordinate.LATITUDE - LATITUDE, 2);
        double Y1 = Math.pow(Coordinate.LONGITUDE - LONGITUDE, 2);
        return Math.sqrt(X1 + Y1) * 100;
    }

    @Override
    public int compareTo(Object obj){
        return 0;
    }

    @Override
    public boolean equals(Object obj){
        return true;
    }

    @Override
    public String toString(){
        return "("+LONGITUDE + "," + LATITUDE + "," + ALTITUDE +")";
    }
}
