package info.androidhive.customlistviewvolley;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.customlistviewvolley.adater.CustomListAdapter;
import info.androidhive.customlistviewvolley.app.AppController;
import info.androidhive.customlistviewvolley.model.JobInfo;

import static info.androidhive.customlistviewvolley.R.menu.main;

public class MainActivity extends /*Activity*/ AppCompatActivity {

    // Log tag
    private static final String TAG = MainActivity.class.getSimpleName();

    // Movies json url
//    private static final String url = "http://api.androidhive.info/json/movies.json";
    private static final String url = "http://5.189.167.148:8080/ProgrammerVacanciesTomcatWithJDK7/jsonView";
    private ProgressDialog pDialog;
//    private List<Movie> movieList = new ArrayList<Movie>();
    private List<JobInfo> vacancyList = new ArrayList<JobInfo>();
    private ListView listView;
    private CustomListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
//        adapter = new CustomListAdapter(this, movieList);
        adapter = new CustomListAdapter(this, vacancyList);
        listView.setAdapter(adapter);

        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color
        /*getActionBar*/getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(Color.parseColor("#1b1b1b")));

        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);

//                                Movie movie = new Movie();
//                                movie.setTitle(obj.getString("title"));
//                                movie.setThumbnailUrl(obj.getString("image"));
//                                movie.setRating(((Number) obj.get("rating"))
//                                        .doubleValue());
//                                movie.setYear(obj.getInt("releaseYear"));
//
//                                // Genre is json array
//                                JSONArray genreArry = obj.getJSONArray("genre");
//                                ArrayList<String> genre = new ArrayList<String>();
//                                for (int j = 0; j < genreArry.length(); j++) {
//                                    genre.add((String) genreArry.get(j));
//                                }
//                                movie.setGenre(genre);

                                JobInfo job = new JobInfo();
                                job.setJobtitle(obj.getString("jobTitle"));
                                job.setCompany(obj.getString("company"));
                                job.setLink(obj.getString("link"));


                                job.setSalary(obj.getString("salary"));
                                job.setPublished(obj.getString("published"));
                                job.setDeadline(obj.getString("deadline"));

                                // adding movie to movies array
//                                movieList.add(movie);
                                vacancyList.add(job);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                JobInfo job = (JobInfo) listView.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(), "link: "+job.getLink(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
                intent.putExtra("link", job.getLink());
                startActivity(intent);
            }
        });


//        MenuItem menuItem = (MenuItem) findViewById(R.id.action_settings);
//        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                finish();
//                startActivity(getIntent());
//
//            }
//        })
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main; this adds items to the action bar if it is present.
        getMenuInflater().inflate(main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                finish();
                startActivity(getIntent());
                return true;
//            case R.id.help:
//                showHelp();
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
