package iit.iitrc.rahil.cognizance_2016;

/**
 * Created by rahil on 3/13/2016.
 */
public class ScheduleItem {
    String name;
    String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String location;
    String date;
}
