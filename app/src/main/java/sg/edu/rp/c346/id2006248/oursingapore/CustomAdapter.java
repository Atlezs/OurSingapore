package sg.edu.rp.c346.id2006248.oursingapore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Island> islandList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Island> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        islandList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        RatingBar rb = rowView.findViewById(R.id.ratingBar2);
        ImageView iv = rowView.findViewById(R.id.imageView);

        // Obtain the Android Version information based on the position
        Island currentIsland = islandList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentIsland.getTitle());
        String yearString = Integer.toString(currentIsland.getYear());
        tvYear.setText(yearString);
        tvSinger.setHint(currentIsland.getSingers());
        rb.setRating(currentIsland.getStars());
        if(currentIsland.getYear() > 4){
            iv.setVisibility(View.VISIBLE);
        } else {
            iv.setVisibility(View.INVISIBLE);
        }

        return rowView;
    }

}
