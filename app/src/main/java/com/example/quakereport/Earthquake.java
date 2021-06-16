package com.example.quakereport;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Earthquake {
public String Location;
/** Time of the earthquake */
private long mTimeInMilliseconds;
private Double Magnitude;
private String Url;


    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *  earthquake happened
     */
public Earthquake(Double magnitude,String location ,long timeInMilliseconds,String url )
{
    Location=location;
    mTimeInMilliseconds = timeInMilliseconds;
    Magnitude=magnitude;
    Url=url;
}

public String getLocation(){
    return Location;
}

public long getTimeInMilliseconds()
{
  return mTimeInMilliseconds;
}

public Double getMagnitude()
{
    return Magnitude;
}
public String getUrl()
{
    return Url;
}
}
