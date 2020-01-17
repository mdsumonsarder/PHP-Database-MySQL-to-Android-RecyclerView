package com.example.phpdatabasemysql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<JsonDataList> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView;
        recyclerView = findViewById(R.id.recyclerviewid);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //GridLayoutManager;
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);

        arrayList = new ArrayList<JsonDataList>();

        //JsonFetch Object Create;
        JsonFetch jsonFetch = new JsonFetch();
        jsonFetch.execute();

    }

    public class JsonFetch extends AsyncTask<String,String,String> {

        HttpURLConnection httpURLConnection;
        String mainfile;


        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL("https://api.myjson.com/bins/6w4am");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                String line = "";

                while ((line=bufferedReader.readLine()) != null)
                {

                    stringBuffer.append(line);

                }
                mainfile = stringBuffer.toString();

                JSONArray parent = new JSONArray(mainfile);
                int i=0;

                while (i<=parent.length())
                {

                    JSONObject child = parent.getJSONObject(i);
                    String name = child.getString("user_name");
                    String img = child.getString("user_img");
                    String description = child.getString("user_description");
                    arrayList.add(new JsonDataList(name,img,description));
                    i++;
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            JsonAdapter adapter = new JsonAdapter(arrayList, getApplicationContext(), new Myclick() {
                @Override
                public void onClickMe(View view, int possition) {
                    String link = arrayList.get(possition).getUser_img();
                    Intent i = new Intent(MainActivity.this,Main2Activity.class);
                    i.putExtra("img",link);
                    startActivity(i);
                }
            });
            recyclerView.setAdapter(adapter);


        }
    }
}
