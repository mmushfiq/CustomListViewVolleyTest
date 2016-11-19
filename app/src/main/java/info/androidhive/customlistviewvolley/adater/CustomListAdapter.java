package info.androidhive.customlistviewvolley.adater;

/**
 * Created by USER on 11/6/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import info.androidhive.customlistviewvolley.R;
import info.androidhive.customlistviewvolley.app.AppController;
import info.androidhive.customlistviewvolley.model.JobInfo;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
//    private List<Movie> movieItems;
    private List<JobInfo> jobInfo;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListAdapter(Activity activity, /*List<Movie> movieItems*/ List<JobInfo> jobInfo) {
        this.activity = activity;
//        this.movieItems = movieItems;
        this.jobInfo = jobInfo;
    }

    @Override
    public int getCount() {
        return jobInfo.size();
    }

    @Override
    public Object getItem(int location) {
        return jobInfo.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
//        Movie m = movieItems.get(position);
        JobInfo j = jobInfo.get(position);

        // thumbnail image
//        thumbNail.setImageUrl(j.getLink(), imageLoader);
        thumbNail.setImageUrl("http://jobsoriented.com/images/Job-Search.jpg", imageLoader);

        // title
        title.setText(j.getCompany());

        // rating
        rating.setText(j.getJobtitle());

        // genre
//        String genreStr = "";
//        for (String str : m.getGenre()) {
//            genreStr += str + ", ";
//        }
//        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
//                genreStr.length() - 2) : genreStr;
//        genre.setText(j.getPublished()+"/"+j.getDeadline());
        genre.setText(j.getSalary());

        // release year
        year.setText(j.getDeadline());

        return convertView;
    }

}
