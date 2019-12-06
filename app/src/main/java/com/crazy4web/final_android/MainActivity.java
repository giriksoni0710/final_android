package com.crazy4web.final_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputLayout;
    Button button;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdaptor;
    RecyclerView.LayoutManager layoutManager;
    ArrayList redditlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout = findViewById(R.id.textInputEditText);
        button = findViewById(R.id.button);
        redditlist = new ArrayList();
        recyclerView = findViewById(R.id.recyclerview);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                String name = textInputLayout.getText().toString();
                if(redditlist.contains(textInputLayout.getText().toString())){

                    Toast.makeText(getApplicationContext(),"already exists",Toast.LENGTH_SHORT).show();
                }
                else {
                    redditlist.add(textInputLayout.getText().toString());

                }


                mAdaptor = new MyAdaptor(getApplicationContext(),redditlist);
                recyclerView.setAdapter(mAdaptor);
                Log.d("mylist", redditlist.toString());


            }
        });

    }
}
