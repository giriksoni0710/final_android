package com.crazy4web.final_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class newslistreddit extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdaptor;
    RecyclerView.LayoutManager layoutManager;
    String redit_subname;
    ArrayList<String> dataitems, titlelist;

    private RequestQueue mrequestQue;
    private StringRequest mstringRequest;
    private String url;
    String fifth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newslistreddit);

        recyclerView = findViewById(R.id.populate_redit_recyclerview);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(false);
//        mAdaptor = new MyAdaptor();
//        recyclerView.setAdapter(mAdaptor);
        titlelist = new ArrayList<>();
        Intent i = getIntent();
        redit_subname = i.getStringExtra("textname");

        dataitems = new ArrayList();

        Log.d("subname",redit_subname);

        url = "https://www.reddit.com/r/"+redit_subname+"/.json";
        Log.d("url",url);
        sendandreceivedata(url);

    }

    private void sendandreceivedata(String url) {


        mrequestQue = Volley.newRequestQueue(this);

        mstringRequest = new StringRequest(Request.Method.GET,url,(response) ->{

            dataitems.add(response.toString());

            Log.d("hello","in");


            for(String items : dataitems){


                Log.d("items",items);

                try {



                    JSONObject first = new JSONObject(items);


                    JSONObject second = first.getJSONObject("data");

                    JSONArray third = second.getJSONArray("children");

                    for (int j = 0; j<third.length();j++) {
                        JSONObject fourth = third.getJSONObject(j);

                        fifth = fourth.getJSONObject("data").getString("title");


                        titlelist.add(fifth);
//                        Log.d("length",fifth+"");
                    }

                    Log.d("titlelist",titlelist.toString());



                    recyclerView.setLayoutManager(layoutManager);
                    mAdaptor = new recyclerview_list_reddit(titlelist);
                    recyclerView.setAdapter(mAdaptor);


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }



        }, (error)->{

            Log.d("error", ""+error);
        });

        mrequestQue.add(mstringRequest);


    }

}
