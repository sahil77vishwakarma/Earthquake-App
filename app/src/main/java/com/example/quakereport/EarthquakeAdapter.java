package com.example.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";
//    contruct a new Earthquake adpater
//    context of the app
//    Earthquakes are the list of the Earthquakes,which is the data source for the adapter
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes)
    {
        super(context,0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }
//   Find the earthquake at the given position in the list of earthquakes
        //this will helps us to find that about which earthquake we are talking about
        Earthquake currentEarthquakes = getItem(position);

///SECTION FOR THE MAGNITUDE
        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.Magnitude);
        // Format the magnitude to show 1 decimal place
        String formattedMagnitude = formatMagnitude(currentEarthquakes.getMagnitude());
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(formattedMagnitude);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquakes.getMagnitude());

        // Set the color on the magnitude circle
        //magnitudecircle set the color on the Background of the Magnitude textview
        magnitudeCircle.setColor(magnitudeColor);

        ///FOR THE LOCATION SECTION
        //Performing the string split operation
        String originalLocation = currentEarthquakes.getLocation();
        String primaryLocation;
        String locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset ="Near the";
            primaryLocation = originalLocation;
        }
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);


///FOR THE DATE SECTION
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date ( currentEarthquakes.getTimeInMilliseconds());
//  Find the TextView with id date
        TextView dateView =(TextView) listItemView.findViewById(R.id.Date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.Time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);


//   Return the List item view which is now showing the appropriate data
        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        //According to the documentation, the switch statement
        // cannot accept a double value, so we should convert our decimal magnitude value into an integer.
        //We can use the Math class to do some handy mathematical calculations.
        // In this case, we can take the “floor” of the decimal magnitude value.
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        //Remember that color resource IDs just point to the resource we defined, but not the value of the color.
        //You can call ContextCompat getColor() to convert the color resource ID into an actual integer color value
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
