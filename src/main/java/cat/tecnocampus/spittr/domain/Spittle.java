package cat.tecnocampus.spittr.domain;

import java.util.Date;
//import org.apache.commons.lang.builder.EqualsBuilder;

/**
 * Created by roure on 19/07/2016.
 */
public class Spittle {
    private final Long id;
    private final String message;
    private final Date time;
    private final Double latitude;
    private final Double longitude;

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(String message, Date time) {
        this(message,time,null,null);
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        //return EqualsBuilder.reflectionEquals(this, o, "id", "time");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spittle spittle = (Spittle) o;

        if (id != null ? !id.equals(spittle.id) : spittle.id != null) return false;
        return time.equals(spittle.time);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + time.hashCode();
        return result;
    }
}
