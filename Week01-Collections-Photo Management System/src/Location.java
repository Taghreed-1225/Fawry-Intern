import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class Location {
    private double latitude;
    private double longitude;
   private static Map<String,Location> city=new HashMap<>();

    static {
        city.put("Cairo", new Location(30.0444, 31.2357));
        city.put("Alexandria", new Location(31.2001, 29.9187));
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
     public  String getCity(Location location){

        for (Map.Entry<String,Location> entry: city.entrySet())
        {
            if(abs(entry.getValue().longitude-location.longitude)<0.01&&
                abs(entry.getValue().latitude-location.latitude)<0.01)

                return entry.getKey();
        }

        return "city not found";

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
