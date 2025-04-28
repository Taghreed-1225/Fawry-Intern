

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class Photo {
   private String name;
   private LocalDate date;
   private Location location;

    public Photo(String name,Location location) {
        this.name = name;
        this.date = LocalDate.now();
        this.location=location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", location=" + location +
                '}';
    }
}
