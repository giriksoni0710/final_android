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
import org.json.JSONObject;

import java.util.ArrayList;

public class newslistreddit extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter mAdaptor;
    RecyclerView.LayoutManager layoutManager;
    String redit_subname;
    ArrayList<String> arrayList;

    private RequestQueue mrequestQue;
    private StringRequest mstringRequest;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newslistreddit);

//        recyclerView = findViewById(R.id.recyclerview);
//
//        layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setHasFixedSize(false);
//        mAdaptor = new MyAdaptor();
//        recyclerView.setAdapter(mAdaptor);

        Intent i = getIntent();
        redit_subname = i.getStringExtra("textname");

        arrayList = new ArrayList();

        Log.d("subname",redit_subname);

        url = "https://www.reddit.com/r/"+redit_subname+"/.json";
        Log.d("url",url);
        sendandreceiveData(url);

    }

    private void sendandreceiveData(String url) {
        
        mrequestQue = Volley.newRequestQueue(this);
        mstringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                arrayList.add(response);

                Log.d("response", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(getApplicationContext(),"Your EndPoint doesn't Exist",Toast.LENGTH_SHORT).show();

            }
        });

        mrequestQue.add(mstringRequest);
    }
}
